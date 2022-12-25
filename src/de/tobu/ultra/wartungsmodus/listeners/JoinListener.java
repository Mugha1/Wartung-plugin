 package de.tobu.ultra.wartungsmodus.listeners;
 
 import de.tobu.ultra.wartungsmodus.Core;
 import de.tobu.ultra.wartungsmodus.utils.Variables;
 import org.bukkit.Bukkit;
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.Listener;
 import org.bukkit.event.player.PlayerJoinEvent;
 import org.bukkit.plugin.Plugin;
 
 public class JoinListener
   implements Listener {
   private Variables variables;
   
   public JoinListener(Core core) {
     this.variables = core.getVariables();
     Bukkit.getPluginManager().registerEvents(this, (Plugin)core);
   }
 
   
   @EventHandler
   public void handlePlayerJoin(PlayerJoinEvent event) {
     if (this.variables.isMaintenance() && 
       !event.getPlayer().hasPermission("streetcity.wartung.bypass"))
       event.getPlayer().kickPlayer(this.variables.getKickMessage().toString()); 
   }
 }
