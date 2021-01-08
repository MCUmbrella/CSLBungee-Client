package vip.floatationdevice.mcumbrella.cslbungee.client;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import java.net.*;
import java.io.*;

import cc.baka9.catseedlogin.event.CatSeedPlayerLoginEvent;

public class CSLBC extends JavaPlugin implements Listener
{
	public static CSLBC main;
	int port=14514;
	public void onEnable()
	{
		getLogger().info("Player data will send to 127.0.0.1:14514");
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
			getLogger().info(e.getPlayer().getName()+" login successful. Uploading to Bungee server");
			
			new Thread("CSLBungee Client")
			{
				public void run()
				{
					for(short a=0;a!=5;a++)
					{
						try
						{
							Socket socket = new Socket();
				            InetSocketAddress address=new InetSocketAddress("127.0.0.1", port);
				            socket.connect(address,3000);
				            OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream(),"utf-8");
				            osw.write("CSLBungee-Client-1.0\r\n"+"S\r\n"+e.getPlayer().getName());
				            osw.flush();
				            socket.shutdownOutput();
				            osw.close();
				            socket.close();
				            getLogger().info("Success");
				            break;
						}catch(Throwable ee){if(a==5){getLogger().warning("Failed to change login state of "+e.getPlayer().getName()+": ");ee.printStackTrace();};getLogger().warning("Error sending data. Retrying("+a+"/5) ("+ee.toString()+")");continue;}
					}
				}
			}.start();
			
		}
	}

}
