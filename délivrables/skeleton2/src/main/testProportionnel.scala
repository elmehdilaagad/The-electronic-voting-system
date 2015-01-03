package main

import implementationVoteSimple.SystemDeComptageProportionel
import Factory.FactorySemiProportionnel
import Factory.FactoryProportionnel
import Gvote.Candidat
import implementationVoteSimple.Electeur

object testProportionnel {

  def main(args : Array[String]) : Unit = {
    
    FactoryProportionnel.numberOfSeat = 9;
    var system : SystemDeComptageProportionel = FactoryProportionnel.createCoutingSystem;
    
    system.initElection;
    
    val candidat1 = new Candidat(1 , "PartieA" ,"candidat1" ,"liberte1")
	candidat1.sePresenter(system);
	val candidat2 = new Candidat(2 , "PartieB" ,"candidat2" ,"liberte2")
	candidat2.sePresenter(system);
	val candidat3 = new Candidat(3 , "PartieC" ,"candidat3" ,"liberte3")
	candidat3.sePresenter(system);
    val candidat4 = new Candidat(4, "PartieD" ,"candidat4" ,"liberte4")
	candidat4.sePresenter(system);
   
    system.cloturerCandidature;
    
    val elec1 = new  Electeur (1 , "login1","nom1","prenom1","password1");
	val elec2 = new  Electeur (2 , "login2","nom2","prenom2","password2");
	val elec3 = new  Electeur (3 , "login3","nom3","prenom3","password3");
	val elec4 = new  Electeur (4 , "login4","nom4","prenom4","password4");
	val elec5 = new  Electeur (5 , "login5","nom5","prenom5","password5");
	val elec6 = new  Electeur (6 , "login6","nom6","prenom6","password6");
    val elec7 = new  Electeur (7 , "login7","nom7","prenom7","password7");
	val elec8 = new  Electeur (8 , "login8","nom8","prenom8","password8");
	val elec9 = new  Electeur (9 , "login9","nom9","prenom9","password9");
	val elec10 = new  Electeur (10 , "login10","nom10","prenom10","password10");
	
	elec1.voter(system, candidat1);
    elec2.voter(system, candidat1);
    elec3.voter(system, candidat1);
    elec4.voter(system, candidat1);
    elec5.voter(system, candidat1);
    elec6.voter(system, candidat2);
    elec7.voter(system, candidat2);
    elec8.voter(system, candidat3);
    elec9.voter(system, candidat3);
    elec10.voter(system, candidat4);
    
    system.runTour;
  //println(system.getGagnants.length);
    for(gagnants <- system.getGagnants){
      println(gagnants._1.nom  + " a obtenu "+gagnants._2.intValue + " sièges");
    }
    
  }
}