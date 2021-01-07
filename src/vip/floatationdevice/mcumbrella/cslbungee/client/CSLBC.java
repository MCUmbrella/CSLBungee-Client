package vip.floatationdevice.mcumbrella.cslbungee.client;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import cc.baka9.catseedlogin.event.CatSeedPlayerLoginEvent;

public class CSLBC extends JavaPlugin implements Listener
{
	public static CSLBC main;
	public void onEnable()
	{
		getLogger().info("Enabling.");
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	public void onDisable()
	{
		getLogger().info("Disabled.");
	}
	@EventHandler
	public void onLogin(CatSeedPlayerLoginEvent e)
	{
		if(e.getResult() == CatSeedPlayerLoginEvent.Result.SUCCESS)
		{
			getLogger().info(e.getPlayer().getName()+" login successful");
		}
	}

}
