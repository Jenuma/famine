package io.whitegoldlabs.famine.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import io.whitegoldlabs.famine.Famine;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//config.width = 240;
		//config.height = 160;
		new LwjglApplication(new Famine(), config);
	}
}
