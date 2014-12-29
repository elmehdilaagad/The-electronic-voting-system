package implementationUninominale

import Gvote.AbstractElection
import Gvote.ModeScrutin
import Gvote.Candidat

class Election(_modeScrutin : ModeScrutin) extends AbstractElection(_modeScrutin){
	type ImplTour = Tour
	
	def this(modeScrutin : String, nbTour : Int, listGagnantParTour : List[Int]  ,visibiliteVote : String ){
		this(new  ModeScrutin(modeScrutin, nbTour, listGagnantParTour,visibiliteVote));
	}	
	
	def getTour(n : Int) : Tour = {
	  return getTour(n,tourList)
	}
	
	def getTour (n:Int, list:List[Tour]) : Tour = {
		list match{
			case List(t) => if(n==0) t
							else null
			case (t::tail) => if(n==0) t
							  else getTour(n-1,tail)
		}
	}

}