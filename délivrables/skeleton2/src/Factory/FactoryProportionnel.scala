package Factory

import Gvote.FactoryCoutingSystem
import implementationVoteSimple.SystemDeComptageProportionel
import implementationVoteSimple.Election
import Gvote.ScrutinCST

object FactoryProportionnel extends FactoryCoutingSystem {
	var numberOfSeat : Int = 0;
	def createCoutingSystem = new SystemDeComptageProportionel("Election proportionnel", new Election(ScrutinCST.paramProportionnel(numberOfSeat)));
}