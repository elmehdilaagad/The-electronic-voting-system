package Factory

import Gvote.FactoryCoutingSystem
import Gvote.ScrutinCST
import implementationVoteSimple.Election
import implementationVoteSimple.SystemeDeComptageSemiProportionel

object FactorySemiProportionnel extends FactoryCoutingSystem {
	var numberOfSeat : Int = 0;
	def createCoutingSystem = new SystemeDeComptageSemiProportionel("Election semi proportionnel",new Election(ScrutinCST.paramSemiProportionnel(numberOfSeat)));

}