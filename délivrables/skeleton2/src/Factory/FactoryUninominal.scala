package Factory

import Gvote.FactoryCoutingSystem
import Gvote.ScrutinCST
import Gvote.ScrutinCST
import implementationVoteSimple.Election
import implementationVoteSimple.SystemeDecomptageUninominal

object FactoryUninominal extends FactoryCoutingSystem {
	def createCoutingSystem = new SystemeDecomptageUninominal("Election uninominal", new Election(ScrutinCST.paramUninominal));
}