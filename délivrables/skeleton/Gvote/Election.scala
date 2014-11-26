package Gvote

class Election(_parametres : ModeScrutin){

	val parametres = _parametres 
	var listVotant  : List[Electeur] = List(); 
	var listCandidat: List[Candidat] = List()
	var tourList : List[Tour] = List(new Tour(this))
	var tourCourant : Int  = 0;
	
	def this(modeScrutin : String, nbTour : Int, listGagnantParTour : List[Int] ){
		this(new  ModeScrutin(modeScrutin, nbTour, listGagnantParTour));
	}
	
	def addCandidat(c : Candidat){
		listCandidat = listCandidat:+c
	}

	def removeCandidat(c : Candidat){
		listCandidat.dropWhile(_ == c)
	}

	def ajouterVote(vote : Vote) : Boolean = {
		if(listVotant.contains(vote.electeur)){
		  return false
		}
		else{
			var tour : Tour = tourList.last
			tour.addVote(vote)
			return true
		}
	}
	
	def runTour(){
	  tourList.last.cloturer()
	  tourCourant+=1
	  
	  var candidatGagnants :List[Candidat] = SystemeDecomptage(this)
	  
	  
	  
	  tourList = tourList:+(new Tour(this))
	}
	
}