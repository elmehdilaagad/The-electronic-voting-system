package Gvote

import Gvote.Circonscription
import Gvote.Circonscription.Circonscription


object Candidat {

  class Candidat(var name : String , var age: Int)
  var maCirconscription : Circonscription =_
 
  def changeCirconc(c : Circonscription)={
    maCirconscription = c ; 
  }
	
   
}