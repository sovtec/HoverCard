package me.hrdu_.hovercard.hovercard.heal;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import net.md_5.bungee.api.chat.TextComponent;

import java.awt.*;

import static com.google.common.base.Ascii.equalsIgnoreCase;

public class Heal implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("doctor")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("*You have been healed lul*");
                return true;
            }
            Player player = (Player) sender;
            if (!player.hasPermission("doctor.use")) {
                player.sendMessage(ChatColor.RED + "You cannot use this command!");
                return true;
            }
            if (args.length == 0)  {
                // doctor /doctor
                TextComponent message = new TextComponent("Would you like to be healed bro");
                message.setColor(ChatColor.DARK_BLUE);
                message.setBold(true);
                message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/doctor healme"));
                message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                        new ComponentBuilder("Click me dude!").color(ChatColor.GRAY).italic(true).create()));
                player.spigot().sendMessage(message);
                return true;

            }
            // /doctor healme
            if (args[0].equalsIgnoreCase("healme")) {
                player.setHealth(20.0);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "heal" + player.getName());
                player.sendMessage(ChatColor.GREEN + "you have been healed newb");
                return true;
            }
            player.sendMessage(ChatColor.RED + "usage: /healmedude");
            return true;
        }
        return false;
    }
}


















