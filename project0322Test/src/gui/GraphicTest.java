package gui;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GraphicTest extends JFrame{
	
	JLabel lb_path;
	JPanel  p_north, p_south;
	Canvas  can;
	JButton  bt_prev, bt_next;
	Toolkit    kit;
	Image    img;
	int count;
	String[] path = {
		 "C:/html_workspace/images/p1.jpg"
		,"C:/html_workspace/images/p2.jpg"
		,"C:/html_workspace/images/p3.jpg"
		,"C:/html_workspace/images/p4.jpg"
	};
	
	public GraphicTest() {
		lb_path = new JLabel();
		can = new Canvas();
		bt_prev = new JButton("prev");
		bt_next = new JButton("next");
		p_north = new JPanel();
		p_south = new JPanel();
		
		kit = kit.getDefaultToolkit();
		img = kit.getImage(path[count]);
		lb_path.setText(path[count]);
		
		// north
		p_north.add(lb_path);
		
		// center
		can = new Canvas(){
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		
		bt_prev.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				prev();				
			}
		});
		
		bt_next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				next();
			}
		});
		
		
		// south
		p_south.add(bt_prev);
		p_south.add(bt_next);
		
		add(p_north, BorderLayout.NORTH);
		add(can, BorderLayout.CENTER);
		add(p_south, BorderLayout.SOUTH);
		
		setBounds(100, 100, 600, 650);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void prev(){
		System.out.println("prev : count = "+Integer.toString(count));
		if (count > 0) {
			count--;
			img = kit.getImage(path[count]);
			can.repaint();
		}
			
	}
	
	public void next(){
		System.out.println("next : count = "+Integer.toString(count));
		if (count < path.length-1) {
			count++;
			img = kit.getImage(path[count]);
			can.repaint();
		}
	}
	
	public static void main(String[] args){
		new GraphicTest();
	}

}
