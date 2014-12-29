package Factory

import Gvote.FactoryCoutingSystem
import implementationUninominale.SystemeDecomptageUninominal

object FactoryUninominal extends FactoryCoutingSystem {
  
	def createCoutingSystem = new SystemeDecomptageUninominal("Election uninominal");
}