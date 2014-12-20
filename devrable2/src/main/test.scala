package main

import Gvote._






object test {
  
   def main(args: Array[String]): Unit = {
	
			var  e = new Election(ScrutinCST.paramUninominal ) ;
			
			val a = new Candidat(1 , "Amadou" ,"Doumbia0" ,"liberte")
				a.sePresenter(e); 
			val a1 =new Candidat(2 , "Amadou1" ,"Doumbia1" ,"liberte1") ;
				a1.sePresenter(e); 
			val a2 =new Candidat(3 , "Amadou2" ,"Doumbia2" ,"liberte2") ;
				a2.sePresenter(e); 
				e fermerCandidature  
				
				e ouvertureVote 
			
			val elec1  = new  Electeur (1 , "a","a","a","a")
			val elec2  = new  Electeur (2 , "a","a","a","a")
			val elec3  = new  Electeur (3 , "a","a","a","a")

			elec1.voter(e, a);
			elec2.voter(e, a1);
			elec3.voter(e, a2);
				
				//	e.ajouterVote(new Vote(elec1 , e , a ))
			
			//e.ajouterVote(new Vote(elec2  , e , a1 )) 
			var listGagnants = SystemeDecomptage.getGagnants(e )
			for(candidat <-  listGagnants){
				
			  println(candidat.nom +" taille liste :" + listGagnants.length) 
			}
  
  
     }
     
}
