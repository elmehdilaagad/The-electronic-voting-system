package Factory

import Gvote.FactoryCoutingSystem
import implementationProportionnel.SystemDeComptageProportionel
import implementationVoteSimple.Election
import Gvote.ScrutinCST
import implementationProportionnel.ElectionProportionnel

object FactoryProportionnel extends FactoryCoutingSystem {
	var numberOfSeat : Int = 0;
	def createCoutingSystem = new SystemDeComptageProportionel("Election proportionnel", new ElectionProportionnel(ScrutinCST.paramProportionnel(numberOfSeat)));
}