package com.juan.ranksystem;


import com.juan.ranksystem.manager.NametagManager;
import com.juan.ranksystem.manager.RankManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {


    /*
            RANK SYSTEM:
                - /rank command
                - Save in .yml file
                - Custom permissions
                - Nametags & chat display
     */


    private RankManager rankManager;
    private NametagManager nametagManager;


    @Override
    public void onEnable() {

       getCommand("rank").setExecutor(new RankCommand(this));

       rankManager = new RankManager(this);
       nametagManager = new NametagManager(this);

       Bukkit.getPluginManager().registerEvents(new RankListener(this), this);
    }

    public RankManager getRankManager() { return rankManager; }

    public NametagManager getNametagManager() { return nametagManager; }
}
