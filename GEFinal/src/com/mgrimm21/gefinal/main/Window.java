package com.mgrimm21.gefinal.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.mgrimm21.gefinal.io.Keyboard;
import com.mgrimm21.gefinal.io.Mouse;

public class Window {

	private Dimension size;
	private JFrame frame;
	protected Canvas canvas;
	protected BufferStrategy bs;
	
	public Window(String name, int width, int height) {
		this.size = new Dimension(width, height);
		frame = new JFrame();
		canvas = new Canvas();
		frame.setMinimumSize(size);
		frame.setMaximumSize(size);
		frame.setPreferredSize(size);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.add(canvas);
		frame.setName(name);
		frame.setTitle(name);
		canvas.addKeyListener(new Keyboard());
		canvas.addMouseListener(new Mouse());
		canvas.setName("background");
		frame.setVisible(true);
		canvas.createBufferStrategy(3);
		bs = canvas.getBufferStrategy();
		canvas.requestFocus();
	}
	
}
