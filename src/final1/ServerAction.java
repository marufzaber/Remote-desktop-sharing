/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package final1;


public class ServerAction extends Thread{

    public void run()
    {
         Server application =new Server();
        application.runServer();
    }

}
