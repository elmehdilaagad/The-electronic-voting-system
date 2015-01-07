package Factory

import Gvote._

import implementationPlurinominale._



object FactoryPlurinominal extends FactoryCoutingSystem {

  def createCoutingSystem() = null
  def createCoutingSystem(nbTour : Int , listgagnantTour : List[Int]) = 
	  new SystemeDecomptagePlurinomial("Election Plurinominale", new ElectionPlurinominale(ScrutinCST.paramPlurinominale(nbTour,listgagnantTour)));
}
