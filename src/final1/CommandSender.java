/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
 
package final1;


import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JPanel;

class CommandSender implements KeyListener,MouseMotionListener,MouseListener,MouseWheelListener {

    private Socket cSocket = null;
    private JPanel cPanel = null;
    private PrintWriter writer = null;
    private Rectangle clientScreenDim = null;

    CommandSender(Socket s, JPanel p, Rectangle r) {
        cSocket = s;
        cPanel = p;
        clientScreenDim = r;
        //Associate event listners to the panel
        cPanel.setFocusable(true);
        cPanel.requestFocusInWindow();
        cPanel.addKeyListener(this);
        cPanel.addMouseListener(this);
        cPanel.addMouseMotionListener(this);
        cPanel.addMouseWheelListener(this);
        try {
             //Prepare PrintWriter which will be used to send commands to
             //the client
            writer = new PrintWriter(cSocket.getOutputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

   
   public void mouseDragged(MouseEvent e)
    {
         writer.println(ECommands.MOUSE_MOVE.getlet());
    	 double xScale = clientScreenDim.getWidth()/cPanel.getWidth();
    	 double yScale = clientScreenDim.getHeight()/cPanel.getHeight();
    	 writer.println((int)(e.getX() * xScale));
         writer.println((int)(e.getY() * yScale));
    	 writer.flush();
    }

    public void mouseMoved(MouseEvent e) {
        double xScale = clientScreenDim.getWidth()/cPanel.getWidth();
        System.out.println("xScale: " + xScale);
        double yScale = clientScreenDim.getHeight()/cPanel.getHeight();
        System.out.println("yScale: " + yScale);
        System.out.println("Mouse Moved");
        writer.println(ECommands.MOUSE_MOVE.getlet());
        writer.println((int)(e.getX() * xScale));
        writer.println((int)(e.getY() * yScale));
        writer.flush();
    }

    //this is not implemented
    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse Pressed");
        writer.println(ECommands.MOUSE_PRESS.getlet());
        int button = e.getButton();
        int xButton = 16;
        if(button==2)
        {
            xButton=8;
        }
        if (button == 3) {
            xButton = 4;
        }
        writer.println(xButton);
        writer.flush();
    }

    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse Released");
        writer.println(ECommands.MOUSE_RELEASE.getlet());
        int button = e.getButton();
        int xButton = 16;
        if(button==2)
        {
            xButton=8;
        }
        if (button == 3) {
            xButton = 4;
        }
        writer.println(xButton);
        writer.flush();
    }

    //not implemented
    public void mouseEntered(MouseEvent e) {
    }
    //not implemented
    public void mouseExited(MouseEvent e) {

    }

   public void mouseWheelMoved(MouseWheelEvent e){
       writer.println(ECommands.MOUSE_WHEELMOVE.getlet());

       int wh=e.getWheelRotation();
       writer.println(wh);
       writer.flush();


   }


    //not implemented
    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        System.out.println("Key Pressed");
       writer.println(ECommands.KEY_PRESS.getlet());
        writer.println(e.getKeyCode());
        writer.flush();
    }

    public void keyReleased(KeyEvent e) {
        System.out.println("Mouse Released");
        writer.println(ECommands.KEY_RELEASE.getlet());
        writer.println(e.getKeyCode());
        writer.flush();
    }

}


