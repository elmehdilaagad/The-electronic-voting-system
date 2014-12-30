package Gvote

import scala.util.Failure

abstract class AbstractElection(_modeScrutin : ModeScrutin){
	type ImplTour <: AbstractTour
  
	val modeScrutin = _modeScrutin 
	var listCandidat : List[Candidat] = List()
	var tourList : List[ImplTour] = List()
	var isFinish : Boolean = false ;
	var sePresenter = true ; 
	var voter = false ;
	
	def this(modeScrutin : String, nbTour : Int, listGagnantParTour : List[Int]  ,visibiliteVote : String ){
		this(new  ModeScrutin(modeScrutin, nbTour, listGagnantParTour,visibiliteVote));
	}
	
	def fermerCandidature() { sePresenter = false } 

	def ouvertureVote() {voter=true }
	def fermetureVote():Boolean ={
	  if(voter){
	    voter = false ; 
	    return true ; 
	  }else 
	    return false 
	}
	
	def addCandidat(c : Candidat){
	  if(sePresenter)
		  listCandidat = listCandidat:+c
	}

	def removeCandidat(c : Candidat){
		listCandidat.dropWhile(_ == c)
	}
	
	def getTour(n : Int) : ImplTour
		
}