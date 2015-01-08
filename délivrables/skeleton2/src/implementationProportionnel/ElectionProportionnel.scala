package implementationProportionnel

import Gvote.ModeScrutin
import Gvote.AbstractElection

import Gvote.Parti

final class ElectionProportionnel(_modeScrutin : ModeScrutin) extends AbstractElection(_modeScrutin){
    type ImplTour = TourProportionnel
     type Candidate = Parti
  
  def this(modeScrutin : String, nbTour : Int, listGagnantParTour : List[Int]  ,visibiliteVote : String ){
    this(new  ModeScrutin(modeScrutin, nbTour, listGagnantParTour,visibiliteVote));
  } 

    
}