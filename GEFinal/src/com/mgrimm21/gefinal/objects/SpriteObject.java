package com.mgrimm21.gefinal.objects;

import java.awt.Graphics;

import com.mgrimm21.gefinal.gfx.Sprite;

public class SpriteObject extends GameObject{

	private Sprite sprite;
	
	public SpriteObject(Sprite sprite, float x, float y) {
		super(x, y);
		this.sprite = sprite;
	}
	
	public SpriteObject(String file, float x, float y) {
		super(x, y);
		this.sprite = new Sprite(file);
	}
	
	public SpriteObject(String file, float x, float y, int width, int height) {
		super(x, y);
		this.sprite = new Sprite(file, width, height);
	}

	@Override
	public void render(Graphics g) {
		sprite.render(g, x, y);
	}

}
