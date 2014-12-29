package Gvote


class Candidat(_id : Int, _nom :String , _prenom : String , _slogan : String){
	val id = _id
    val nom = _nom
	val prenom = _prenom
	val slogan = _slogan
	
	def sePresenter(systemeElection : SystemGeneralDecomptage) : Boolean = {
		return systemeElection.ajouterCandidat(this);
	}
	
}