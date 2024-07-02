package com.juan.ranksystem;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.permissions.PermissionAttachment;

public class RankListener implements Listener {

    private Main main;

    public RankListener(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();

        if (player.hasPlayedBefore()) {
            main.getRankManager().setRank(player.getUniqueId(), Rank.GUEST, true);
        }
        main.getNametagManager().setNametags(player);
        main.getNametagManager().newTag(player);

        PermissionAttachment attachment;
        if (main.getRankManager().getPerms().containsKey(player.getUniqueId())) {
            attachment = main.getRankManager().getPerms().get(player.getUniqueId());
        } else {
            attachment = player.addAttachment(main);
            main.getRankManager().getPerms().put(player.getUniqueId(), attachment);
        }
        for (String perm : main.getRankManager().getRank(player.getUniqueId()).getPermissions()) {
            attachment.setPermission(perm, true);
        }



    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        main.getNametagManager().removeTag(e.getPlayer());
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {

        e.setCancelled(true);
        Player player = e.getPlayer();

        Bukkit.broadcastMessage(main.getRankManager().getRank(player.getUniqueId()).getDisplay() + " " + player.getName() + ": "+ ChatColor.GRAY + e.getMessage());

    }

}
