package com.mgrimm21.test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import com.mgrimm21.gefinal.gfx.Animation;
import com.mgrimm21.gefinal.gfx.SpriteSheet;
import com.mgrimm21.gefinal.io.Keyboard;
import com.mgrimm21.gefinal.objects.GameObject;

public class Player extends GameObject{
	
	private Animation walkLeft, walkRight, walkUp, walkDown;
	private int direction = 0; //0 none 1 left 2 right 3 up 4 dowwn
	private SpriteSheet sheet;
	BufferedImage[] right;
	public Player(float x, float y) {
		super(x, y);
		sheet = new SpriteSheet("player.png", 16, 32);
		right = new BufferedImage[6];
		for (int i = 0; i < 6; i ++) {
			right[i] = sheet.getSprite(i);
		}
		BufferedImage[] up = new BufferedImage[6];
		for (int i = 7; i < 12; i ++) {
			up[i-6] = sheet.getSprite(i);
		}
		BufferedImage[] left = new BufferedImage[6];
		for (int i = 13; i < 18; i ++) {
			left[i-12] = sheet.getSprite(i);
		}
		BufferedImage[] down = new BufferedImage[6];
		for (int i = 19; i <24; i ++) {
			down[i-18] = sheet.getSprite(i);
		}
		walkRight = new Animation(right);
		walkUp = new Animation(up);
		walkLeft = new Animation(left);
		walkDown = new Animation(down);
	}
	private int timer = 0;
	
	@Override
	public void tick() {
		super.tick();
		velX = 0; velY = 0;
		if (Keyboard.isKeyDown(KeyEvent.VK_W)) {
			velY -=.4;
		}
		if (Keyboard.isKeyDown(KeyEvent.VK_S)) {
			velY += .4;
		}
		if (Keyboard.isKeyDown(KeyEvent.VK_A)) {
			velX -=.4;
		}
		if (Keyboard.isKeyDown(KeyEvent.VK_D)) {
			velX += .4;
		}
		if (timer++ == 20) {
			timer = 0;
		if (velX > 0) direction = 2;
		if (velX < 0) direction = 1;
		if (velY > 0) direction = 4;
		if (velY < 0) direction = 3;
		if (velY == 0 && velX == 0) direction = 0;
		
		switch(direction) {
		case 1:  walkLeft.nextFrame(); break;
		case 2: walkRight.nextFrame(); break;
		case 3: walkUp.nextFrame(); break;
		case 4: walkDown.nextFrame(); break;
		}
		}
	}

	@Override
	public void render(Graphics g) {
		switch(direction) {
		case 1:  g.drawImage(walkLeft.getCurrentFrame(), (int)x, (int)y, null); break;
		case 2: g.drawImage(walkRight.getCurrentFrame(), (int)x, (int)y, null); break;
		case 3: g.drawImage(walkUp.getCurrentFrame(), (int)x, (int)y, null); break;
		case 4: g.drawImage(walkDown.getCurrentFrame(), (int)x, (int)y, null); break;
		default: g.drawImage(walkUp.getCurrentFrame(), (int)x, (int)y, null); break;
		}
	}

}
