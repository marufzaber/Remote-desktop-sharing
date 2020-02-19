/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package final1;


import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class ControlClient extends Thread{
    private JDesktopPane desktop = null;
    private Socket cSocket = null;
    private JInternalFrame interFrame = new JInternalFrame("Client Screen",
                                                            true, true, true);
    private JPanel cPanel = new JPanel();

    public ControlClient(Socket cSocket, JDesktopPane desktop) {
        this.cSocket = cSocket;
        this.desktop = desktop;
        start();
    }

     public void drawFrame(){
        interFrame.setLayout(new BorderLayout());
        interFrame.getContentPane().add(cPanel,BorderLayout.CENTER);
        interFrame.setSize(100,100);
        desktop.add(interFrame);
        try {
            interFrame.setMaximum(true);
        } catch (PropertyVetoException ex) {
            ex.printStackTrace();
        }

        cPanel.setFocusable(true);
        interFrame.setVisible(true);
    }

    public void run()
    {
        Rectangle clientScreenDim = null;
        ObjectInputStream ois = null;
        drawFrame();

        try{
            //Read client screen dimension
            ois = new ObjectInputStream(cSocket.getInputStream());
            clientScreenDim =(Rectangle) ois.readObject();
        }catch(IOException ex){
            ex.printStackTrace();
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }

        new ScreenReceiver(ois,cPanel);
        new CommandSender(cSocket,cPanel,clientScreenDim);
    }

}
