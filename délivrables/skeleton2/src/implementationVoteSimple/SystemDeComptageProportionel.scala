package implementationVoteSimple

import scala.collection.mutable.MutableList
import scala.collection.AbstractSeq
import Factory.FactoryProportionnel
import scala.util.control._

class SystemDeComptageProportionel(_nom : String, election : Election) extends SystemeDecomptageSimple(election, _nom) {

	type ImplElecteur = Electeur;
	type returnList = AbstractSeq[_];


	var currentListCandidat : List[Candidat] = List();
	var tabCandidatVote : List[(Candidat,BigDecimal)] = List(); //Same Uninomial
	var numberOfVote : BigDecimal = 0;
	var numberOfSeat : BigDecimal = FactoryProportionnel.numberOfSeat;
	var electoralQuot : BigDecimal = 0;
	var listSortByQuot : MutableList[(Candidat,BigDecimal,BigDecimal,BigDecimal)] = MutableList();
	var listSortByRemind : MutableList[(Candidat,BigDecimal,BigDecimal,BigDecimal)] = MutableList();
	var listWinners : MutableList[(Candidat,BigDecimal,BigDecimal )] = MutableList();
	//override protected val election = _election;
	tourCourant = 0;


	/*def ajouterCandidat(candidat : Candidat) : Boolean = {
			election.addCandidat(candidat);
			return true;
	}*/
	def initElection() = {

		//println("init");
		election.tourList = List(new Tour(election));
	}

	def initCurrentListCandidat(){
		currentListCandidat = election.listCandidat;
		//println("length "+currentListCandidat.length);
	}

	def cloturerCandidature(){
		election.fermerCandidature();
		election.ouvertureVote();
		initCurrentListCandidat();
		election.tourList.apply(tourCourant).lancerTour();
	}

	def ajouterVote(vote : Vote) : Boolean = {
			numberOfVote += 1.0;
			return election.tourList.apply(tourCourant).addVote(vote);
	}
	def comptabiliser (numeroTour : Int) : Boolean ={
			electoralQuot  = numberOfVote / numberOfSeat ;
			var cpt : BigDecimal = 0;
			val tour = election.tourList.apply(numeroTour);
			if(tour == null)
				return false;
			for(candidat <- currentListCandidat){
				cpt = tour.getNbVote(candidat);
				tabCandidatVote = tabCandidatVote:+(candidat,cpt);

			}
			return true;
	}

	def getCandidatAtPos(pos : Int, numeroTour: Int):List[Candidat] = {

			return null;
	}


	def runTour(){	
		election.tourList.apply(tourCourant).cloturer();
		if(tourCourant == election.tourList.length){
			terminer = true;
		}
	}


	def getGagnantsTour(i : Int): List[Candidat]= {
			return null;
	}

	def getGagnants(): MutableList[(Candidat,BigDecimal,BigDecimal)] = {
			var candidatWithQuotAndRemind : MutableList[(Candidat,BigDecimal,BigDecimal,BigDecimal)] = MutableList();

	comptabiliser(tourCourant);

	var remainder : BigDecimal = 0;
	var quot : BigDecimal = 0;
	for(candidats <- tabCandidatVote ){	
		remainder = candidats._2 .remainder(electoralQuot );
		quot = candidats._2 .quot(electoralQuot );
		candidatWithQuotAndRemind.+=:(candidats._1 ,candidats._2 , remainder, quot.doubleValue);

	}

	listSortByQuot = candidatWithQuotAndRemind.sortBy(x => x._4);
	listSortByRemind  = candidatWithQuotAndRemind.sortBy(x => x._3 ).reverse;
	val loop = new Breaks;
	var foundIt = false;
	var seat : BigDecimal = 0;
	loop.breakable{
		for(quot <- listSortByQuot ){		
			numberOfSeat -= quot._4;
			listWinners.+=:(quot._1,quot._4,quot._3);	
			if(numberOfSeat == 0)
				return listWinners ;		
		}
	}



	var exList = listWinners .sortBy(x => x._3).reverse;
	var win : MutableList[(Candidat,BigDecimal)] = MutableList();
	loop.breakable{
		for(i  <- 0 to exList.length ){
			seat = exList.apply(i)._2 + 1; 
			numberOfSeat -= 1;
			exList.update(i,(exList.apply(i)._1,seat,exList.apply(i)._3))

			if(numberOfSeat.equals(0.0)){
				//println("no2");
				loop.break;
			}
		}

	}

	return exList;
	}







}