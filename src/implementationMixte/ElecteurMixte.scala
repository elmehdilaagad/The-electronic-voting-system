package implementationMixte
import Gvote._
import implementationVoteSimple._
import implementationProportionnel._
import implementationMixte._
class ElecteurMixte(_id: Int, var login : String, _nom : String , _prenom: String, var password : String)
extends AbstractElecteur(_id,_nom,_prenom){ 

  type ImplSystemeDecomptage = SystemeDecomptageMixte
  type Candidate1 =Parti 
  type Candidate2 =Candidat

	val elecUni : Electeur = new Electeur(_id,login,_nom,_prenom,password);
	val elecPro : ElecteurProportionnel = new ElecteurProportionnel(_id,login,_nom,_prenom,password);


   def voter(systemeElection : SystemeDecomptageMixte, candidat : Candidate) : Boolean = {
    return false
  }
  
  def voter(systemeElection : SystemeDecomptageMixte, candidats : List[Candidate]) : Boolean = {
    return false
  }
  
  def voter(systemeElection : SystemeDecomptageMixte, c : (Parti,Candidat)) : Boolean ={
  
    val univote : Vote = new Vote(this.elecUni,systemeElection.uninominal,c._2);
    val propovote : VoteProportionnel = new VoteProportionnel(this.elecPro,systemeElection.proportionnel,c._1);      
    
    return systemeElection.uninominal.ajouterVote(univote) && systemeElection.proportionnel.ajouterVote(propovote) ;
    
  }

}