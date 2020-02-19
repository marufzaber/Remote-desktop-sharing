/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package final1;


import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.*;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Client {

    Socket client=null;


   public void runClient(String ipname)
   {
       Robot robot=null;
       Rectangle rectangle = null;

       try
        {
        System.out.println("Connecting to server ..........");
        client=new Socket(ipname,12345);
        System.out.println("Connection Established.");

        GraphicsEnvironment graphicsEnvironment= GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice graphicsDevice=graphicsEnvironment.getDefaultScreenDevice();

        Dimension dimention=Toolkit.getDefaultToolkit().getScreenSize();

        rectangle = new Rectangle(dimention);

        robot=new Robot(graphicsDevice);

        //drawPanel();

        new ScreenSender(client,robot,rectangle);
        new CommandReceiver(client,robot);

        }
        catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (AWTException ex) {
                ex.printStackTrace();
        }
   }

    private void drawPanel()
    {
        JFrame frame = new JFrame("Remote Admin");
        JButton button= new JButton("Terminate");

        frame.setBounds(100,100,150,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(button);
        button.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }
      );

      frame.setVisible(true);

    }


}

