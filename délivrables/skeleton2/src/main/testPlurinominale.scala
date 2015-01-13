package main

import Factory._
import Gvote._
import implementationPlurinominale._
object  testPlurinominale {
	 def main(args: Array[String]): Unit = {
	   
        var  systeme : SystemeDecomptagePlurinomial = FactoryPlurinominal.createCoutingSystem(2, List(2,1))
		println(systeme.nom)
        systeme.initElection
        var ump : Parti =    new Parti(1 , "UMP")
        val candidat1 = new Candidat(1 , "candidat1" ,"candidat1"  , ump)
		candidat1.sePresenter(systeme)
		val candidat2 = new Candidat(2 , "candidat2" ,"candidat2" , ump)
		candidat2.sePresenter(systeme)
		val candidat3 = new Candidat(3 , "candidat3" ,"candidat3" , ump)
		candidat3.sePresenter(systeme)
		
		systeme.cloturerCandidature
		
		val elec1 = new  Electeur (1 , "login1","nom1","prenom1","password1")
		val elec2 = new  Electeur (2 , "login2","nom2","prenom2","password2")
		val elec3 = new  Electeur (3 , "login3","nom3","prenom3","password3")
		val elec4 = new  Electeur (4 , "login4","nom4","prenom4","password4")
		val elec5 = new  Electeur (5 , "login5","nom5","prenom5","password5")
        val elec6 = new  Electeur (6 , "login6","nom6","prenom6","password6")
        val elec7 = new  Electeur (7 , "login7","nom7","prenom7","password7")

        println("premier tour")
        
		elec1.voter(systeme, List(candidat1,candidat2))
		 elec2.voter(systeme, List(candidat1,candidat3))
		elec3.voter(systeme, List(candidat3,candidat2))
		elec4.voter(systeme, List(candidat3,candidat2))
		elec5.voter(systeme, List(candidat3,candidat1))
		elec6.voter(systeme, List(candidat2,candidat1))
		elec7.voter(systeme, List(candidat2,candidat1))
		//le candidat 3 gagne
		systeme.runTour()
		println("Deuxieme tour")
		
		println(elec1.voter(systeme, List(candidat1)))
		elec2.voter(systeme, List(candidat1))
		elec3.voter(systeme, List(candidat1))
		elec4.voter(systeme, List(candidat2))
		elec5.voter(systeme, List(candidat2))
		elec6.voter(systeme, List(candidat1))
		
		systeme.runTour()
		if(systeme.terminer){
		    var listGagnants : List[Candidat] = systeme.getGagnants()
		    listGagnants = systeme.getGagnants
		    println(listGagnants.length+" gagnant(s)")
		}
		else{		
			println("probleme")
		}
		
		
    }
}