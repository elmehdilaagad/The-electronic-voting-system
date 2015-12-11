package GUIComponent

class Frame(_layout : String, _contentList : List[FrameContent]){
  
    var layout : String = _layout
	var contentList : List[FrameContent] = _contentList
	
	def this(_layout : String){
      this(_layout, List())
    }
	
	def addContent(interfaceDeVote : FrameContent){
	    contentList = contentList :+ interfaceDeVote
	}
}