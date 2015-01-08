package implementationProportionnel

import Gvote.AbstractVote
import implementationVoteSimple.Electeur
import Gvote.Parti
//import implementationProportionnel.SystemDeComptageProportionel

final class VoteProportionnel(_electeur : ElecteurProportionnel,_systemeProp : SystemDeComptageProportionel, _parti : Parti) extends AbstractVote(_electeur,_systemeProp){
  val parti = _parti;
}