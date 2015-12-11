package implementationVoteSimple

import Gvote.SystemGeneralDecomptage
import Gvote.Eligible
import GUIComponent.GUIComponentCST
import Gvote.Candidat

abstract class SystemeDecomptageSimple(_election : Election , _nom : String) extends SystemGeneralDecomptage(_nom){
    type ImplElection = Election  
    type ImplVote = Vote
    type Candidate = Candidat
    
    var GUIType = GUIComponentCST.radio
      
    override protected val election = _election
    
    def ajouterCandidat(candidat : Eligible) : Boolean = {
    	candidat match{
            case cand : Candidat => return election.addCandidat(cand)
        }
            
        return false
    }
}