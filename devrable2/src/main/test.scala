/*package main

import Gvote._

*/


class A 
class B 

abstract class C {
  def m1 (x:A ) {println("C.m1")}
  def m2 (x:B ) : Unit 
  
}

trait T1 extends C {
  override def m2(x:B) {println("T1.m2")
}
}



trait T2 extends C {
  override def m2(x:B) {super.m1(new A ) }
}


trait T3 extends C {
  override def m1(x:A) {println("T3.m1") }
}

trait T4 extends C {
  override def m2(x:B) {super.m2(x ) }
}



object test {
  
   def main(args: Array[String]): Unit = {
	/*	   val modescrut = new ModeScrutin(ScrutinCST.uninominal , 2 , List(1)  ); 
			var  e = new Election(modescrut) ;
			
			val a = new Candidat(1 , "Amadou" ,"Doumbia0" ,"liberte")
				a.sePresenter(e); 
			val a1 =new Candidat(2 , "Amadou1" ,"Doumbia1" ,"liberte1") ;
				a1.sePresenter(e); 
			
				e fermerCandidature  
				
				e ouvertureVote 
			
			val elec1  = new  Electeur (1 , "a","a","a","a")
			val elec2  = new  Electeur (2 , "a","a","a","a")
			val elec3  = new  Electeur (3 , "a","a","a","a")
			
			e.ajouterVote(new Vote(elec1 , e , a ))
			
			e.ajouterVote(new Vote(elec2  , e , a1 )) 
			println(SystemeDecomptage.getGagnants(e))
   
  
  */
     (new C with T1 with T2 with T3 with T4 ).m2 (new B) ; 
     }
     
}
