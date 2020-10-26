package me.poma123.globalwarming.commands.subcommands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import io.github.thebusybiscuit.slimefun4.utils.PatternUtils;
import me.mrCookieSlime.Slimefun.cscorelib2.chat.ChatColors;
import me.mrCookieSlime.Slimefun.cscorelib2.math.DoubleHandler;
import me.poma123.globalwarming.GlobalWarmingPlugin;
import me.poma123.globalwarming.api.PollutionManager;
import me.poma123.globalwarming.commands.GlobalWarmingCommand;
import me.poma123.globalwarming.commands.SubCommand;

class PollutionCommand extends SubCommand {

    PollutionCommand(GlobalWarmingPlugin plugin, GlobalWarmingCommand cmd) {
        super(plugin, cmd, "pollution", "允许你手动更改污染值", false);
    }

    @Override
    public void onExecute(CommandSender sender, String[] args) {
        if (sender.hasPermission("globalwarming.command.pollution") || !(sender instanceof Player)) {
            if (args.length > 2) {
                World world = Bukkit.getWorld(args[2]);

                if (world != null && GlobalWarmingPlugin.getRegistry().isWorldEnabled(world.getName())) {
                    if (args[1].equalsIgnoreCase("get")) {
                        double pollution = DoubleHandler.fixDouble(PollutionManager.getPollutionInWorld(world), 2);

                        sender.sendMessage(ChatColors.color("&b在世界 &a" + world.getName() + "的污染值&b: &a" + pollution));
                    } else if (args[1].equalsIgnoreCase("set")) {
                        if (args.length > 3) {
                            setPollution(sender, world, args);
                        } else {
                            sender.sendMessage(ChatColors.color("&4用法: &c/globalwarming pollution set <世界> <数量>"));
                        }
                    }
                } else {
                    sender.sendMessage(ChatColors.color("&4这个插件在该世界被禁用."));
                }
            } else {
                sender.sendMessage(ChatColors.color("&4用法: &c/globalwarming pollution <set|get> <世界>"));
            }
        } else {
            sender.sendMessage(ChatColors.color("&4你的权限不足"));
        }
    }

    private void setPollution(CommandSender sender, World world, String[] args) {
        int amount = parseAmount(args);

        if (amount > -1) {
            if (PollutionManager.setPollutionInWorld(world, amount)) {
                sender.sendMessage(ChatColors.color("&b你已经更改污染值到 '&a%newValue%&b' 在世界 '&a%world%&b'").replace("%newValue%", amount + "").replace("%world%", world.getName()));
            } else {
                // This is nearly impossible, but let us check
                sender.sendMessage(ChatColors.color("&4这个插件在该世界被禁用."));
            }
        } else {
            sender.sendMessage(ChatColors.color("&4%amount% &c不是合法数值").replace("%amount%", amount + ""));
        }
    }

    private int parseAmount(String[] args) {
        int amount = -1;

        if (args.length == 4 && PatternUtils.NUMERIC.matcher(args[3]).matches()) {
            amount = Integer.parseInt(args[3]);
        }

        return amount;
    }
}
