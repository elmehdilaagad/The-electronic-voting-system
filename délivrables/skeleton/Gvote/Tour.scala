package Gvote

class Tour(_election : Election) {
	val election = _election
	var voteList : List[Vote] = List()
	var tabCandidatVote : List[(Candidat,Int)] = List()
	var isFinish : Boolean = false
	
	def addVote(vote : Vote){
	  voteList = voteList:+vote  
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
	  comptabiliser()
	}
	
	def getCandidatAtPos(pos : Int) : Candidat = {
		// a finir
	  
		return null
	}

	def getNbVote(_candidat : Candidat) : Int = {
		
		var cpt : Int = 0
		for(vote <- voteList){
			 if(vote.candidat.equals(_candidat))
				 cpt+= 1
		}
		
		return cpt
	}
	
}