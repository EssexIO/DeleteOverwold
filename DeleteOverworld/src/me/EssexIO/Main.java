package me.EssexIO;

import java.io.IOException;
import java.util.logging.Level;

import org.apache.commons.io.FileUtils;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onDisable() {
		try {
			FileUtils.deleteDirectory(getServer().getWorld("world").getWorldFolder());
		} catch (IOException e) {
			getServer().getLogger().log(Level.INFO, "--- UNABLE TO DELETE OVERWORLD ---");
		}
	}

	@Override
	public void onEnable() {
		getServer().getLogger().log(Level.INFO, "--- WARNING: The overworld **WILL** be deleted when the server stops! ---");
	}
}

