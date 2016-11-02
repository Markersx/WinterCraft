package net.mcwintercraft.wintercraft;

import com.earth2me.essentials.EssentialsUserConf;
import com.earth2me.essentials.IConf;
import com.earth2me.essentials.PlayerExtension;
import net.ess3.api.IEssentials;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.List;

public class UserData extends PlayerExtension implements IConf {
    protected final transient IEssentials ess;
    private final EssentialsUserConf config;
    private final File folder;
    private String lastAccountName = null;

    private List<String> warpsList;
    private int warpsMax;

    private int totalVotes;
    //vote timestamps

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
    private boolean chatColorStrikethrough;
    private boolean chatColorMagic;
    private boolean chatColorItalic;
    private boolean chatColorRandom;
    private boolean chatColorRainbow;


    protected UserData(Player base, IEssentials ess) {
        super(base);
        this.ess = ess;
        this.folder = new File(ess.getDataFolder(), "userdata");
        if(!this.folder.exists()) {
            this.folder.mkdirs();
        }

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

    @Override
    public final void reloadConfig() {
        this.warpsList = _getWarpsList();
        this.warpsMax = _getWarpsMax();

        this.totalVotes = _getTotalVotes();

        this.joinSound = _getJoinSound();
        this.joinSoundEnabled = _isJoinSoundEnabled();
        this.joinSoundVolume = _getJoinSoundVolume();
        this.joinSoundPitch = _getJoinSoundPitch();
        this.quitSoundSound = _getQuitSoundSound();
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
        this.chatColorStrikethrough = _isChatColorStrikethrough();
        this.chatColorMagic = _isChatColorMagic();
        this.chatColorItalic = _isChatColorItalic();
        this.chatColorRandom = _isChatColorRandom();
        this.chatColorRainbow = _isChatColorRainbow();
        this.lastAccountName = _getLastAccountName();
    }

    private List<String> _getWarpsList() {
        return this.config.getStringList("warps.list");
    }

    private int _getWarpsMax() {
        return this.config.getInt("warps.max");
    }

    private int _getTotalVotes() {
        return this.config.getInt("votes.total");
    }

    private String _getJoinSound() {
        return this.config.getString("sounds.join.sound");
    }

    private boolean _isJoinSoundEnabled() {
        return this.config.getBoolean("sounds.join.enabled");
    }

    private int _getJoinSoundVolume() {
        return this.config.getInt("sounds.join.volume");
    }

    private int _getJoinSoundPitch() {
        return this.config.getInt("sounds.join.pitch");
    }

    private String _getQuitSoundSound() {
        return this.config.getString("sounds.quit.sound");
    }

    private boolean _isQuitSoundEnabled() {
        return this.config.getBoolean("sounds.quit.enabled");
    }

    private int _getQuitSoundVolume() {
        return this.config.getInt("sounds.quit.volume");
    }

    private int _getQuitSoundPitch() {
        return this.config.getInt("sounds.quit.pitch");
    }

    private String _getMessageSound() {
        return this.config.getString("sounds.message.sound");
    }

    private boolean _isMessageSoundEnabled() {
        return this.config.getBoolean("sounds.message.enabled");
    }

    private int _getMessageSoundVolume() {
        return this.config.getInt("sounds.message.volume");
    }

    private int _getMessageSoundPitch() {
        return this.config.getInt("sounds.message.pitch");
    }

    private String _getChatColor() {
        return this.config.getString("sounds.color");
    }

    private boolean _isChatColorBold() {
        return this.config.getBoolean("sounds.bold");
    }

    private boolean _isChatColorUnderline() {
        return this.config.getBoolean("sounds.underline");
    }

    private boolean _isChatColorStrikethrough() {
        return this.config.getBoolean("chatColor.strikethrough");
    }

    private boolean _isChatColorMagic() {
        return this.config.getBoolean("chatColor.magic");
    }

    private boolean _isChatColorItalic() {
        return this.config.getBoolean("chatColor.italic");
    }

    private boolean _isChatColorRandom() {
        return this.config.getBoolean("chatColor.random");
    }

    public boolean _isChatColorRainbow() {
        return this.config.getBoolean("chatColor.rainbow");
    }

    public String _getLastAccountName() {
        return this.config.getString("chatColor.lastAccountName", null);
    }
}
