package vip.floatationdevice.mcumbrella.cslbungee.client;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import cc.baka9.catseedlogin.event.*;

public class CSLBC extends JavaPlugin
{
	public static CSLBC main;
	public void onEnable()
	{
		getLogger().info("Enabling.");
		Bukkit.getPluginManager().registerEvents((Listener)CSLBCE.main, (Plugin)CSLBC.main);
	}
	public void onDisable()
	{
		getLogger().info("Disabled.");
	}
}
