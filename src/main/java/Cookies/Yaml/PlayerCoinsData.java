package Cookies.Yaml;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public final class PlayerCoinsData
        extends PlayerData {

    private int coins = 0;

    public PlayerCoinsData(final @NotNull Player player) {
        super(player);
        this.coins = this.configuration.getInt("Coins");

        this.initData();
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(final int newCoins) {
        this.coins = newCoins;
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

}
