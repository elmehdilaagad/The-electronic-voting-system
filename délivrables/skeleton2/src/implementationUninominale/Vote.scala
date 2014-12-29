package implementationUninominale

import Gvote.AbstractVote
import Gvote.Candidat

class Vote(_electeur : Electeur, _system : SystemeDecomptageUninominal, _candidat : Candidat) extends AbstractVote(_electeur, _system){
	val candidat = _candidat
}
