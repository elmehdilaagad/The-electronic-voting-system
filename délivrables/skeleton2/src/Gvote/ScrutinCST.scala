package Gvote

object ScrutinCST {
    
	val uninominal = "UNINOMINAL";
	val plurinominal = "PLURINOMINAL";
	val semiProportionnel = "SEMI_PROPORTIONNEL";
	val public = "public";
	val prive = "prive";
	  
	val paramUninominal = new ModeScrutin(uninominal,2,List(2,1),prive)
	// Pour le semi proportionnel liste de gagnant par tour égale nombre de sièges
	val paramSemiProportionnel = new ModeScrutin(semiProportionnel,1,List(20),prive);
	
}