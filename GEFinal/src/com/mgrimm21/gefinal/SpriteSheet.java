package com.mgrimm21.gefinal;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	private BufferedImage image;
	private BufferedImage[][] sprites;
	
	public SpriteSheet(String fileName, int spriteWidth, int spriteHeight) {
		File file = new File(fileName);
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sprites = new BufferedImage[image.getWidth()/spriteWidth][image.getHeight()/spriteHeight];
	}
	
	public BufferedImage getSprite(int x, int y) {
		return sprites[x][y];
	}
	
}
