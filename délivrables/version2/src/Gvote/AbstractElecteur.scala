package Gvote


abstract class AbstractElecteur(_id: Int, _nom : String , _prenom: String){
	type ImplVote <: AbstractVote
	type ImplSystemeDecomptage <: SystemGeneralDecomptage
  
	val id = _id
	val nom = _nom
	val prenom = _prenom
	var mesVotes : List[ImplVote] = List()
	
	def voter(systemeElection : ImplSystemeDecomptage, candidat : Candidat) : Boolean
	def voter(systemeElection : ImplSystemeDecomptage, candidats : List[Candidat]) : Boolean
}