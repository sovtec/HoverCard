package me.hrdu_.hovercard.hovercard;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class HoverCard extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Enabled..");
    }

    @EventHandler
    private ItemStack getExampleItemStack() {
        ItemStack itemStack = new ItemStack(Material.DIAMOND_SWORD);
        ItemStack meta = (ItemStack) itemStack.getItemMeta();
        List<String> lore = new ArrayList<>();

        ((ItemMeta) meta).setDisplayName(ChatColor.YELLOW + "Test");
        lore.add(ChatColor.RED + "SUPERCOOL dude.. or whatever lol");
        ((ItemMeta) meta).setLore(lore);

        ((ItemMeta) meta).addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        ((ItemMeta) meta).addEnchant(Enchantment.FIRE_ASPECT, 2, true);

        itemStack.setItemMeta((ItemMeta) meta);
        return itemStack;
    }

    /**
     * Sends a message to a player with an item as it's tooltip
     *
     * @param player      the player
     * @param message  the message to send
     * @param item        the item to display in the tooltip
     */
    public void sendItemTooltipMessage(Player player, String message, ItemStack item) {
        String itemJson = convertItemStackToJson(item);

        // Prepare a BaseComponent array with the itemJson as a text component
        BaseComponent[] hoverEventComponents = new BaseComponent[]{
                new TextComponent(itemJson) // The only element of the hover events basecomponents is the item json
        };

        // Create the hover event
        HoverEvent event = new HoverEvent(HoverEvent.Action.SHOW_ITEM, hoverEventComponents);

        /* And now we create the text component (this is the actual text that the player sees)
         * and set it's hover event to the item event */
        TextComponent component = new TextComponent(message);
        component.setHoverEvent(event);

        // Finally, send the message to the player
        player.spigot().sendMessage(component);
    }

    private String convertItemStackToJson(ItemStack item) {

        return null;
    }

    @Override
    public void onDisable() {

    }

}


