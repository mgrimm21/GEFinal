package com.mgrimm21.test;

import java.awt.Color;
import java.awt.event.KeyEvent;

import com.mgrimm21.gefinal.gfx.Sprite;
import com.mgrimm21.gefinal.io.Keyboard;
import com.mgrimm21.gefinal.main.Game;
import com.mgrimm21.gefinal.objects.SpriteObject;
import com.mgrimm21.gefinal.scene.Scene;
import com.mgrimm21.gefinal.ui.Button;

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
		
		Button b = new Button(100, 100, 100, 32, Color.gray, Color.LIGHT_GRAY, Color.DARK_GRAY, "Test") {

			@Override
			public void onClick() {
				System.out.println("Test");
			}
			
		};
		scene.add(b);
		Player player = new Player(85, 85);
		scene.add(player);
		scene.add(o);
		game.setScene(scene);
		
	}
	
	public static void main(String[] args) {
		new Test();
	}
	
}
