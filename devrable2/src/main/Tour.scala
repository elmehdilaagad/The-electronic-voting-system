package Gvote

class Tour(_election : Election) {
	val election = _election
	var voteList : List[Vote] = List()
	var tabCandidatVote : List[(Candidat,Int)] = List()
	var isFinish : Boolean = false
	
	def addVote(vote : Vote){
	  if(!isFinish){
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
	  isFinish = true
	}
	
	def getCandidatAtPos(pos : Int) : List[Candidat] = {
	    
		comptabiliser()
		var position : Int = 0
		var max : Int = tabCandidatVote.head._2 
		var candidatVoteCourant : (Candidat,Int) = null
		var listCandidat : List[Candidat] = election.listCandidat
		var listCandidatAtPos : List[Candidat] = List()
		
		var it : Iterator[(Candidat,Int)] = tabCandidatVote.iterator
		
		while(it.hasNext){
			 
			for(candidatVote <- tabCandidatVote){
				candidatVoteCourant = it.next
				if(candidatVoteCourant._1.id != candidatVote._1 .id
				    && candidatVoteCourant._2 < candidatVote._2){
				  position+=1
				}
			}
		  
			if(position==pos){
			  listCandidatAtPos = listCandidatAtPos:+candidatVoteCourant._1
			}  
		}
		
		return listCandidatAtPos
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