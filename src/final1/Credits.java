package final1; 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Credits extends JFrame implements ActionListener
{
	private MyPanel centerPanel;
	private JPanel northPanel;
	private JButton tbutton, abutton;
	
	public Credits()
	{
		super("CREDIT");
		
		Container content = this.getContentPane();
		
		this.northPanel = new JPanel();
		this.northPanel.setLayout(new GridLayout(1, 2));
		
		this.tbutton = new JButton("MARUF ZABER");
		//this.tbutton.addActionListener(this);
		
		this.abutton = new JButton("MD HABIBULLAH BIN ISMAIL");
		//this.abutton.addActionListener(this);
		
		this.northPanel.add(tbutton);
		this.northPanel.add(abutton);
		
		this.centerPanel = new MyPanel();
		
		content.add(this.northPanel, BorderLayout.NORTH);
		content.add(this.centerPanel);
		
		this.setFocusable(true);
		this.setLocation(150,150);
		this.setSize(750, 650);
		this.setResizable(false);
		this.setVisible(true);
		//tbutton.disable();
		//abutton.disable();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == this.tbutton)
		{
			JFrame frame=new JFrame("MARUF ZABER");
			frame.setSize(640,480);
			frame.setVisible(true);
			frame.setFocusable(true);
			frame.setResizable(true);
			frame.setLocation(100,100);
			
			Container c=new Container();
			MyPicPanel panel=new MyPicPanel("crest.gif");
			frame.getContentPane().add(panel);
		}
		else if(e.getSource() == this.abutton)
		{
			JFrame frame=new JFrame("MD HABIBULLAH BIN ISMAIL");
			frame.setSize(640,480);
			frame.setVisible(true);
			frame.setFocusable(true);
			frame.setLocation(500,100);
			frame.setResizable(true);
			
			MyPicPanel panel=new MyPicPanel("crest.gif");
			frame.getContentPane().add (panel);
		}
		
	}
}