package implementationProportionnel

import implementationVoteSimple.Election
import Gvote.AbstractElection
import Gvote.AbstractTour
import Gvote.Parti


class TourProportionnel(_election : ElectionProportionnel) extends AbstractTour(_election){
  type ImplVote = VoteProportionnel;
  
  def getNbVote(_parti : Parti) : Int = {
    
    var cpt : Int = 0
    for(vote <- voteList){
       if(vote.parti.id == _parti.id ){
         cpt+= 1
       }
    }
    
    return cpt
  }

}