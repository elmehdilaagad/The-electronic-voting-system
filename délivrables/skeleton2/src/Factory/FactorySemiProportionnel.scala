package Factory

import Gvote.FactoryCoutingSystem
import Gvote.SystemeDeComptageSemiProportionel

object FactorySemiProportionnel extends FactoryCoutingSystem {
  
	def createCoutingSystem = new SystemeDeComptageSemiProportionel("Election semi proportionnel");

}