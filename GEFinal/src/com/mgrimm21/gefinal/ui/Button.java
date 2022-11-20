package com.mgrimm21.gefinal.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

import com.mgrimm21.gefinal.io.Mouse;

public abstract class Button extends UIElement{

	private int width, height;
	private Color color, colorHover, colorClicked;
	private BufferedImage image, imageHover, imageClicked;
	private boolean hover = false, clicked = false;
	private String text = "";
	public Button(int x, int y, int width, int height, Color color, Color colorHover, Color colorClicked, String text) {
		super(x, y);
		this.width = width;
		this.height = height;
		this.color = color;
		this.colorHover = colorHover;
		this.colorClicked = colorClicked;
		this.text = text;
	}
	
	public Button(int x, int y, BufferedImage image, String text) {
		super(x, y);
		this.image = image;
		width = image.getWidth();
		height = image.getHeight();
		float scaleFactor = 1.3f;
	    RescaleOp op = new RescaleOp(scaleFactor, 0, null);
	    imageHover = op.filter(image, null);
	    scaleFactor = .7f;
	    RescaleOp op2 = new RescaleOp(scaleFactor, 0, null);
	    imageClicked = op2.filter(image, null); 
	    this.text = text;
	}
	
	public Button(int x, int y, BufferedImage image, BufferedImage imageHover, BufferedImage imageClicked, String text) {
		super(x, y);
		this.image = image;
		this.imageHover = imageHover;
		this.imageClicked = imageClicked;
		width = image.getWidth();
		height = image.getHeight();
		this.text = text;
	}
	
	public abstract void onClick();

	@Override
	public void tick() {
		if (Mouse.mouseX >= x && Mouse.mouseX <= (x + width)) {
			if (Mouse.mouseY >= y && Mouse.mouseY <= (y + height)) {
				hover = true;
			}else {
				hover = false;
				clicked = false;
			}
		} else hover = false;
		if (hover && Mouse.isDown(MouseEvent.BUTTON1)) {
			clicked = true;
		}else {
			if (hover && clicked) {
				clicked = false;
				onClick();
			}
		}
	}

	@Override
	public void render(Graphics g) {
		if (image == null) {
			if (!clicked&&!hover) {
				g.setColor(color);
				g.fillRect(x, y, width, height);
			}else if (hover && !clicked) {
				g.setColor(colorHover);
				g.fillRect(x, y, width, height);
			}else {
				g.setColor(colorClicked);
				g.fillRect(x, y, width, height);
			}
			g.setColor(Color.white);
			g.drawString(text, x + (width/2), y + (height/2));
		}else {
			if (!clicked&&!hover) {
				g.drawImage(image, x, y, null);
			}else if (hover && !clicked) {
				g.drawImage(imageHover, x, y, null);
			}else {
				g.drawImage(imageClicked, x, y, null);
			}
		}
	}
}
