package implementationUninominale

import Gvote.AbstractVote
import Gvote.Candidat
import Gvote.SystemGeneralDecomptage

class Vote(_electeur : Electeur, _system : SystemGeneralDecomptage, _candidat : Candidat) extends AbstractVote(_electeur, _system){
	val candidat = _candidat
}
