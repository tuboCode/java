package com.cs.cn;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MySwingWindow extends JFrame{
	
	private static final long serialVersionUid = 8978037719568897634L;
	
	private JLabel myLabel;
	private JTextField myTextField;
	private JButton myButton;
	
	public MySwingWindow(){
		super ();
		
		this.getContentPane().setLayout(null);
		
		this.setTitle("my first Swing Window");
		
		this.add(getJLabel(),null);
		this.add(getJTextField(), null);
		this.add(getJButton(),null);
	}
	
	private JLabel getJLabel(){
		if(myLabel == null){
			myLabel = new JLabel();
			
			myLabel.setBounds(5,10,250,30);
			myLabel.setText("Hello Welcome ");
			
		}
		return myLabel;
	}
	
	private JTextField getJTextField(){
		if(myTextField == null){
			myTextField  = new JTextField();
			
			myTextField.setBounds(5, 45, 200,30);
			
			myTextField.setText("chengshun");
		}
		return myTextField;
	}
	
	private JButton getJButton(){
		if(myButton == null){
			myButton = new JButton();
			myButton.setBounds(5, 80,100,40);
			myButton.setText("click me");
			myButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					myLabel.setForeground(Color.RED);
					myTextField.setBackground(Color.BLUE);
				}
			});	
		}	
		return myButton;
	}
	
	public static void main(String[] args){
		MySwingWindow window = new MySwingWindow();
		window.setVisible(true);
	}
}
