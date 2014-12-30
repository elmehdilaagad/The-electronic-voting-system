package implementationCondorcet

import Gvote.AbstractElection
import Gvote.ModeScrutin
import Gvote.Candidat

class ElectionCondorcet(_modeScrutin : ModeScrutin) extends AbstractElection(_modeScrutin){
	type ImplTour = TourCondorcet
	
	def this(modeScrutin : String, nbTour : Int, listGagnantParTour : List[Int]  ,visibiliteVote : String ){
		this(new  ModeScrutin(modeScrutin, nbTour, listGagnantParTour,visibiliteVote));
	}	
	
	def getTour(n : Int) : TourCondorcet = {
	  return getTour(n,tourList)
	}
	
	def getTour (n:Int, list:List[TourCondorcet]) : TourCondorcet = {
		list match{
			case List(t) => t
			case (t::tail) => if(n==1) t
							  else getTour(n-1,tail)
		}
	}

}