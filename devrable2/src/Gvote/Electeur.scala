package Gvote

class Electeur( _id: Int, var login : String, _nom : String , _prenom: String, var password : String){
	
	val id = _id
	val nom = _nom
	val prenom = _prenom
	var mesVotes : List[Vote] = List()
  
	def voter(election : Election, candidat : Candidat) : Boolean = {
		var vote : Vote = new Vote(this,election,candidat)
		if(election.ajouterVote(vote)){
			mesVotes = mesVotes:+vote
			return true
		}
		else{
			return false
		}
	}
}