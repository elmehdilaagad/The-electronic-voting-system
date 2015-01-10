package implementationMixte
import Gvote._
import implementationProportionnel._
import implementationVoteSimple.Vote

class VoteMixte(_electeur : ElecteurMixte ,_systemeElection:SystemeDecomptageMixte ,_candidat: Candidat, _parti: Parti) extends AbstractVote(_electeur,_systemeElection){
	
  
  val voteuni : Vote = new Vote(_electeur.elecUni,_systemeElection.uninominal,_candidat);
  val votepro : VoteProportionnel = new VoteProportionnel(_electeur.elecPro,_systemeElection.proportionnel,_parti);
  
}