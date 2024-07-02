package com.juan.ranksystem;

import org.bukkit.ChatColor;

public enum Rank {

    OWNER(ChatColor.DARK_RED + "Owner", new String[]{"book.use"}),
    ADMIN(ChatColor.RED + "Admin", new String[]{"book.use"}),
    MEMBER(ChatColor.YELLOW + "Member", new String[]{}),
    GUEST(ChatColor.GRAY + "Guest", new String[]{});

    private String display;
    private String[] permissions;


    Rank(String display, String[] permissions) {
        this.display = display;
        this.permissions = permissions;
    }

    public String getDisplay() { return display; }

    public String[] getPermissions() { return permissions; }
}
