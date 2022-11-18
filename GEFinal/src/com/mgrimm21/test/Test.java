package com.mgrimm21.test;

import java.awt.event.KeyEvent;

import com.mgrimm21.gefinal.Game;
import com.mgrimm21.gefinal.Keyboard;
import com.mgrimm21.gefinal.Scene;
import com.mgrimm21.gefinal.Sprite;
import com.mgrimm21.gefinal.SpriteObject;
import com.mgrimm21.gefinal.SpriteSheet;

public class Test {
	
	public Test() {
		Game game = new Game("Test", 640, 480);
		game.start();
		Scene scene = new Scene();
		SpriteObject o = new SpriteObject(new Sprite("goldBar.PNG", 32, 32), 50, 50) {
			@Override
			public void tick() {
				super.tick();
				if (Keyboard.isKeyDownOnce(KeyEvent.VK_G)) {
					x+=4;
					System.out.println("G");
				}
			}
		};
		Player player = new Player(85, 85);
		scene.add(player);
		scene.add(o);
		game.setScene(scene);
		SpriteSheet playerSheet = new SpriteSheet("player.png", 32, 16);
		
	}
	
	public static void main(String[] args) {
		new Test();
	}
	
}
