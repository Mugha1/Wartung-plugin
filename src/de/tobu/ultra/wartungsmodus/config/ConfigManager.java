 package de.tobu.ultra.wartungsmodus.config;
 
 import de.tobu.ultra.wartungsmodus.Core;
 import java.io.File;
 import java.io.IOException;
 import org.bukkit.configuration.file.FileConfiguration;
 import org.bukkit.configuration.file.YamlConfiguration;
 
 
 
 
 public class ConfigManager
 {
   private Core core;
   private static ConfigManager configManager;
   private File configFile;
   private FileConfiguration fileConfiguration;
   
   public ConfigManager(Core core) {
     this.core = core;
   }
   
   public FileConfiguration getFileConfiguration() {
     return this.fileConfiguration;
   }
   
   public void setupConfig() {
     configManager = this;
     
     this.configFile = new File(this.core.getDataFolder(), "config.yml");
     
     if (!this.configFile.exists()) {
       this.configFile.getParentFile().mkdirs();
       this.core.saveResource("config.yml", false);
     } 
     
     this.fileConfiguration = (FileConfiguration)new YamlConfiguration();
     try {
       this.fileConfiguration.load(this.configFile);
       this.core.getLogger().info("# §aDie Config wurde erfolgreich geladen!");
     } catch (IOException|org.bukkit.configuration.InvalidConfigurationException e) {
       this.core.getLogger().severe("# §cFehler beim Laden der Config:");
       e.printStackTrace();
     } 
   }
 
   
   public static ConfigManager getInstance() {
     return configManager;
   }
   
   public File getConfigFile() {
     return this.configFile;
   }
 }
