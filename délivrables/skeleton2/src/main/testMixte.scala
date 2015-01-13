package main

import Gvote._
import implementationProportionnel._
import implementationVoteSimple._
import Factory._
import implementationMixte._

object testMixte {
	def main(args: Array[String]): Unit = {
			var  systeme : SystemeDecomptageMixte = FactoryMixte.createCoutingSystem;
      systeme.proportionnel.numberOfSeat = 250;
	println(systeme.nom);
	systeme.initElection;


	val partiA : Parti = new Parti(0, "PartiA");
	partiA.sePresenter(systeme.proportionnel);
	val partiB : Parti = new Parti(1,"PartiB");
	partiB.sePresenter(systeme.proportionnel);
	val partiC : Parti = new Parti(2,"PartiC");
	partiC.sePresenter(systeme.proportionnel);
	val partiD : Parti = new Parti(3,"PartiD");
	partiD.sePresenter(systeme.proportionnel);

	val candidat1 = new Candidat(1 , "candidat1" ,"candidat1" ,partiA);
	candidat1.sePresenter(systeme.uninominal);
	val candidat2 = new Candidat(2 , "candidat2" ,"candidat2" ,partiA);
	candidat2.sePresenter(systeme.uninominal);
	val candidat3 = new Candidat(3 , "candidat3" ,"candidat3" ,partiA);
	candidat3.sePresenter(systeme.uninominal);
	val candidat4 = new Candidat(4, "candidat4" ,"candidat4" ,partiA); 
	candidat4.sePresenter(systeme.uninominal);


	partiA.addCandidat(candidat1);
	partiA.addCandidat(candidat2);
	partiA.addCandidat(candidat3);
	partiA.addCandidat(candidat4);


	val candidat5 = new Candidat(5 , "candidat5" ,"candidat5" ,partiB);
	val candidat6 = new Candidat(6 , "candidat6" ,"candidat6" ,partiB);
	val candidat7 = new Candidat(7 , "candidat7" ,"candidat7" ,partiB);
	val candidat8 = new Candidat(8, "candidat8" ,"candidat8" ,partiB); 


  partiB.addCandidat(candidat5);
  partiB.addCandidat(candidat6);
  partiB.addCandidat(candidat7);
  partiB.addCandidat(candidat8);
  
  
  
  val candidat9 = new Candidat(9 , "candidat9" ,"candidat9" ,partiC);
  val candidat10 = new Candidat(10 , "candidat10" ,"candidat10" ,partiC);
  val candidat11 = new Candidat(11 , "candidat11" ,"candidat11" ,partiC);
  val candidat12 = new Candidat(12, "candidat12" ,"candidat12" ,partiC);
  
  
  
  partiC.addCandidat(candidat9);
  partiC.addCandidat(candidat10);
  partiC.addCandidat(candidat11);
  partiC.addCandidat(candidat12);
  
  
  val candidat13 = new Candidat(13 , "candidat13" ,"candidat13" ,partiD);
  val candidat14 = new Candidat(14 , "candidat14" ,"candidat14" ,partiD);
  val candidat15 = new Candidat(15 , "candidat15" ,"candidat15" ,partiD);
  val candidat16 = new Candidat(16, "candidat16" ,"candidat16" ,partiD); 
  
  
  
  partiD.addCandidat(candidat13);
  partiD.addCandidat(candidat14);
  partiD.addCandidat(candidat15);
  partiD.addCandidat(candidat16);
  

  
  
  
  
   val candidatU1 = new Candidat(20 , "candidatU1" ,"candidatU1" ,partiA);
  candidatU1.sePresenter(systeme.uninominal);
  val candidatU2 = new Candidat(21 , "candidatU2" ,"candidatU2" ,partiB);
  candidatU2.sePresenter(systeme.uninominal);
  val candidatU3 = new Candidat(22 , "candidatU3" ,"candidatU3" ,partiC);
  candidatU3.sePresenter(systeme.uninominal);
  val candidatU4 = new Candidat(23, "candidatU4" ,"candidatU4" ,partiD); 
  candidatU4.sePresenter(systeme.uninominal);
   
  
  systeme.cloturerCandidature;

  
  val elec1 = new  ElecteurMixte (1 , "login1","nom1","prenom1","password1");
  val elec2 = new  ElecteurMixte (2 , "login2","nom2","prenom2","password2");
  val elec3 = new  ElecteurMixte (3 , "login3","nom3","prenom3","password3");
  val elec4 = new  ElecteurMixte (4 , "login4","nom4","prenom4","password4");
  val elec5 = new  ElecteurMixte (5 , "login5","nom5","prenom5","password5");
  val elec6 = new  ElecteurMixte (6 , "login6","nom6","prenom6","password6");
  val elec7 = new  ElecteurMixte (7 , "login7","nom7","prenom7","password7");
  
  
  
  
    println("Vote");

    
  elec1.voter(systeme,(partiA,candidatU1));
  elec2.voter(systeme,(partiA,candidatU1));
  elec3.voter(systeme,(partiB,candidatU2));
  elec4.voter(systeme,(partiA,candidatU3));
  elec5.voter(systeme,(partiA,candidatU1));
  elec6.voter(systeme,(partiB,candidatU2));
  elec7.voter(systeme,(partiD,candidatU4));
  
  
  
  systeme.runTour();
  
  var listgagnant : List[(Parti,Int)] = systeme.getGagnants();
  println("list gagan "+listgagnant.length )
  for(gagnant <- listgagnant){
    println(" Parti "+gagnant._1.nom+" a gagn�  "+gagnant._2+" si�ges");
  }
    
  
  
  

	}
}