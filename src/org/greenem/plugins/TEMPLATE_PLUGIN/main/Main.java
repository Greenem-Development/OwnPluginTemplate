package org.greenem.plugins.TEMPLATE_PLUGIN.main;

import static org.greenem.plugins.TEMPLATE_PLUGIN.util.SimpleLogger.debug;
import static org.greenem.plugins.TEMPLATE_PLUGIN.util.SimpleLogger.log;
import static org.greenem.plugins.TEMPLATE_PLUGIN.util.Stash.isSenderAPlayer;
import static org.greenem.plugins.TEMPLATE_PLUGIN.util.Stash.isSenderAPlayerOrConsole;

import java.io.File;
import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.greenem.plugins.TEMPLATE_PLUGIN.config.ConfigOperations;
import org.greenem.plugins.TEMPLATE_PLUGIN.data.ProjectInfo;
import org.greenem.plugins.TEMPLATE_PLUGIN.data.References;
import org.greenem.plugins.TEMPLATE_PLUGIN.util.DebugModeSwitch;
import org.greenem.plugins.TEMPLATE_PLUGIN.util.OsDependent;
import org.greenem.plugins.TEMPLATE_PLUGIN.util.SimpleLogger;

public class Main extends JavaPlugin implements Listener {
	public Plugin plugin = this;

	private static Main instance;
	public static Main getInstance() { // not synchronized, but that's ok
		return instance;
	}
	
	@Override
	public void onEnable() {
		instance = this;
		log(ProjectInfo.projectName + "plugin has been enabled!"); // ChatColor.GREEN?
		initAll();
		ConfigOperations.updateAndLoadConfig();
		finishInit();
	}
	
	@Override
	public void onDisable() {
		log(ProjectInfo.projectName + " plugin has been disabled");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player p = null;
//		String name = sender.getName();
		try {
			p = (Player) sender;
		} catch (ClassCastException e) {}
		
//		if(cmd.getName().equalsIgnoreCase("test")){
//			if(isSenderAPlayerOrConsole(sender)) {
//				
//			}
//		}
		return true;
	}
    
	private void initAll() {
		initFiles();
		DebugModeSwitch.init();
		References.os = OsDependent.getSystemType();
		registerListeners();
		RegisterAllCommands();
	}
	
	private void registerListeners() {
		Bukkit.getPluginManager().registerEvents(this, this);
//		Bukkit.getPluginManager().registerEvents(new Test(), this);
	}
	
	private void RegisterAllCommands() { // can forget to change command name everywhere and get a bug
//		getCommand("test").setTabCompleter(new TestCompleter());
	}
	
	private void initFiles() {
		ProjectInfo.serverDirectory = Bukkit.getWorldContainer();
		ProjectInfo.configsDirectory = new File(ProjectInfo.serverDirectory, "plugins/configs");
		ProjectInfo.pluginConfigDirectory = new File(ProjectInfo.configsDirectory, "ManhuntAndWorldReset");
		ProjectInfo.pluginConfigDirectory.mkdirs();
	}
	
	private void finishInit() {
		if(SimpleLogger.debugOutputEnabled) {
			log(ChatColor.AQUA + "Debug mode is enabled");
		}
	}
}