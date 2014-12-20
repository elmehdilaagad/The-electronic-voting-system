package Gvote

class Election(_modeScrutin : ModeScrutin){

	val modeScrutin = _modeScrutin 
	var listVotant  : List[Electeur] = List(); 
	var listCandidat: List[Candidat] = List()
	var tourList : List[Tour] = List(new Tour(this))
	var tourCourant : Int  = 0;
	var isFinish : Boolean = false ; 
	var sePresenter = true ; 
	var voter = false ; 
	
	def this(modeScrutin : String, nbTour : Int, listGagnantParTour : List[Int]  ,visibiliteVote : String ){
		this(new  ModeScrutin(modeScrutin, nbTour, listGagnantParTour,visibiliteVote));
	}
	
	def fermerCandidature{ sePresenter = false } 

	def ouvertureVote() {voter=true }
	def fermetureVote():Boolean ={
	  if(voter){
	    voter = false ; 
	    return true ; 
	  }else 
	    return false 
	}
	
	def addCandidat(c : Candidat){
	  if(sePresenter )
	  listCandidat = listCandidat:+c
	}

	def removeCandidat(c : Candidat){
		listCandidat.dropWhile(_ == c)
	}

	def ajouterVote(vote : Vote) : Boolean = {
		
	  if(!voter || listVotant.contains(vote.electeur)){
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
	  
	  var candidatGagnants :List[Candidat] = SystemeDecomptage.getGagnants(this)
	  
	  for(candidat <- listCandidat){
	    if(!candidatGagnants.contains(candidat)){
	    	listCandidat.dropWhile(_ == candidat)
	    }
	  }
	  
	  tourList = tourList:+(new Tour(this))
	}
	
}