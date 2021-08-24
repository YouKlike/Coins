package Cookies.Command;

import Cookies.Main;
import Cookies.Yaml.PlayerCoinsData;
import Cookies.Yaml.PluginConfig;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Entity;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

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
                    setMessage = setMessage.replace("{COINS}", args[2]);
                    player.sendMessage(PluginConfig.translate(setMessage));
                    PlayerCoinsData.getPlayerData(player1).setCoins(Integer.parseInt(args[2]));
                }

            }


            if (args.length >= 1 && args[0].equalsIgnoreCase("lead")) {

                    if (args.length == 1) {
                        final List<PlayerCoinsData> players = PlayerCoinsData.getPlayers();
                        int page = 0;
                        for (int i = page ; i < page + 5 ; i++) {
                            try {
                                final PlayerCoinsData data = players.get(i);
                                player.sendMessage("玩家: " + data.getPlayer().getName() + " 的金錢有: " + data.getCoins());
                            } catch (IndexOutOfBoundsException ignored) {}
                        }
                        TextComponent message = new TextComponent("下一頁");
                        message.setBold(true);
                        message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/coins lead 2"));
                        player.spigot().sendMessage(message);
                        return true;
                    }

                    if (args.length == 2) {
                        final List<PlayerCoinsData> players = PlayerCoinsData.getPlayers();
                        int page = (Integer.parseInt(args[1]) - 1) * 5; // page = 0
                        for (int i = page; i < page + 5; i++) {
                            try {
                                final PlayerCoinsData data = players.get(i);
                                player.sendMessage("玩家: " + data.getPlayer().getName() + " 的金錢有: " + data.getCoins());
                            } catch (IndexOutOfBoundsException ignored) { }
                        }
                        TextComponent nextPageMessage = new TextComponent("下一頁");
                        TextComponent previousPageMessage = new TextComponent(" " + "上一頁");
                        nextPageMessage.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/coins lead " + (Integer.parseInt(args[1]) + 1)));
                        previousPageMessage.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND , "/coins lead " + (Integer.parseInt(args[1]) - 1)));
                        nextPageMessage.addExtra(previousPageMessage);
                        player.spigot().sendMessage(nextPageMessage);
                        return true;
                    }
            }
            return false;
        }
        return true;
    }
}
