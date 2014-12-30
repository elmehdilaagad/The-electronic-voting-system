package implementationCondorcet

import Gvote.SystemGeneralDecomptage
import Gvote.Candidat
import Gvote.ModeScrutin
import Gvote.ScrutinCST

class  SystemeDecomptageCondorcet(_nom : String, _electionCondorcet : ElectionCondorcet) extends SystemGeneralDecomptage(_nom){
        type ImplElection = ElectionCondorcet
        type ImplElecteur = ElecteurCondorcet
        type ImplVote = VoteCondorcet
        type returnList = List[Candidat]
        
		override protected val election : ElectionCondorcet = new ElectionCondorcet(ScrutinCST.paramUninominal)
        var listVotant : List[ElecteurCondorcet] = List()
        private var currentListCandidat : List[Candidat] = List()
        var tabCandidatVote : List[(Candidat,Int,Int)] = List()
                
        def initElection(){
		    election.tourList  = List(new TourCondorcet(election))
		}
        
        def initCurrentListCandidat(){
            currentListCandidat = election.listCandidat
        }
        
        def ajouterCandidat(candidat : Candidat) : Boolean = {
            election.addCandidat(candidat)
            return true
        }
        
        def cloturerCandidature(){
            election.fermerCandidature()
            election.ouvertureVote()
            initCurrentListCandidat()
            election.getTour(tourCourant).lancerTour()
        }
        
        def ajouterVote(vote : VoteCondorcet) : Boolean = {
          return election.getTour(tourCourant).addVote(vote)
        }
        
    	def comptabiliser (numeroTour : Int) : Boolean = {
        	
    	    val tour : TourCondorcet = election.getTour(numeroTour)
    	    
    	    if(tour==null) return false
    	    
    	    var min : Int = 0
        	var max : Int = 0
    	    var v : Int = 0
    	    
    	    for(cand1 <- currentListCandidat){
    	        for(cand2 <- currentListCandidat){
    	        	if(cand1.id != cand2.id){
    	        	    v = tour.compareVote(cand1, cand2)
    	        	    if(min>v) min = v;
    	        	    if(max<v) max = v;
    	        	}
    	        }
    	        
    	        tabCandidatVote = tabCandidatVote:+(cand1,min,max)
    	        min = 0
    	        max = 0
    		}
        	
        	return true
    	}
    	
    	def getCandidatAtPos(pos : Int, numeroTour: Int):List[Candidat] = {
    		var position : Int = 0
    		var listCandidat : List[Candidat] = election.listCandidat
    		var listCandidatAtPos : List[Candidat] = List()
    		
    		if(!comptabiliser(numeroTour))	return List()
		
    		for(scoreCand1 <- tabCandidatVote){
    		    position = 0
    		  
    	        for(scoreCand2 <- tabCandidatVote){
    	        	if(scoreCand1._1.id != scoreCand2._1.id){
    	        	    if(scoreCand1._2 < scoreCand2._2) 
    	        	        position += 1
    	        	    else if(scoreCand1._2 == scoreCand2._2){
    	        	        if(scoreCand1._3 < scoreCand2._3)
    	        	            position += 1
    	        	    }
    	        	}
    	        }
    	        
    	        if(position == pos){
					listCandidatAtPos = listCandidatAtPos:+scoreCand1._1
				}  
    		}
    		
    		return listCandidatAtPos
    	}
    	
    	def runTour(){
    	  //A FINIR
    		election.getTour(tourCourant).cloturer()
	  
    		var candidatGagnants : List[Candidat] = getGagnantsTour(tourCourant)
	  
    		for(candidat <- election.listCandidat){
    			if(!candidatGagnants.contains(candidat)){
    				currentListCandidat.dropWhile(_ == candidat)
    			}
    		}
    		
    		tourCourant+=1
    		if(tourCourant == election.tourList.length){
    		    terminer = true
    		}
    		else{
    		  election.getTour(tourCourant).lancerTour()
    		}
    	}
    	
    	def getGagnantsTour(numeroTour : Int):List[Candidat]={
    		//A FINIR
	    	/*val modeScrutin : ModeScrutin = election.modeScrutin 
	    	val tour = election.getTour(numeroTour)
	    	var gagnants : List[Candidat] = List()
	  
		    if(numeroTour==1){
		    		
		    	gagnants = gagnants++getCandidatAtPos(numeroTour,0)
		    		
		    	if(gagnants.length<=1){
		    		gagnants = gagnants++getCandidatAtPos(numeroTour,1)
		    	}
		    }
		    else{
		    	gagnants = gagnants++getCandidatAtPos(numeroTour,0)
		    }*/
	  
	    	return List()//gagnants
		}
    
    def getGagnants():List[Candidat] = {
        //A FINIR
      /*if(terminer){
            return currentListCandidat 
        }*/
        return List()
    }
}
