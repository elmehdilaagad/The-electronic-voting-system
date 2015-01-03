package implementationVoteSimple

import Gvote.AbstractElecteur
import Gvote.Candidat
import Gvote.SystemGeneralDecomptage

class Electeur(_id: Int, var login : String, _nom : String , _prenom: String, var password : String)
		extends AbstractElecteur(_id,_nom,_prenom){
	type ImplVote = Vote
	type ImplSystemeDecomptage = SystemeDecomptageUninominal
  
	def voter(systemeElection : SystemeDecomptageUninominal, candidat : Candidat) : Boolean = {
		val vote : Vote = new Vote(this,systemeElection,candidat)
		if(systemeElection.ajouterVote(vote)){
			mesVotes = mesVotes:+vote
			return true
		}
		else{
			return false
		}
	}
	
	def voter(systemeElection : SystemeDeComptageSemiProportionel, candidat : Candidat) : Boolean = {
		val vote : Vote = new Vote(this,systemeElection,candidat)
		if(systemeElection.ajouterVote(vote)){
			mesVotes = mesVotes:+vote
			return true
		}
		else{
			return false
		}
	}
	
	def voter(systemeElection : SystemDeComptageProportionel, candidat : Candidat) : Boolean = {
		val vote : Vote = new Vote(this,systemeElection,candidat)
		if(systemeElection.ajouterVote(vote)){
			mesVotes = mesVotes:+vote
			return true
		}
		else{
			return false
		}
	}
	
	def voter(systemeElection : SystemeDecomptageUninominal, candidats : List[Candidat]) : Boolean = {
	    return false
	}
	
	
}