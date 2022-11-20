package com.mgrimm21.gefinal.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import com.mgrimm21.gefinal.io.Mouse;
import com.mgrimm21.gefinal.logic.LoopListener;
import com.mgrimm21.gefinal.scene.Scene;
import com.mgrimm21.gefinal.scene.SceneManager;

public class Game implements Runnable{
	
	private Thread thread;
	private boolean running = false;
	public Window window;
	private SceneManager sceneManager = new SceneManager();
	private ArrayList<LoopListener> loopListeners = new ArrayList<LoopListener>();
	private int width, height;
	
	public Game(String name, int width, int height) {
		this.width = width;
		this.height = height;
		window = new Window(name, width, height);
		thread = new Thread(this);
	}
	
	private void tick() {
		try {
			Mouse.mouseX = window.canvas.getMousePosition().x;
			Mouse.mouseY = window.canvas.getMousePosition().y;
		}catch(Exception e) {
			
		}
		
		sceneManager.tick();
		for (LoopListener l: loopListeners) l.tick();
	}
	
	private void render() {
		BufferStrategy bs = window.bs;
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.red);
		g.fillRect(0, 0, width, height);
		sceneManager.render(g);
		for (LoopListener l: loopListeners) l.render(g);
		bs.show();
		g.dispose();
	}
	
	public void registerLoopListener(LoopListener listener) {
		loopListeners.add(listener);
	}
	
	public void removeLoopListener(LoopListener listener) {
		loopListeners.remove(listener);
	}
	
	public synchronized void start() {
		if (running) return;
		running = true;
		thread.start();
	}
	
	public synchronized void stop() {
		if (!running) return;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		running = false;
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();

        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if(delta >= 1){
            	tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println(updates + " Ticks, Fps " + frames);
                updates = 0;
                frames = 0;
            }

        }
        stop();
	}
	
	public void setScene(Scene scene) {
		sceneManager.setScene(scene);
	}
	
	

}
