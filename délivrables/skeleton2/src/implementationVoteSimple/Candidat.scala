package implementationVoteSimple

import Gvote.Eligible
import Gvote.SystemGeneralDecomptage

class Candidat(_id : Int, _nom :String , _prenom : String , _parti : Parti) extends Eligible(_id, _nom){

    //type ImplSysteme = SystemeDecomptageSimple
  
    val prenom = _prenom
	var parti : Parti = _parti
	
	def sePresenter(systemeElection : SystemGeneralDecomptage) : Boolean = {
		return systemeElection.ajouterCandidat(this)
	}
	
}