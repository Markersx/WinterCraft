package net.mcwintercraft.wintercraft;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import com.vexsoftware.votifier.model.VotifierEvent;
import com.vexsoftware.votifier.model.Vote;

public class Voting extends UserData implements Listener {
    @EventHandler
    public void onVotifierEvent(VotifierEvent e) {
        Vote vote = e.getVote();
        String p = vote.getUsername();
        String[] address = vote.getAddress().split("\\.");
        Long time = System.currentTimeMillis() + 86400000;
        this.setVotesTimer(address[1], time);
        this.setTotalVotes(this.getTotalVotes() + 1);
   }
}
