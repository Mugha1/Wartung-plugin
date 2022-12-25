 package de.tobu.ultra.wartungsmodus.commands;
 
 import de.tobu.ultra.wartungsmodus.Core;
 import de.tobu.ultra.wartungsmodus.utils.Variables;
 import org.bukkit.Bukkit;
 import org.bukkit.command.Command;
 import org.bukkit.command.CommandExecutor;
 import org.bukkit.command.CommandSender;
 
 public class WartungCommand
   implements CommandExecutor {
   private Variables variables;
   
   public WartungCommand(Core core) {
     this.variables = core.getVariables();
     Bukkit.getPluginCommand("wartung").setExecutor(this);
   }
 
 
   
   public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
     if (sender.hasPermission("ultra.command.wartung"))
     { if (args.length >= 1) {
         if (args[0].equalsIgnoreCase("an")) {
           if (this.variables.isMaintenance()) {
             sender.sendMessage("§cDer Wartungsmodus ist bereits aktiv!");
           } else {
             this.variables.setMaintenance(true);
             sender.sendMessage("§aDer Wartungsmodus wurde aktiviert!");
           } 
         } else if (args[0].equalsIgnoreCase("aus")) {
           if (this.variables.isMaintenance()) {
             this.variables.setMaintenance(false);
             sender.sendMessage("§aDer Wartungsmodus wurde deaktiviert!");
           } else {
             sender.sendMessage("§cDer Wartungsmodus ist bereits deaktiviert!");
           } 
         } 
       } else {
         
         sender.sendMessage("§fBitte verwende §e/wartung <an | aus>");
       }  }
     else { sender.sendMessage("§cDafür hast du keine Rechte!"); }
     
     return false;
   }
 }
