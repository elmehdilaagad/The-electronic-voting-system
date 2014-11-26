package Gvote

class Candidat(_nom :String , _prenom : String , _slogan : String){
	val nom = _nom
	val prenom = _prenom
	val slogan = _slogan
	
	def sePresenter(election : Election){
		election.addCandidat(this);
	}
	
}