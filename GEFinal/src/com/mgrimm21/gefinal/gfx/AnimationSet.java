package com.mgrimm21.gefinal.gfx;

import java.awt.image.BufferedImage;

public class AnimationSet {

	private Animation[] animations = new Animation[4];
	private BufferedImage idle;
	
	
	/**
	 * 
	 * @param idleImage the image to show when animation is not running
	 * @param animations insert in order up down left right
	 */
	public AnimationSet(BufferedImage idleImage, Animation ... animations) {
		this.idle = idleImage;
		this.animations = animations;
	}
	
	
	
}
