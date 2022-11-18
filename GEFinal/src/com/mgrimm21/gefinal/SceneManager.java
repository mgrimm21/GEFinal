package com.mgrimm21.gefinal;

import java.awt.Graphics;

public class SceneManager {
	private Scene activeScene = new Scene();
	
	public synchronized void tick() {
		activeScene.tick();
	}
	
	public synchronized void render(Graphics g) {
		activeScene.render(g);
	}
	
	public void setScene(Scene scene) {
		activeScene = scene;
	}
	
}
