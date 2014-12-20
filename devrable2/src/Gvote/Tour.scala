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
	
	private def comptabiliser(){
		var listCandidat : List[Candidat] = election.listCandidat
		var cpt : Int = 0
		
		for(candidat <- listCandidat){
			cpt = getNbVote(candidat)
			tabCandidatVote = tabCandidatVote:+(candidat,cpt)
		}
	  	
	}
	
	def cloturer(){
	  actifTour = true
	}
	
	def getCandidatAtPos(pos : Int) : Candidat = {
	   comptabiliser()
	   var position : Int = 0
		var max : Int = tabCandidatVote.head._2 
		var candidatVoteCourant : (Candidat,Int) = null
		var listCandidat : List[Candidat] = election.listCandidat
		
		var it : Iterator[(Candidat,Int)] = tabCandidatVote.iterator
		
		
		
		while(it.hasNext){
			 
			for(candidatVote <- tabCandidatVote){
				candidatVoteCourant = it.next
				if(candidatVoteCourant._1.id != candidatVote._1 .id
				    && candidatVoteCourant._2 < candidatVote._2){
				  position+=1
				}
			}
		  
			if(position==pos) return candidatVoteCourant._1 
		}
		
		return null
	}

	def getNbVote(_candidat : Candidat) : Int = {
		
		var cpt : Int = 0
		for(vote <- voteList){
			 if(vote.candidat.id ==_candidat.id )
				 cpt+= 1
		}
		
		return cpt
	}
	
}