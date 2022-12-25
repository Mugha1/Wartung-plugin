 package de.tobu.ultra.wartungsmodus.utils;
 
 import de.tobu.ultra.wartungsmodus.Core;
 import de.tobu.ultra.wartungsmodus.config.ConfigManager;
 import java.io.IOException;
 import org.bukkit.ChatColor;
 
 
 
 
 
 
 
 public class Variables
 {
   private Core core;
   private ConfigManager configManager;
   private boolean maintenance;
   private String maintenanceMotd;
   private String kickMessage;
   
   public Variables(Core core) {
     this.core = core;
     this.configManager = core.getConfigManager();
     
     this.maintenance = core.getConfigManager().getFileConfiguration().getBoolean("wartung-aktiv");
     
     this.maintenanceMotd = ChatColor.translateAlternateColorCodes('&', this.configManager.getFileConfiguration().getString("messages.motd"));
     
     this.kickMessage = "";
     this.configManager.getFileConfiguration().getStringList("messages.wartung-ist-aktiv").forEach(s -> this.kickMessage += ChatColor.translateAlternateColorCodes('&', s) + "\n");
   }
   
   public boolean isMaintenance() {
     return this.maintenance;
   }
   
   public void setMaintenance(boolean maintenance) {
     this.maintenance = maintenance;
     this.configManager.getFileConfiguration().set("wartung-aktiv", Boolean.valueOf(maintenance));
     try {
      this.configManager.getFileConfiguration().save(this.configManager.getConfigFile());
     } catch (IOException e) {
      e.printStackTrace();
     } 
   }
   
   public String getMaintenanceMotd() {
     return this.maintenanceMotd;
   }
   
   public String getKickMessage() {
     return this.kickMessage;
   }
 }