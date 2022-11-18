package com.mgrimm21.gefinal;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	private BufferedImage image;
	private BufferedImage[] sprites;
	
	public SpriteSheet(String fileName, int spriteWidth, int spriteHeight) {
		File file = new File("res/sprites/sheets/" + fileName);
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int width = image.getWidth()/spriteWidth;
		int height = image.getHeight()/spriteHeight;
		sprites = new BufferedImage[width*height];
		int i = 0;
		for (int x = 0; x < image.getWidth(); x+= spriteWidth) {
			for (int y = 0; y < image.getHeight(); y += spriteHeight) {
				sprites[i++] = image.getSubimage(x, y, spriteWidth, spriteHeight);
			}
		}
	}
	
	public BufferedImage getSprite(int i) {
		return sprites[i];
	}
	
}
