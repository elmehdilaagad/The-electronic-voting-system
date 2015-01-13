package Gvote

object SystemeDecomptage{
	def getGagnants(election : Election):List[Candidat] = {
	  	  
	  val parametres : ModeScrutin = election.parametres
	  val tour : Tour = election.tourList.last
	  val numeroTour : Int = election.tourCourant 
	  var gagnants : List[Candidat] = List()
	  
	  if(parametres.typeScrutin  != "libre"){
		  
		  parametres.typeScrutin match{
		    case ScrutinCST.uninominal  =>
		    	if(numeroTour==1){
		    		
		    		gagnants = gagnants:+tour.getCandidatAtPos(0)
		    		gagnants = gagnants:+tour.getCandidatAtPos(1)
		    		
		    	}
		    	else{
		    		gagnants = gagnants:+tour.getCandidatAtPos(0)
		    	}
		     	
		     	
		      	
		   // case "plurinominal" =>
		    	
		      	
		  }
	  }
	  
	  return gagnants
	}
	
}
