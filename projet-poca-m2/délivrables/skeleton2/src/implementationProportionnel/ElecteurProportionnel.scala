package implementationProportionnel

import Gvote._
//import implementationProportionnel.SystemDeComptageProportionel

 final class ElecteurProportionnel(_id: Int, var login : String, _nom : String , _prenom: String, var password : String)extends AbstractElecteur(_id,_nom,_prenom){
  type ImplVote = VoteProportionnel
  type ImplSystemeDecomptage = SystemDeComptageProportionel
  type Candidate = Parti
  
  def voter(systemeElection : ImplSystemeDecomptage, candidat : Candidat) : Boolean = {
  return false 
  }
  
  def voter(systemeElection : ImplSystemeDecomptage, candidats : Parti ): Boolean = {
    var vote : VoteProportionnel = new VoteProportionnel(this,systemeElection,candidats)
    if(systemeElection.ajouterVote(vote)){
      mesVotes = mesVotes:+vote
      return true
    }
    else{
      return false
    }
  }
  
  
    def voter(systemeElection : ImplSystemeDecomptage, candidats : List[Candidate]) : Boolean = {
      return false;
    }


}