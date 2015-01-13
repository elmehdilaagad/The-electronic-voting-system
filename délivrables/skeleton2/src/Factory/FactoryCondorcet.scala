package Factory

import Gvote.FactoryCoutingSystem
import Gvote.ScrutinCST
import implementationCondorcet._

object FactoryCondorcet extends FactoryCoutingSystem {
	def createCoutingSystem = new SystemeDecomptageCondorcet("Election condorcet", new ElectionCondorcet(ScrutinCST.paramCondorcet));
}