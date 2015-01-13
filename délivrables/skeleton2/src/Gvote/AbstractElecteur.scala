package Gvote


abstract class AbstractElecteur(_id: Int, _nom : String , _prenom: String){
	type ImplVote <: AbstractVote
	type ImplSystemeDecomptage <: SystemGeneralDecomptage
	type Candidate <: Eligible
	type Candidate1 <: Eligible
  	type Candidate2 <: Eligible
  
	val id = _id
	val nom = _nom
	val prenom = _prenom
	var mesVotes : List[ImplVote] = List()
	
	def voter(systemeElection : ImplSystemeDecomptage, candidat : Candidate) : Boolean
	def voter(systemeElection : ImplSystemeDecomptage, candidats : List[Candidate]) : Boolean
	def voter(systemeElection : ImplSystemeDecomptage, candidats : (Candidate1,Candidate2)) : Boolean