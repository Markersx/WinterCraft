package net.mcwintercraft.wintercraft;

import com.earth2me.essentials.PlayerExtension;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.io.File;

public class UserData extends PlayerExtension {

    private final WinterCraftUserConfig config;
    private final WinterCraft wc;
    private final File folder;

    public UserData(Player base, WinterCraft wc) {
        super(base);
        this.wc = wc;
        folder = new File(wc.getDataFolder(), "userdata");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String filename;
        try {
            filename = base.getUniqueId().toString();
        } catch (Throwable e) {
            filename = base.getName();
        }
        config = new WinterCraftUserConfig(base.getName(), base.getUniqueId(), new File(folder, filename + ".yml"));
        config.setTemplateName("/userdata.yml");
        reloadConfig();
    }

    private int warpsMax;

    private int totalVotes;

    private long totalTime;
    private long activeTime;
    private long AFKTime;

    private long AFKSince;
    private long activeSince;

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

    public final void reloadConfig() {
        config.load();
        warpsMax = _getWarpsMax();
        totalTime = _getTotalTime();
        activeTime = _getActiveTime();
        AFKTime = _getAFKTime();
        totalVotes = _getTotalVotes();
        joinSound = _getJoinSound();
        joinSoundEnabled = _isJoinSoundEnabled();
        joinSoundVolume = _getJoinSoundVolume();
        joinSoundPitch = _getJoinSoundPitch();
        quitSoundSound = _getQuitSound();
        quitSoundEnabled = _isQuitSoundEnabled();
        quitSoundVolume = _getQuitSoundVolume();
        quitSoundPitch = _getQuitSoundPitch();
        messageSound = _getMessageSound();
        messageSoundEnabled = _isMessageSoundEnabled();
        messageSoundVolume = _getMessageSoundVolume();
        messageSoundPitch = _getMessageSoundPitch();
        chatColor = _getChatColor();
        chatColorBold = _isChatColorBold();
        chatColorUnderline = _isChatColorUnderline();
        chatColorStrike = _isChatColorStrike();
        chatColorMagic = _isChatColorMagic();
        chatColorItalic = _isChatColorItalic();
        chatColorRandom = _isChatColorRandom();
        chatColorRainbow = _isChatColorRainbow();
    }

    private int _getWarpsMax() {
        return config.getInt("warps.max");
    }

    public int getWarpsMax() {
        return warpsMax;
    }

    public void setWarpsMax(int amount) {
        config.setProperty("warps.max", amount);
        config.save();
    }

    private int _getTotalVotes() {
        if (config.isSet("votes.total")) {
            this.setTotalVotes(0);
        }
        return config.getInt("votes.total");
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(int votes) {
        config.setProperty("votes.total", votes);
        config.save();
    }

    public long getVoteTimer(String address) {
        if (!config.isSet("votes." + address)) {
            this.setVotesTimer(address, System.currentTimeMillis());
        }
        return config.getLong("votes." + address);
    }

    public void setVotesTimer(String address, Long time) {
        config.setProperty("votes." + address, time);
        config.save();
    }

    private String _getJoinSound() {
        return config.getString("sounds.join.sound");
    }

    public String getJoinSound() {
        return joinSound;
    }

    private boolean _isJoinSoundEnabled() {
        return config.getBoolean("sounds.join.enabled");
    }

    public boolean isJoinSoundEnabled() {
        return joinSoundEnabled;
    }

    private int _getJoinSoundVolume() {
        return config.getInt("sounds.join.volume");
    }

    public int getJoinSoundVolume() { return joinSoundVolume; }

    private int _getJoinSoundPitch() {
        return config.getInt("sounds.join.pitch");
    }

    public int getJoinSoundPitch() {
        return joinSoundPitch;
    }

    private String _getQuitSound() {
        return config.getString("sounds.quit.sound");
    }

    public String getQuitSound() {
        return quitSoundSound;
    }

    private boolean _isQuitSoundEnabled() {
        return config.getBoolean("sounds.quit.enabled");
    }

    public boolean isQuitSoundEnabled() {
        return quitSoundEnabled;
    }

    private int _getQuitSoundVolume() {
        return config.getInt("sounds.quit.volume");
    }

    public int getQuitSoundVolume() {
        return quitSoundVolume;
    }

    private int _getQuitSoundPitch() {
        return config.getInt("sounds.quit.pitch");
    }

    public int getQuitSoundPitch() { return quitSoundPitch; }

    private String _getMessageSound() {
        if (!config.isSet("sounds.message.sound")) {
            setSound("message", Sound.ENTITY_EXPERIENCE_ORB_TOUCH.toString());
        }
        return config.getString("sounds.message.sound");
    }

    public String getMessageSound() {
        return messageSound;
    }

    private boolean _isMessageSoundEnabled() {
        return config.getBoolean("sounds.message.enabled");
    }

    public boolean isMessageSoundEnabled() {
        return messageSoundEnabled;
    }

    private int _getMessageSoundVolume() {
        return config.getInt("sounds.message.volume");
    }

    public int getMessageSoundVolume() {
        return messageSoundVolume;
    }

    private int _getMessageSoundPitch() {
        return config.getInt("sounds.message.pitch");
    }

    public int getMessageSoundPitch() {
        return messageSoundPitch;
    }

    public void setSound(String type, String sound) {
        config.setProperty("sounds." + type + ".sound", sound);
        config.save();
    }

    public void setSoundEnabled(String type, boolean enabled) {
        config.setProperty("sounds." + type + ".enabled", enabled);
        config.save();
    }

    public void setSoundVolume(String type, int volume) {
        config.setProperty("sounds." + type + ".volume", volume);
        config.save();
    }

    public void setSoundPitch(String type, int pitch) {
        config.setProperty("sounds." + type + ".pitch", pitch);
        config.save();
    }

    private String _getChatColor() {
        if (!config.isSet("chatColor.color")) {
            setChatColor("WHITE");
        }
        return config.getString("chatColor.color");
    }

    public String getChatColor() {
        return chatColor;
    }

    public void setChatColor(String color) {
        config.setProperty("chatColor.color", color);
        config.save();
    }

    private boolean _isChatColorBold() {
        return config.getBoolean("chatColor.bold");
    }

    public boolean isChatColorBold() {
        return chatColorBold;
    }

    private boolean _isChatColorUnderline() {
        return config.getBoolean("chatColor.underline");
    }

    public boolean isChatColorUnderline() {
        return chatColorUnderline;
    }

    private boolean _isChatColorStrike() {
        return config.getBoolean("chatColor.strikethrough");
    }

    public boolean isChatColorStrike() {
        return chatColorStrike;
    }

    private boolean _isChatColorMagic() {
        return config.getBoolean("chatColor.magic");
    }

    public boolean isChatColorMagic() {
        return chatColorMagic;
    }

    private boolean _isChatColorItalic() {
        return config.getBoolean("chatColor.italic");
    }

    public boolean isChatColorItalic() {
        return chatColorItalic;
    }

    private boolean _isChatColorRandom() {
        return config.getBoolean("chatColor.random");
    }

    public boolean isChatColorRandom() {
        return chatColorRandom;
    }

    private boolean _isChatColorRainbow() {
        return config.getBoolean("chatColor.rainbow");
    }

    public boolean isChatColorRainbow() {
        return chatColorRainbow;
    }

    public void setChatColorStyle(String style, boolean enabled) {
        config.setProperty("chatColor." + style, enabled);
        config.save();
    }

    public WinterCraftUserConfig getConfig() {
        return config;
    }

    private long _getTotalTime() {
        return config.getLong("totalTime");
    }

    public Long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Long time) {
        config.setProperty("totalTime", time);
    }

    private Long _getActiveTime() {
        return config.getLong("activeTime");
    }

    public Long getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Long time) {
        config.setProperty("activeTime", time);
        config.save();
    }

    public long getActiveSince() {
        return activeSince;
    }

    public void setActiveSince(long time) {
        this.activeSince = time;
    }

    private Long _getAFKTime() {
        return config.getLong("AFKTime");
    }

    public Long getAFKTime() {
        return AFKTime;
    }

    public void setAFKTime(Long time) {
        config.setProperty("AFKTime", time);
        config.save();
    }

    public long getAFKSince() {
        return AFKSince;
    }

    public void setAFKSince(long time) {
        this.AFKSince = time;
    }
}
