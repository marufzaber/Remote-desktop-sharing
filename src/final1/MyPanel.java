package final1;

import java.awt.*;
import javax.swing.*;

public class MyPanel extends JPanel
{ 
	private String displayString[] = {"                       REMOTE DEKSTOP SHEARING\n","","This software is developed as a Level-2 & Term-1 project by\n","","    MARUF HASAN ZABER\n","\n    St.ID: 0905009\n","    Department of CSE,BUET\n","\n    Email: maruf.zaber.09@gmail.com\n","","    &\n","","\n    MD HABIBULLAH BIN ISMAIL\n","\n    St.ID: 0905049\n","    Department of CSE,BUET\n","\n    Email: bahar61119@yahoo.com\n"," ","This project is well guided by\n","","    SUKARNA BARUA\n","    Lecturer\n","    Department of CSE,BUET\n","    Email: sukarna_barua@yahoo.com\n"," ","","","Version 1.0.0.1"};
		
	private int strX, strY;
	private Font font;
	
	public MyPanel()
	{
		this.font = new Font("TIMES NEW ROMAN", Font.BOLD, 25);
		this.strX = 50;
		this.strY = 50;		
	}

	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setFont(this.font);
		for(int i=1;i<=displayString.length;i++)
		{
			g.drawString(this.displayString[i-1], this.strX, this.strY+(20*i) );
		}	
	}
}
