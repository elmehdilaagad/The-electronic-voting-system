package implementationVoteSimple

import Gvote.Candidat
import Gvote.ScrutinCST

class SystemeDeComptageSemiProportionel(_nom : String, _election : Election)  extends SystemeDecomptageSimple(_nom){

	type ImplElection = Election;
	type ImplElecteur = Electeur;
	type ImplVote  = Vote;
	type returnList = scala.collection.mutable.MutableList[Candidat];

	var tabCandidatVoteWithoutVote : scala.collection.mutable.MutableList[Candidat] 
	= scala.collection.mutable.MutableList();
	var tabCandidatVote : List[(Candidat,Int)] = List(); //Same Uninomial
	var currentListCandidat : List[Candidat] = List();
	override protected val election = _election;

	def initElection() = {
		election.tourList = List(new Tour(election));
	}
	// Pareil que dans Decomptage Uninomial à factoriser ???
	def ajouterCandidat(candidat : Candidat) : Boolean = {
		election.addCandidat(candidat);
		return true;
	}
	// Same uninomial
	def initCurrentListCandidat(){
		currentListCandidat = election.listCandidat;
	}
	// Same uninomial
	def cloturerCandidature(){
		election.fermerCandidature();
		election.ouvertureVote();
		initCurrentListCandidat();
		election.getTour(tourCourant).lancerTour();
	}

	def ajouterVote(vote : Vote) : Boolean = {
			return election.getTour(tourCourant).addVote(vote);
	}
	def comptabiliser (numeroTour : Int) : Boolean ={
		var cpt : Int = 0;
		val tour = election.getTour(numeroTour);
		if(tour == null)
		  return false;
		for(candidat <- currentListCandidat){
			cpt = tour.getNbVote(candidat);
			//println("cpt : "+cpt);
			tabCandidatVote = tabCandidatVote:+(candidat,cpt);
			
		}
		
		  
		return true;
	}

	def getCandidatAtPos(pos : Int, numeroTour: Int):List[Candidat] = {
		var position : Int = 0;
		var candidatVoteCourant : (Candidat,Int) = null;
		var listCandidat : List[Candidat] = election.listCandidat;
		var listCandidatAtPos : List[Candidat] = List();
		comptabiliser(numeroTour);

		var it : Iterator[(Candidat,Int)] = tabCandidatVote.iterator;

		while(it.hasNext){
			candidatVoteCourant = it.next;
			for(candidatVote <- tabCandidatVote){
				println("test: "+candidatVoteCourant._2 +"<" +candidatVote._2 )
				if(candidatVoteCourant._1.id != candidatVote._1 .id
					&& candidatVoteCourant._2 < candidatVote._2){
					position+=1;
				}
			}
			println(" test candidat termine ")
			if(position==pos){
			listCandidatAtPos = listCandidatAtPos:+candidatVoteCourant._1
					println("ok,candidat:"+candidatVoteCourant._1.nom +", taille liste "+listCandidatAtPos.length);
			}  
		}

		return listCandidatAtPos;
	}
	/*
	 * A FAIRE
	 */
	def runTour(){
	  //println("tour courant " +tourCourant )
	//  comptabiliser(tourCourant);
    		election.getTour(tourCourant).cloturer()
	  
    		var candidatGagnants :  scala.collection.mutable.MutableList[Candidat] = getGagnantsTour(tourCourant);
	  
    		for(candidat <- election.listCandidat){
    			if(!candidatGagnants.contains(candidat)){	
    				currentListCandidat.dropWhile(_ == candidat);
    			}
    		}
    		
    		tourCourant+=1;
    		if(tourCourant == election.tourList.length){
    		    terminer = true
    		}
    		
    		
	}
	
	//Fonction qui supprime les voix de la liste tabCandidatVote
	//pour retourner seulement une liste de Candidat dans la fonction
	//getGagnants
	def removeVote(list : List[(Candidat,Int)]) : scala.collection.mutable.MutableList[Candidat] = {
		
		var newListCandidat : scala.collection.mutable.MutableList[Candidat] = 
		  scala.collection.mutable.MutableList();
		for(candidat <- list){
			
			newListCandidat.+=:(candidat._1);
		}
	//	println(newListCandidat)
	  return newListCandidat;  
	}
	
	def getGagnantsTour(i : Int): scala.collection.mutable.MutableList[Candidat]= {
	  comptabiliser(tourCourant);
	  var sortListCandidat = tabCandidatVote.sortBy(x => x._2); //Liste triée en fonction du nombre de vote
	 
	  tabCandidatVoteWithoutVote = removeVote(sortListCandidat);
	  //println(tabCandidatVoteWithoutVote)
	  return tabCandidatVoteWithoutVote;
	}
	
	def getGagnants(): scala.collection.mutable.MutableList[Candidat] = {
		val numberOfSeat = ScrutinCST.paramSemiProportionnel.listGagnantParTour.apply(0);
		//println("number of seat "+numberOfSeat)
		return tabCandidatVoteWithoutVote.takeRight(numberOfSeat);
	}


}