package implementationVoteSimple

import Gvote.SystemGeneralDecomptage
import Gvote.Eligible

abstract class SystemeDecomptageSimple(_election : Election , _nom : String) extends SystemGeneralDecomptage(_nom){
    type ImplVote = Vote
    type ImplElection = Election
    type Candidate = Candidat
    
    override protected val election = _election
    
    def ajouterCandidat(candidat : Eligible) : Boolean = {
    	candidat match{
            case cand : Candidat => {
        	    election.addCandidat(cand)
        	    return true
        	}
        }
            
        return false
    }
}