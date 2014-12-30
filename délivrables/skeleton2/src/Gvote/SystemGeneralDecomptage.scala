package Gvote

import scala.collection.AbstractSeq

abstract class SystemGeneralDecomptage(_nom : String) {
	type ImplElection <: AbstractElection
	type ImplElecteur <: AbstractElecteur
	type ImplVote <: AbstractVote
	type returnList <: AbstractSeq[Candidat]; //Ajouter par Ceulain car j'avais besoin d'un retour liste mutable 
	
	val nom : String = _nom
	protected val election : ImplElection
	protected var tourCourant : Int = 0
	var terminer : Boolean = false; //Same in Uninomial
	
    def initElection():Unit
    def ajouterCandidat(candidat : Candidat):Boolean
    def cloturerCandidature:Unit
    def ajouterVote(vote : ImplVote):Boolean
    def comptabiliser(numeroTour : Int):Boolean
    def getCandidatAtPos(pos : Int, numeroTour : Int):List[Candidat]
    def runTour():Unit
    def getGagnantsTour(i : Int): returnList
    def getGagnants(): returnList
	
}
