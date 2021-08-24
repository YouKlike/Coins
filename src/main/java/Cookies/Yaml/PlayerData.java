package Cookies.Yaml;

import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

public abstract class PlayerData
        extends PluginYamlObject {

    protected final OfflinePlayer player;

    public PlayerData(final @NotNull OfflinePlayer player) {
        super("/data/" + player.getUniqueId() + ".yml", true);
        this.player = player;
    }

    @NotNull
    public final OfflinePlayer getPlayer() {
        return player;
    }

    protected void initData() {
        this.configuration.set("uuid", this.player.getUniqueId().toString());
        this.saveConfig();
    }

}
