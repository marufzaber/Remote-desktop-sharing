package final1;

import java.awt.*;
import javax.swing.*;

public class MyPicPanel extends JPanel
{ 
		
	private Image image;
	private int w,h;
	private String picString;
	
	public MyPicPanel(String str)
	{
		picString=str;
		this.setBackground (Color.cyan);
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
   		Toolkit tk=	Toolkit.getDefaultToolkit();
   		Image image=tk.getImage(picString);
   		h=this.getHeight();
   		w=this.getWidth();	
   		g.drawImage(image,0,0,w,h,this);
   		
   		
	}
}
