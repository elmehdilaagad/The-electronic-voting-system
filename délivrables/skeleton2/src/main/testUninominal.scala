package main

import Factory._
import Gvote.Candidat
import implementationUninominale._


object testUninominal {
  
    def main(args: Array[String]): Unit = {
	   
        var  systeme : SystemeDecomptageUninominal = FactoryUninominal.createCoutingSystem
		
        systeme.initElection
        
		val candidat1 = new Candidat(1 , "candidat1" ,"candidat1" ,"liberte1")
		candidat1.sePresenter(systeme)
		val candidat2 = new Candidat(2 , "candidat2" ,"candidat2" ,"liberte2")
		candidat2.sePresenter(systeme)
		val candidat3 = new Candidat(3 , "candidat3" ,"candidat3" ,"liberte3")
		candidat3.sePresenter(systeme)
		
		systeme.cloturerCandidature
		
		val elec1 = new  Electeur (1 , "login1","nom1","prenom1","password1")
		val elec2 = new  Electeur (2 , "login2","nom2","prenom2","password2")
		val elec3 = new  Electeur (3 , "login3","nom3","prenom3","password3")
		val elec4 = new  Electeur (4 , "login4","nom4","prenom4","password4")
		val elec5 = new  Electeur (5 , "login5","nom5","prenom5","password5")
        val elec6 = new  Electeur (6 , "login6","nom6","prenom6","password6")

        println("premier tour")
        
		elec1.voter(systeme, candidat1)
		elec2.voter(systeme, candidat2)
		elec3.voter(systeme, candidat3)
		elec4.voter(systeme, candidat2)
		elec5.voter(systeme, candidat1)
		elec6.voter(systeme, candidat2)
		
		systeme.runTour()
		
		//si l'election est termine au bout d'un tour, alors un candidat a obtenu plus de 50% des voix
		if(systeme.terminer){
		    var listGagnants : List[Candidat] = systeme.getGagnants()
		    listGagnants = systeme.getGagnants
		}
		else{
			
			println("deuxieme tour")
			
			elec1.voter(systeme, candidat1)
			elec2.voter(systeme, candidat2)
			elec3.voter(systeme, candidat2)
			elec4.voter(systeme, candidat2)
			elec5.voter(systeme, candidat1)
			elec6.voter(systeme, candidat2)
		
			systeme.runTour()
		
			var listGagnants : List[Candidat] = systeme.getGagnants
		
			for(candidat <-  listGagnants){	
				println(candidat.nom +" a gagne")
			}
		}
    }
     
}
