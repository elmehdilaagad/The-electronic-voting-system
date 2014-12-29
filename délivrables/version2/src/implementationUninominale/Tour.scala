package implementationUninominale

import Gvote.AbstractTour
import Gvote.Candidat

class Tour(_election : Election) extends AbstractTour(_election) {
	type ImplVote = Vote

	def addVote(vote : Vote) : Boolean = {
	  if(actifTour){
		  voteList = voteList:+vote
		  return true
	  }
	  return false
	}
	
	def getNbVote(_candidat : Candidat) : Int = {
			  
		var cpt : Int = 0
		for(vote <- voteList){
			 if(vote.candidat.id ==_candidat.id ){
				 cpt+= 1
			 }
		}
		
		return cpt
	}
	
}