package Gvote


abstract class AbstractTour(_election : AbstractElection) {
	type ImplVote <: AbstractVote
  
	val election = _election
	protected var voteList : List[ImplVote] = List()
	protected var actifTour : Boolean  = false;
	
	def lancerTour(){
	  actifTour = true
	}
	
	def cloturer(){
	  actifTour = false
	}
	
	def addVote(vote : ImplVote) : Boolean
	
	def getNbVoteTotal() : Int = {
	  return voteList.length
	}
	
}