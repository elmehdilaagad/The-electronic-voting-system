package implementationVoteSimple

import Gvote.Candidat
import scala.util.control.Breaks

class  SystemeDecomptageUninominal(_nom : String, _election : Election) extends SystemeDecomptageSimple(_nom){
        type ImplElection = Election
        type ImplElecteur = Electeur
        type returnList = List[Candidat]
 
		override protected val election : Election = _election
		private var currentListCandidat : List[Candidat] = List()
        //liste des candidats (non elimines), a chaque tour, associes a leur nombre de vote
		var listdeslistedeCandidat:List[List[(Candidat,Int)]] = List()
        var tabCandidatVote : List[(Candidat,Int)] = List()
        
        def initElection(){
        	var nb : Int = election.modeScrutin.nbTour
        	election.tourList = List()
            while(nb>0){
            	election.tourList = election.tourList:+(new Tour(election))
            	nb-=1
            }
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
            return election.getTour(tourCourant).addVote(vote)
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
    		            	scoreList = scoreList :+ scoreCandidat
    		            	loop.break
    		        	}
    		    	}
    		    }
    		}
    		
    		listdeslistedeCandidat = listdeslistedeCandidat:+scoreList
    		
    		var nbVotePremier : Float = tour.getNbVote(candidatGagnants.head)
		    var nbVoteTotal : Float = tour.getNbVoteTotal 
		    var pourcentage : Float = nbVotePremier/nbVoteTotal*100
		    if(pourcentage>=50 && getCandidatAtPos(0, tourCourant).length==1){
		        candidatGagnants = List(candidatGagnants.head)
		        tourCourant = election.tourList.length
		    }
    		
    		currentListCandidat = candidatGagnants
    		
    		tourCourant+=1
    		
    		if(tourCourant < election.tourList.length){
    			for(candidat <-  currentListCandidat ){	
    		    	println(candidat.nom +" a passe le tour "+tourCourant)
    			}
    			election.getTour(tourCourant).lancerTour()
    		}
    		
    		else{
    		    for(candidat <-  currentListCandidat ){	
    		    	println(candidat.nom +" a gagne")
    			}
    		    terminer = true	
    		    println("l'election est termine")
    		}
    		
    	}
    	
    	def getGagnantsTour(numeroTour : Int):List[Candidat] = {
    	 
	    	val tour = election.getTour(numeroTour)
	    	
	    	if(tour == null){
	    	    println("null")
	    	    return List()
	    	}
	    	
	    	var gagnants : List[Candidat] = List()
	    	
	    	var pos : Int = 0
	    	var nbCandidat : Int = election.modeScrutin.getNbGagnant(numeroTour)

	    	while(gagnants.length<nbCandidat && gagnants.length != currentListCandidat.length){
	    		gagnants = gagnants++getCandidatAtPos(pos,numeroTour)
	    		pos+=1
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
