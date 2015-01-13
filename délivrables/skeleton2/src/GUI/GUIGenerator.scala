package GUI

import Gvote._
import GUIComponent._

class GUIGenerator(_electeur : AbstractElecteur, _systemeList : List[SystemGeneralDecomptage], _GUIGeneratorToolkit : GUIAbstractGeneratorToolkit) {
	val electeur = _electeur
    val systemeList : List[SystemGeneralDecomptage] = _systemeList
    val GUIGeneratorToolkit : GUIAbstractGeneratorToolkit = _GUIGeneratorToolkit
    var frame : Frame = null

    protected def initializeFrame(layout : String){

		frame = new Frame(layout)
		var interfaceDeVote : FrameContent = null
	  
	    for(systeme <- systemeList){
		    var listChoix : List[String] = List()
		    for(candidat <- systeme.getCandidats){
		    	listChoix = listChoix :+ (candidat.nom)
		    }
			
		    interfaceDeVote = new FrameContent(systeme.nom, systeme.getGUIType, listChoix)
		    
		    frame.addContent(interfaceDeVote)
		    
	    }
		
	}
	
	def generateFrame(frameLayout : String){
	    initializeFrame(frameLayout)
	    GUIGeneratorToolkit.generateFrame(frame)
	}
}