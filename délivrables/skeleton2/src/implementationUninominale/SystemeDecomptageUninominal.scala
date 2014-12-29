package implementationUninominale

import Gvote.SystemGeneralDecomptage
import Gvote.Candidat
import Gvote.ModeScrutin
import Gvote.ScrutinCST
import scala.util.control.Breaks

class  SystemeDecomptageUninominal(_nom : String) extends SystemGeneralDecomptage(new Election(ScrutinCST.paramUninominal)){
        type ImplElection = Election
        type ImplElecteur = Electeur
        type ImplVote = Vote
  
        
		val nom : String = _nom
		val election : Election = new Election(ScrutinCST.paramUninominal)
        private var currentListCandidat : List[Candidat] = List()
        var listdeslistedeCandidat:List[List[(Candidat,Int)]] = List()
        var tabCandidatVote : List[(Candidat,Int)] = List()
        var tourCourant : Int  = 0;
		var terminer : Boolean = false;
        
        def initElection(){
		    election.tourList  = List(new Tour(election),new Tour(election))
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
        
        def ajouterVote(vote : Vote) : Boolean = {
          
            if(election.getTour(tourCourant).addVote(vote)){
            	return true
            }
            return false
        }
        
    	def comptabiliser (numeroTour : Int) : Boolean = {
    	    var cpt : Int = 0
    	    val tour = election.getTour(numeroTour)
    	    
    	    if(tour==null) return false
    	    
    	    tabCandidatVote = List()
    	    for(candidat <- currentListCandidat){
    	    	cpt = tour.getNbVote(candidat)
    	    	tabCandidatVote = tabCandidatVote:+(candidat,cpt)
    	    }
    	    return true
    	}
    	
    	def getCandidatAtPos(pos : Int, numeroTour: Int):List[Candidat] = {
    		var position : Int = 0
    		var listCandidatAtPos : List[Candidat] = List()
    		
    		if(!comptabiliser(numeroTour))	return List()	 

    		for(candidatVoteCourant <- tabCandidatVote){
    			position = 0

    		    for(candidatVote <- tabCandidatVote){
    				//println("test: "+candidatVoteCourant._2 +"<" +candidatVote._2 )
    				if(candidatVoteCourant._1.id != candidatVote._1 .id
				      && candidatVoteCourant._2 < candidatVote._2){
    					position+=1
    				}
    			}
    			
				if(position==pos){
					listCandidatAtPos = listCandidatAtPos:+candidatVoteCourant._1
				}
    		}
    		return listCandidatAtPos
    	}
    	
    	def runTour(){
    		var tour = election.getTour(tourCourant)
    		tour.cloturer()
    		
    		var candidatGagnants : List[Candidat] = getGagnantsTour(tourCourant)
    		
    		var scoreList : List[(Candidat,Int)] = List()
    		var loop : Breaks = new Breaks
    		
    		for(candGagnant <- currentListCandidat){
    		    loop.breakable{
    		    	for(scoreCandidat <- tabCandidatVote){
    		        	if(candGagnant.id == scoreCandidat._1.id){
    		            	scoreList :+ scoreCandidat
    		            	loop.break
    		        	}
    		    	}
    		    }
    		}
    		
    		listdeslistedeCandidat:+scoreList
    		
    		var nbVotePremier : Float = tour.getNbVote(candidatGagnants.head)
		    var nbVoteTotal : Float = tour.getNbVoteTotal 
		    var pourcentage : Float = nbVotePremier/nbVoteTotal*100
		    if(pourcentage>=50 && getCandidatAtPos(0, tourCourant).length==1){
		        candidatGagnants = List(candidatGagnants.head)
		        tourCourant = election.tourList.length
		        println(candidatGagnants.head.nom+" a gagne")
		    }
    		
    		for(candidat <- currentListCandidat){
    			if(!candidatGagnants.contains(candidat)){
    			    currentListCandidat = candidatGagnants
    			}
    		}
    		
    		tourCourant+=1
    		
    		if(tourCourant < election.tourList.length)
    			for(candidat <-  currentListCandidat ){	
    		    	println(candidat.nom +" a passe le tour "+tourCourant)
    			}
    		
    		if(tourCourant >= election.tourList.length){
    		    terminer = true	
    		    println("l'election est termine")
    		}
    		else{ 		  
    		  election.getTour(tourCourant).lancerTour()
    		}
    		
    	}
    	
    	def getGagnantsTour(numeroTour : Int):List[Candidat] = {
    	 
	    	val tour = election.getTour(numeroTour)
	    	
	    	if(tour == null){
	    	    println("null")
	    	    return List()
	    	}
	    	
	    	var gagnants : List[Candidat] = List()
	    	
		    if(numeroTour==0){
		    		
		    	gagnants = gagnants++getCandidatAtPos(0,numeroTour)
		    		
		    	if(gagnants.length==1){
		    	    gagnants = gagnants++getCandidatAtPos(1,numeroTour)
		    	}
		    }
		    else{
		    	gagnants = gagnants++getCandidatAtPos(0,numeroTour)
		    }
	  
	    	return gagnants
		}
    
    def getGagnants():List[Candidat] = {
        if(terminer){
            return currentListCandidat 
        }
        return List()
    }
}
