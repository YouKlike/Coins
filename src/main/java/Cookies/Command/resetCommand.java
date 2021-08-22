package Cookies.Command;

import Cookies.Main;
import Cookies.Yaml.PlayerCoinsData;
import Cookies.Yaml.PluginConfig;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class resetCommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 0) {
                int coins = PlayerCoinsData.getPlayerData(player).getCoins();
                String coinsAmountMessage = Main.getPlugin().getPluginConfig().getCoinsAmountMessage();
                coinsAmountMessage = coinsAmountMessage.replace("{COINS}", "" + coins);
                player.sendMessage(PluginConfig.translate(coinsAmountMessage));
            }

            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("reload")){
                    player.sendMessage(PluginConfig.translate(Main.getPlugin().getPluginConfig().getReloadMessage()));
                    Main.getPlugin().getPluginConfig().loadConfig();
                }

                if (args[0].equalsIgnoreCase("help"))
                    player.sendMessage(PluginConfig.translate(Main.getPlugin().getPluginConfig().getHelpMessage()));
            }

            if (args.length == 2) {
                Player player1 = Bukkit.getPlayer(args[1]);
                if (args[0].equalsIgnoreCase("reset") && player1 != null) {
                    String resetMessage = Main.getPlugin().getPluginConfig().getResetMessage();
                    resetMessage = resetMessage.replace("{PLAYER}", player1.getName());
                    player.sendMessage(PluginConfig.translate(resetMessage));
                    PlayerCoinsData.getPlayerData(player1).setCoins(0);
                }

            }

            if (args.length == 3) {
                Player player1 = Bukkit.getPlayer(args[1]);
                if (args[0].equalsIgnoreCase("set") && player1 != null) {
                    String setMessage = Main.getPlugin().getPluginConfig().getSetMessage() ;
                    setMessage = setMessage.replace("{PLAYER}" , player1.getName());
                    player.sendMessage(PluginConfig.translate(setMessage));
                    PlayerCoinsData.getPlayerData(player1).setCoins(Integer.parseInt(args[2]));
                }

            }

                return false;
        }
        return true;
    }
}
