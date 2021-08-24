package Cookies.Yaml;

import Cookies.Main;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.*;

public final class PlayerCoinsData
        extends PlayerData {

    private int coins = 0;

    public PlayerCoinsData(final @NotNull OfflinePlayer player) {
        super(player);
        this.coins = this.configuration.getInt("Coins");
        this.initData();
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(final int newCoins) {
        this.coins = newCoins;
        this.set("Coins", this.coins);
        this.saveConfig();
    }

    @Override
    protected void initData() {
        this.set("Coins", this.coins);
        super.initData();
    }

    public static PlayerCoinsData getPlayerData(final @NotNull Player player) {
        return new PlayerCoinsData(player);
    }


    // 排列玩家的代幣由大到小
    public static List<PlayerCoinsData> getPlayers() {
        final List<PlayerCoinsData> dataList = new LinkedList<>();

        final File path = new File(Main.getPlugin().getDataFolder(), "data/");
        final File[] files = path.listFiles();
        for (int i = 0; i < Objects.requireNonNull(files).length; i++) {
            final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(files[i]);
            final UUID uuid = UUID.fromString(Objects.requireNonNull(configuration.getString("uuid")));
            dataList.add(new PlayerCoinsData(Bukkit.getOfflinePlayer(uuid)));
        }

        dataList.sort((o1, o2) -> o2.getCoins() - o1.getCoins());
        return dataList;
    }

}
