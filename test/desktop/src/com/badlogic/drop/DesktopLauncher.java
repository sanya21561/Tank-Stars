package com.badlogic.drop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.drop.TankStars;

// Please note that on macOS your application needs to be started with the -Xsta/irstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setTitle("TankStars");
		config.setWindowedMode(761, 400);
		config.useVsync(true);
		config.setForegroundFPS(60);
		new Lwjgl3Application(new TankStars(), config);
	}
}
