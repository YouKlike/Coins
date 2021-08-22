package Cookies;

import Cookies.Command.resetCommand;
import Cookies.Yaml.PluginConfig;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin {

    private static Main plugin;
    private PluginConfig config;

    @Override
    public void onEnable() {
        Main.plugin = this;
        this.config = new PluginConfig();
        Objects.requireNonNull(this.getCommand("coins")).setExecutor(new resetCommand());
    }

    public PluginConfig getPluginConfig() {
        return this.config;
    }

    public static Main getPlugin() { return Main.plugin; }

}
