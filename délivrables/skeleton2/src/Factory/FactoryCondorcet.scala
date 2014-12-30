package Factory

import Gvote.FactoryCoutingSystem
import Gvote.ScrutinCST
import implementationCondorcet._


object FactoryCondorcet {
	def createCoutingSystem = new SystemeDecomptageCondorcet("Election condorcet", new ElectionCondorcet(ScrutinCST.paramUninominal));
}