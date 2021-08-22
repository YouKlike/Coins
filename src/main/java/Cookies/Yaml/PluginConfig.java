package Cookies.Yaml;

import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

public class PluginConfig
        extends PluginYamlObject{

    private final static String RELOAD_MESSAGE = "reloadMessage";
    private final static String COINS_AMOUNT_MESSAGE = "coinsAmountMessage";
    private final static String HELP_MESSAGE = "helpMessage";
    private final static String SET_MESSAGE = "setMessage";
    private final static String RESET_MESSAGE = "resetMessage";

    public PluginConfig() {
        super("Config.yml", false);
    }

    public static String translate(final @NotNull String msg) {
        return ChatColor.translateAlternateColorCodes('&' , msg);
    }

    public String getReloadMessage() {
        final String reloadMessage = this.configuration.getString(RELOAD_MESSAGE);

        if (reloadMessage != null) {
            return reloadMessage;
        }
        return "ERROR MESSAGE";
    }

    public String getCoinsAmountMessage() {
        final String CoinsAmount = this.configuration.getString(COINS_AMOUNT_MESSAGE);

        if (CoinsAmount != null)
            return CoinsAmount;

        return "ERROR MESSAGE";
    }

    public String getSetMessage() {
        final String giveMessage = this.configuration.getString(SET_MESSAGE);

        if (giveMessage != null)
            return giveMessage;

        return "ERROR MESSAGE";
    }

    public String getResetMessage() {
        final String resetMessage = this.configuration.getString(RESET_MESSAGE);

        if (resetMessage != null)
            return resetMessage;
        return "ERROR MESSAGE";

    }

    public String getHelpMessage() {
        final String helpMessage = this.configuration.getString(HELP_MESSAGE);

        if (helpMessage != null)
            return helpMessage;

        return "ERROR MESSAGE";
    }

}


