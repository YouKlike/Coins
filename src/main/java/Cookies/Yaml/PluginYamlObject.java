package Cookies.Yaml;

import Cookies.Main;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public class PluginYamlObject {

    protected File file;
    protected YamlConfiguration configuration;

    public PluginYamlObject(final @NotNull String filename, final boolean isCreate) {
        Plugin plugin = Main.getPlugin();

        this.file = new File(plugin.getDataFolder(), filename);

        if (!this.fileExist())
            if (isCreate)
                try { if (!this.file.createNewFile()) throw new IOException("檔案創建失敗"); } catch (IOException e) {e.printStackTrace();}

            else
                plugin.saveResource(filename, false);

        this.configuration = YamlConfiguration.loadConfiguration(this.file);
    }

    public void loadConfig() {
        this.configuration = YamlConfiguration.loadConfiguration(this.file);
    }

    public void saveConfig() {
        try {
            this.configuration.save(this.file);
        } catch (IOException exception) { exception.printStackTrace();}
    }

    public void set(final @NotNull String string, Object obj) {
        this.configuration.set(string , obj);
    }

    public final boolean fileExist() {
        return this.file.exists();
    }

    public YamlConfiguration getConfiguration() {
        return configuration;
    }
}
