package Gvote

class Tour(_election : Election) {
	val election = _election
	var voteList : List[Vote] = List()
	var tabCandidatVote : List[(Candidat,Int)] = List()
	var actifTour : Boolean  = false ; 
	
	def addVote(vote : Vote){
	  if(!actifTour ){
		  voteList = voteList:+vote  
	  }
	}
	
	def getNbVote(_candidat : Candidat) : Int = {
		
		var cpt : Int = 0
		for(vote <- voteList){
			 if(vote.candidat.id ==_candidat.id ){
				 cpt+= 1
				 
				 println(vote.electeur .nom +" vote pour "+vote.candidat .nom )
			 }
		}
		
		return cpt
	}
	
	private def comptabiliser(){
		var listCandidat : List[Candidat] = election.listCandidat
		var cpt : Int = 0
		
		for(candidat <- listCandidat){
			cpt = getNbVote(candidat)
			tabCandidatVote = tabCandidatVote:+(candidat,cpt)
			println(""+candidat.nom+"  a "+cpt+" voix, taille de la liste des votes "+voteList.length)
			
		}
	  	
	}
	
	def cloturer(){
	  actifTour = true
	}
	
	def getCandidatAtPos(pos : Int) : List[Candidat] = {
	    
		var position : Int = 0
		var candidatVoteCourant : (Candidat,Int) = null
		var listCandidat : List[Candidat] = election.listCandidat
		var listCandidatAtPos : List[Candidat] = List()
		comptabiliser()	
		//var max : Int = tabCandidatVote.head._2 
		
		var it : Iterator[(Candidat,Int)] = tabCandidatVote.iterator
		
		while(it.hasNext){
			 candidatVoteCourant = it.next
			for(candidatVote <- tabCandidatVote){
				println("test: "+candidatVoteCourant._2 +"<" +candidatVote._2 )
				if(candidatVoteCourant._1.id != candidatVote._1 .id
				    && candidatVoteCourant._2 < candidatVote._2){
				  position+=1
				}
			}
			 println(" test candidat termine ")
				if(position==pos){
					listCandidatAtPos = listCandidatAtPos:+candidatVoteCourant._1
					println("ok,candidat:"+candidatVoteCourant._1.nom +", taille liste "+listCandidatAtPos.length);
				}  
		}
		
		return listCandidatAtPos
	}

}