package net.mcwintercraft.wintercraft;

import com.earth2me.essentials.EssentialsUserConf;
import com.earth2me.essentials.IConf;
import net.ess3.api.IEssentials;
import org.bukkit.entity.Player;

import java.io.File;

public abstract class UserData implements IConf {

    private IEssentials ess = WinterCraft.ess;
    private File folder = new File(ess.getDataFolder(), "userdata");
    protected EssentialsUserConf config;

    private int warpsMax;

    private int totalVotes;

    private String joinSound;
    private boolean joinSoundEnabled;
    private int joinSoundVolume;
    private int joinSoundPitch;
    private String quitSoundSound;
    private boolean quitSoundEnabled;
    private int quitSoundVolume;
    private int quitSoundPitch;
    private String messageSound;
    private boolean messageSoundEnabled;
    private int messageSoundVolume;
    private int messageSoundPitch;

    private String chatColor;
    private boolean chatColorBold;
    private boolean chatColorUnderline;
    private boolean chatColorStrike;
    private boolean chatColorMagic;
    private boolean chatColorItalic;
    private boolean chatColorRandom;
    private boolean chatColorRainbow;

    public void setUser(Player base) {
        String filename;
        try {
            filename = base.getUniqueId().toString();
        } catch (Throwable var5) {
            ess.getLogger().warning("Falling back to old username system for " + base.getName());
            filename = base.getName();
        }

        this.config = new EssentialsUserConf(base.getName(), base.getUniqueId(), new File(this.folder, filename + ".yml"));
        this.reloadConfig();
    }

    public final void reloadConfig() {
        this.warpsMax = _getWarpsMax();

        this.totalVotes = _getTotalVotes();

        this.joinSound = _getJoinSound();
        this.joinSoundEnabled = _isJoinSoundEnabled();
        this.joinSoundVolume = _getJoinSoundVolume();
        this.joinSoundPitch = _getJoinSoundPitch();
        this.quitSoundSound = _getQuitSound();
        this.quitSoundEnabled = _isQuitSoundEnabled();
        this.quitSoundVolume = _getQuitSoundVolume();
        this.quitSoundPitch = _getQuitSoundPitch();
        this.messageSound = _getMessageSound();
        this.messageSoundEnabled = _isMessageSoundEnabled();
        this.messageSoundVolume = _getMessageSoundVolume();
        this.messageSoundPitch = _getMessageSoundPitch();

        this.chatColor = _getChatColor();
        this.chatColorBold = _isChatColorBold();
        this.chatColorUnderline = _isChatColorUnderline();
        this.chatColorStrike = _isChatColorStrike();
        this.chatColorMagic = _isChatColorMagic();
        this.chatColorItalic = _isChatColorItalic();
        this.chatColorRandom = _isChatColorRandom();
        this.chatColorRainbow = _isChatColorRainbow();
    }

    private int _getWarpsMax() {
        return this.config.getInt("warps.max");
    }

    public int getWarpsMax() {
        return this.warpsMax;
    }

    public void setWarpsMax(int amount) {
        this.config.set("warps.max", amount);
        this.config.save();
    }

    private int _getTotalVotes() {
        return this.config.getInt("votes.total");
    }

    public int getTotalVotes() {
        return this.totalVotes;
    }

    public void setTotalVotes(int votes) {
        this.config.setProperty("totalVotes", votes);
        this.config.save();
    }

    public long getVoteTimer(String address) {
        return this.config.getLong("votes." + address + ".lastVote");
    }

    public void setVotesTimer(String address, Long time) {
        this.config.setProperty("votes." + address, time);
        this.config.save();
    }

    private String _getJoinSound() {
        return this.config.getString("sounds.join.sound");
    }

    public String getJoinSound() {
        return this.joinSound;
    }

    private boolean _isJoinSoundEnabled() {
        return this.config.getBoolean("sounds.join.enabled");
    }

    public boolean isJoinSoundEnabled() {
        return this.joinSoundEnabled;
    }

    private int _getJoinSoundVolume() {
        return this.config.getInt("sounds.join.volume");
    }

    public int getJoinSoundVolume() { return  this.joinSoundVolume; }

    private int _getJoinSoundPitch() {
        return this.config.getInt("sounds.join.pitch");
    }

    public int getJoinSoundPitch() {
        return this.joinSoundPitch;
    }

    private String _getQuitSound() {
        return this.config.getString("sounds.quit.sound");
    }

    public String getQuitSound() {
        return this.quitSoundSound;
    }

    private boolean _isQuitSoundEnabled() {
        return this.config.getBoolean("sounds.quit.enabled");
    }

    public boolean isQuitSoundEnabled() {
        return this.quitSoundEnabled;
    }

    private int _getQuitSoundVolume() {
        return this.config.getInt("sounds.quit.volume");
    }

    public int getQuitSoundVolume() {
        return this.quitSoundVolume;
    }

    private int _getQuitSoundPitch() {
        return this.config.getInt("sounds.quit.pitch");
    }

    public int getQuitSoundPitch() { return this.quitSoundPitch; }

    private String _getMessageSound() {
        return this.config.getString("sounds.message.sound");
    }

    public String getMessageSound() {
        return this.messageSound;
    }

    private boolean _isMessageSoundEnabled() {
        return this.config.getBoolean("sounds.message.enabled");
    }

    public boolean isMessageSoundEnabled() {
        return this.messageSoundEnabled;
    }

    private int _getMessageSoundVolume() {
        return this.config.getInt("sounds.message.volume");
    }

    public int getMessageSoundVolume() {
        return this.messageSoundVolume;
    }

    private int _getMessageSoundPitch() {
        return this.config.getInt("sounds.message.pitch");
    }

    public int getMessageSoundPitch() {
        return this.messageSoundPitch;
    }

    public void setSound(String type, String sound) {
        this.config.setProperty("sounds." + type + ".sound", sound);
        this.config.save();
    }

    public void setSoundEnabled(String type, boolean enabled) {
        this.config.setProperty("sounds." + type + ".enabled", enabled);
        this.config.save();
    }

    public void setSoundVolume(String type, int volume) {
        this.config.setProperty("sounds." + type + ".volume", volume);
        this.config.save();
    }

    public void setSoundPitch(String type, int pitch) {
        this.config.setProperty("sounds." + type + ".pitch", pitch);
        this.config.save();
    }

    private String _getChatColor() {
        return this.config.getString("sounds.color");
    }

    public String getChatColor() {
        return this.chatColor;
    }

    public void setChatColor(String color) {
        this.config.setProperty("chatColor.color", color);
        this.config.save();
    }

    private boolean _isChatColorBold() {
        return this.config.getBoolean("chatColor.bold");
    }

    public boolean isChatColorBold() {
        return  this.chatColorBold;
    }

    private boolean _isChatColorUnderline() {
        return this.config.getBoolean("chatColor.underline");
    }

    public boolean isChatColorUnderline() {
        return this.chatColorUnderline;
    }

    private boolean _isChatColorStrike() {
        return this.config.getBoolean("chatColor.strike");
    }

    public boolean isChatColorStrike() {
        return this.chatColorStrike;
    }

    private boolean _isChatColorMagic() {
        return this.config.getBoolean("chatColor.magic");
    }

    public boolean isChatColorMagic() {
        return this.chatColorMagic;
    }

    private boolean _isChatColorItalic() {
        return this.config.getBoolean("chatColor.italic");
    }

    public boolean isChatColorItalic() {
        return this.chatColorItalic;
    }

    private boolean _isChatColorRandom() {
        return this.config.getBoolean("chatColor.random");
    }

    public boolean isChatColorRandom() {
        return this.chatColorRandom;
    }

    private boolean _isChatColorRainbow() {
        return this.config.getBoolean("chatColor.rainbow");
    }

    public boolean isChatColorRainbow() {
        return this.chatColorRainbow;
    }

    public void setChatColorStyle(String style, boolean enabled) {
        this.config.setProperty("chatColor." + style, enabled);
        this.config.save();
    }
}
