/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package final1;



import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.*;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.beans.PropertyVetoException;

public class Server
{
    private ObjectOutputStream output;
    private ServerSocket server;
    private Socket connection;
    private Rectangle clientScreenDim = null;
    private ObjectInputStream ois = null;

     private JFrame frame = new JFrame();
     private JDesktopPane desktop = new JDesktopPane();

     private JInternalFrame interFrame = new JInternalFrame("Client Screen",true, true, true);
     private JPanel cPanel = new JPanel();
     private JOptionPane ob=new JOptionPane();

    public void runServer()
    {
        try {
            int a;
           server =new ServerSocket(12345,100);

          drawGUI();

            while(true)
            {

                connection = server.accept();
                 a=ob.showConfirmDialog(frame,"A Client Wants to Connect with you. Want to accept?");
                if(a==0)
                {
                   System.out.println("New client Connected to the server");
                    new ControlClient(connection,desktop);
                }
             else
                {
                    server.close();
                }
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    public void drawGUI(){
            frame.add(desktop,BorderLayout.CENTER);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
    }

}
