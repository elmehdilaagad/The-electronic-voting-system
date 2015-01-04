package Gvote

import scala.collection.AbstractSeq

abstract class SystemGeneralDecomptage(_nom : String) {
	type ImplElection <: AbstractElection
	type ImplElecteur <: AbstractElecteur
	type Candidate <: Eligible
	type ImplVote <: AbstractVote
	type returnList <: AbstractSeq[_]; //Ajouter par Ceulain car j'avais besoin d'un retour liste mutable 
	
	val nom : String = _nom
	protected val election : ImplElection
	protected var tourCourant : Int = 0
	var terminer : Boolean = false; //Same in Uninomial
	
    def initElection():Unit
    def ajouterCandidat(candidat : Eligible):Boolean
    def cloturerCandidature:Unit
    def getCandidat() : List[Eligible] = election.listCandidat
    def ajouterVote(vote : ImplVote):Boolean
    def comptabiliser(numeroTour : Int):Boolean
    //retourne la liste des candidats a la position pos
    def getCandidatAtPos(pos : Int, numeroTour : Int):List[Candidate]
    //déroulement d'un tour (cloturer le precedent puis en commencer un nouveau si besoin)
    def runTour():Unit
    def getGagnantsTour(i : Int): returnList
    def getGagnants(): returnList
	
}
