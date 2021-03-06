package com.ss.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonCreater extends JFrame {
	
	JButton  bt_create, bt_color;
	JPanel     p_north, p_center;
	int         count=0;
	ArrayList list = new ArrayList();
	
	public ButtonCreater() {
		
		bt_create = new JButton("버튼 생성");
		bt_color   = new JButton("색상 변경");
		
		p_north = new JPanel();
		p_north.add(bt_create);
		p_north.add(bt_color);
		
		p_center = new JPanel();
		
		// 버튼 생성 
		bt_create.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				createButton();
				
			}
		});
		
		// 색상 변경 버튼
		bt_color.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				setColor();
			}
		});
		
		add(p_north, BorderLayout.NORTH);
		add(p_center, BorderLayout.CENTER);
		
		setVisible(true);
		setSize(500, 600);
	}
	
	public void createButton(){
		count++;
		JButton bt = new JButton(Integer.toString(count));
		list.add(bt);
		p_center.add(bt);
		p_center.updateUI();
	}
	
	public void setColor(){
		for (int i=0; i<list.size(); i++) {
			JButton bt=(JButton)list.get(i);
			bt.setBackground(Color.YELLOW);
		}
	}

	public static void main(String[] args) {
		new ButtonCreater();

	}

}
