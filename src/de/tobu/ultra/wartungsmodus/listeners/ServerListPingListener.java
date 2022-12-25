 package de.tobu.ultra.wartungsmodus.listeners;
 
 import de.tobu.ultra.wartungsmodus.Core;
 import de.tobu.ultra.wartungsmodus.utils.Variables;
 import org.bukkit.Bukkit;
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.Listener;
 import org.bukkit.event.server.ServerListPingEvent;
 import org.bukkit.plugin.Plugin;
 
 public class ServerListPingListener implements Listener {
   private Variables variables;
   
   public ServerListPingListener(Core core) {
     this.variables = core.getVariables();
     Bukkit.getPluginManager().registerEvents(this, (Plugin)core);
   }
 
   
   @EventHandler
   public void handleServerListPing(ServerListPingEvent event) {
     if (this.variables.isMaintenance())
       event.setMotd(this.variables.getMaintenanceMotd()); 
   }
 }