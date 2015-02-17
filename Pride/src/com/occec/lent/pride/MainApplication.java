package com.occec.lent.pride;

import android.app.Application;

public class MainApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		FontsOverride.setDefaultFont(this, "DEFAULT", "Avenir-Light.ttf");
		FontsOverride.setDefaultFont(this, "DEFAULT_BOLD", "Avenir-Black.ttf");
		FontsOverride.setDefaultFont(this, "SANS_SERIF", "Avenir-Light.ttf");
		FontsOverride.setDefaultFont(this, "MONOSPACE", "Avenir-Black.ttf");
	}

}
