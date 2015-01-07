package GUI

import GUIComponent._

abstract class GUIAbstractGeneratorToolkit {
	type ImplFrame
  	
	var mainFrame : ImplFrame
	
	protected def init(frame : Frame)
	
	final def generateFrame(frame : Frame) : ImplFrame = {
	    return mainFrame
	}
}