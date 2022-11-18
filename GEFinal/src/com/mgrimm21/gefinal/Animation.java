package com.mgrimm21.gefinal;

import java.awt.image.BufferedImage;

public class Animation {

	private BufferedImage[] frames;
	private int currentFrame = 0;
	private boolean  loop = true;
	
	public Animation(BufferedImage ... frames) {
		this.frames = frames;
	}

	public void nextFrame() {
		if (currentFrame==frames.length-1) {
			if (loop) {
				currentFrame = 0;
			}else return;
		}else currentFrame++;
	}
	
	public void setLoop(boolean loop) {
		this.loop = loop;
	}
	
	public BufferedImage getNextFrame() {
		nextFrame();
		return frames[currentFrame];
	}
	
	public void setFrame(int frame) {
		if (frame > frames.length-1) return;
		currentFrame = frame;
	}
	
	public void reset() {
		currentFrame = 0;
	}
	
	public BufferedImage getCurrentFrame() {
		return frames[currentFrame];
	}
	
}
