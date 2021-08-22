package Cookies.Yaml;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public abstract class PlayerData
        extends PluginYamlObject {

    protected final Player player;

    public PlayerData(final @NotNull Player player) {
        super("/data/" + player.getUniqueId() + ".yml", true);
        this.player = player;
    }

    @NotNull
    public final Player getPlayer() {
        return player;
    }

    protected void initData() {
        this.configuration.set("uuid", this.player.getUniqueId().toString());
        this.saveConfig();
    }

}
