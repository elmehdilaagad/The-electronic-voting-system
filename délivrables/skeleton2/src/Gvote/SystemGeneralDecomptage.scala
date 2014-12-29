package Gvote

import implementationUninominale.Vote
import scala.collection.AbstractSeq


abstract class SystemGeneralDecomptage(_election : AbstractElection) {
	type ImplElection <: AbstractElection
	type ImplElecteur <: AbstractElecteur
	type ImplVote <: AbstractVote
	type returnList <: AbstractSeq[Candidat]; //Ajouter par Ceulain car j'avais besoin d'un retour liste mutable
    protected val election : ImplElection

    def initElection():Unit
    def ajouterCandidat(candidat : Candidat):Boolean
    def cloturerCandidature:Unit
    def ajouterVote(vote : Vote):Boolean
    def comptabiliser(numeroTour : Int):Boolean
    def getCandidatAtPos(pos : Int, numeroTour : Int):List[Candidat]
    def runTour():Unit
    def getGagnantsTour(i : Int): returnList
    def getGagnants(): returnList
	
}