package net.mcwintercraft.wintercraft;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import com.vexsoftware.votifier.model.VotifierEvent;
import com.vexsoftware.votifier.model.Vote;

public class Vote implements Listener {
    //
    @EventHandler
    public void onVotifierEvent(VotifierEvent event) {
        Vote vote = event.getVote();

        /*
         * Process Vote record as you see fit
         */
    }
}
