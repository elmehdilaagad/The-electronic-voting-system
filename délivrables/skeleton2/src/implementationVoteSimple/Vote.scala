package implementationVoteSimple

import Gvote.AbstractVote

class Vote(_electeur : Electeur, _system : SystemeDecomptageSimple, _candidat : Candidat) extends AbstractVote(_electeur, _system){
	val candidat = _candidat
}
