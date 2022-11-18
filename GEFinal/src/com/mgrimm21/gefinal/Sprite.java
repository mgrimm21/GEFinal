package com.mgrimm21.gefinal;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {

	private int width, height;
	private BufferedImage image;
	
	public Sprite(String file, int width, int height) {
		this.width = width;
		this.height = height;
		try {
			image = ImageIO.read(new File("res/sprites/" + file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Sprite(String file) {
		try {
			image = ImageIO.read(new File("res/sprites/" + file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		width = image.getWidth();
		height = image.getHeight();
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(image, x, y, width, height, null);
	}
	
	public void render(Graphics g, float x, float y) {
		g.drawImage(image, (int)x, (int)y, width, height, null);
	}
	
}
