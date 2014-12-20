package Gvote

object  SystemeDecomptage extends SystemGeneralDecomptage{
	def getGagnants(election : Election):List[Candidat] = {
	  	  
	  val modeScrutin : ModeScrutin = election.modeScrutin 
	  val tour : Tour = election.tourList.last
	  val numeroTour : Int = election.tourCourant 
	  var gagnants : List[Candidat] = List()
	  
	  if(modeScrutin.typeScrutin  != "libre"){
		  
		  modeScrutin.typeScrutin match{
		    case ScrutinCST.uninominal  =>
		    	if(numeroTour==1){
		    		
		    		gagnants = gagnants++tour.getCandidatAtPos(0)
		    		
		    		if(gagnants.length<=1){
		    			gagnants = gagnants++tour.getCandidatAtPos(1)
		    		}
		    	}
		    	else{
		    		gagnants = gagnants++tour.getCandidatAtPos(0)
		    	}
		     	
		     	
		      	
		   // case "plurinominal" =>
		    	
		      	
		  }
	  }
	  
	  return gagnants
	}
	
}
