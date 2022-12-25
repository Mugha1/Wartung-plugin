 package de.tobu.ultra.wartungsmodus;

 import de.tobu.ultra.wartungsmodus.commands.WartungCommand;
 import de.tobu.ultra.wartungsmodus.config.ConfigManager;
 import de.tobu.ultra.wartungsmodus.listeners.JoinListener;
 import de.tobu.ultra.wartungsmodus.listeners.ServerListPingListener;
 import de.tobu.ultra.wartungsmodus.utils.Variables;
 import org.bukkit.plugin.java.JavaPlugin;
 
 
 public class Core
   extends JavaPlugin
 {
   private Variables variables;
   private ConfigManager configManager;
   
   public void onEnable() {
     init();
   }
 
 
   
   public void onDisable() {}
 
 
   
   public void init() {
     this.configManager = new ConfigManager(this);
     this.configManager.setupConfig();
     this.variables = new Variables(this);
     
     new WartungCommand(this);
     
     new JoinListener(this);
     new ServerListPingListener(this);
   }
   
   public Variables getVariables() {
     return this.variables;
   }
   
   public ConfigManager getConfigManager() {
     return this.configManager;
   }
 }
