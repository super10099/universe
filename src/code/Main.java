package code;

import java.util.Scanner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import java.util.ArrayList;
import java.text.NumberFormat;


public class Main extends JFrame{
	
	private static final String TITLE = "SHOOP";
	private static final int WIDTH = 400;
	private static final int HEIGHT = 240;
	
	private NumberFormat nf;
	
	private JTextArea mainFrame;
	private JTextField cmdln;
	private JScrollPane mainScroll;
	private JLabel cart;
	
	private ArrayList<Item> items;
	
	public Main() {
		super(TITLE);
		
		//jcomponents
		JPanel jpanel = new JPanel(new BorderLayout());
		mainFrame = new JTextArea();
		mainFrame.setEditable(false);
		mainScroll = new JScrollPane(mainFrame);
		jpanel.add(mainScroll, BorderLayout.CENTER);
		
		cmdln = new JTextField();
		cmdln.setText("Input here");
		cmdln.addFocusListener(new cmdlnFocusListener());
		cmdln.setForeground(Color.LIGHT_GRAY);
		jpanel.add(cmdln, BorderLayout.SOUTH);
		
		cart = new JLabel(String.format("Payment: $%.2f", 0.00));
		cart.setPreferredSize(new Dimension(0, 20));
		jpanel.add(cart, BorderLayout.NORTH);
		
		
		add(jpanel);
		setResizable(false);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//init
		init();
	}
	
	public void init() {
		//add menu items
		items = new ArrayList<Item>();
		items.add(new Item("Cookie", 5.00));
		items.add(new Item("Cookie", 5.00));
		items.add(new Item("Cookie", 5.00));
		items.add(new Item("Cookie", 5.00));
		items.add(new Item("Cookie", 5.00));
		items.add(new Item("Cookie", 5.00));
		
		//iterate through and display
		nf = NumberFormat.getCurrencyInstance();
		for(Item s:items) {
			mainFrame.append(String.format("Item: [%s] price: [%s]\n",s.name , nf.format(s.cost)));
		}
		
	}
	
	private class cmdlnFocusListener implements FocusListener {

		@Override
		public void focusGained(FocusEvent arg0) {
			cmdln.setText("");
			cmdln.setForeground(Color.BLACK);
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			cmdln.setText("Input here");
			cmdln.setForeground(Color.LIGHT_GRAY);
		}

		
	}
	
	private class Item {
		
		private String name;
		private double cost;
		
		public Item(String name, double cost) {
			this.name = name;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
