package Cookies.Yaml;

import com.sun.java.accessibility.util.internal.TextComponentTranslator;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;

public class PluginConfig
        extends PluginYamlObject{

    private final static String RELOAD_MESSAGE = "reloadMessage";
    private final static String COINS_AMOUNT_MESSAGE = "coinsAmountMessage";
    private final static String HELP_MESSAGE = "helpMessage";
    private final static String SET_MESSAGE = "setMessage";
    private final static String RESET_MESSAGE = "resetMessage";
    private final static String LEAD_MESSAGE = "leadMessage";
    private final static String NEXT_MESSAGE = "nextMessage";
    private final static String PREVIOUS_MESSAGE = "previousMessage";

    public PluginConfig() {
        super("Config.yml", false);
    }

    public static String translate(final String msg) {
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

    public String getLeadMessage() {
        final String leadMessage = this.configuration.getString(LEAD_MESSAGE);

        if (leadMessage != null)
            return leadMessage;

        return "ERROR MESSAGE";
    }

    public String getNextMessage() {
        final String nextMessage = this.configuration.getString(NEXT_MESSAGE);

        if (nextMessage != null)
            return nextMessage;

        return "ERROR MESSAGE";
    }

    public String getPreviousMessage() {
        final String previousMessage = this.configuration.getString(PREVIOUS_MESSAGE);

        if (previousMessage != null)
            return previousMessage;

        return "ERROR MESSAGE";
    }

}


