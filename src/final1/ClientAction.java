/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package final1;
import java.util.*;
import javax.swing.*;
import java.lang.*;


public class ClientAction extends Thread {
    String name;

    public void run()
    {
         JOptionPane input=new JOptionPane();
        name=input.showInputDialog("INPUT SERVER'S  IP");
        Client application=new Client();
        application.runClient(name);
    }


}
