package com.mgrimm21.gefinal;

import java.awt.Graphics;
import java.util.ArrayList;

public class Scene {

	private ArrayList<GameObject> objects = new ArrayList<GameObject>();
	
	public synchronized void add(GameObject obj) {
		synchronized (objects) {
			objects.add(obj);
		}
	}
	
	public synchronized void remove(GameObject obj) {
		synchronized (objects) {
			objects.remove(obj);
		}
	}
	
	public synchronized void tick() {
		synchronized (objects) {
			for (GameObject o: objects) o.tick();
		}
	}
	
	public synchronized void render(Graphics g) {
		synchronized (objects) {
			for (GameObject o: objects) o.render(g);
		}
	}
	
}
