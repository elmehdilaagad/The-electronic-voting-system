package Gvote

object ScrutinCST {
	val uninominal = "UNINOMINAL"
	val plurinominal = "PLURINOMINAL"
	val public = "public"
	val prive = "privee"
	   
	val paramUninominal = new ModeScrutin(uninominal,2,List(2,1),prive)
	
}