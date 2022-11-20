package com.mgrimm21.gefinal.scene;

import java.awt.Graphics;
import java.util.ArrayList;

import com.mgrimm21.gefinal.objects.GameObject;
import com.mgrimm21.gefinal.ui.UIElement;

public class Scene {

	private ArrayList<GameObject> objects = new ArrayList<GameObject>();
	private ArrayList<UIElement> elements = new ArrayList<>();
	
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
	
	public synchronized void add(UIElement obj) {
		synchronized (elements) {
			elements.add(obj);
		}
	}
	
	public synchronized void remove(UIElement obj) {
		synchronized (elements) {
			elements.remove(obj);
		}
	}
	
	public synchronized void tick() {
		synchronized (objects) {
			for (GameObject o: objects) o.tick();
		}
		
		synchronized (elements) {
			for (UIElement o: elements) o.tick();
		}
	}
	
	public synchronized void render(Graphics g) {
		synchronized (objects) {
			for (GameObject o: objects) o.render(g);
		}
		
		synchronized (elements) {
			for (UIElement o: elements) o.render(g);
		}
	}
	
}
