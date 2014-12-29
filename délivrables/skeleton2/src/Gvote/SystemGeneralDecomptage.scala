package Gvote


abstract class SystemGeneralDecomptage(_election : AbstractElection) {
	type ImplElection <: AbstractElection
	type ImplElecteur <: AbstractElecteur
	type ImplVote <: AbstractVote
	
    protected val election : ImplElection

    def initElection():Unit
    def ajouterCandidat(candidat : Candidat):Boolean
    def cloturerCandidature:Unit
    def ajouterVote(vote : ImplVote):Boolean
    def comptabiliser(numeroTour : Int):Boolean
    def getCandidatAtPos(pos : Int, numeroTour : Int):List[Candidat]
    def runTour():Unit
    def getGagnantsTour(i : Int):List[Candidat]
    def getGagnants():List[Candidat]
	
}