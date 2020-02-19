/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package final1;

import javax.swing.JOptionPane;


public class ImageShow extends Thread {
    
    String msg;
    public ImageShow(String msg)
    {
        this.msg=msg;
       
    }
    @Override
    public void run()
    {
        if("credits".equals(msg)) {
            Credits image =new Credits();
          }
        else 
        {
            JOptionPane.showMessageDialog(null,"\nHelp: \n\n\nWith this software U can control a pc remotely\nif u want to be the "+
                        	"controller then just start as server in menu and then pc will wait for client now\n"+
                        		"the pc u will control should be connected through lan and have this software\n"+
                        			"then the client pc should start this software and run as client in menu....\n"+
                        				"then the client should give the ip address or pc name of the server pc \n"+
                        					"then two pc will be connected and the server pc will control the client pc and see the desktop of the client\n\n\n\n"+
                        						"***U can test this software within ur pc only...do the Above process and run this software again to be the client\n\n"+
                        							"then do the same process to connect and give ur pc name or write \"localhost\" \n\n\n"+
                        								"for more Information feel free to contact :\n\n"+
                        									"maruf.zaber.09@gmail.com\nbahar61119@yahoo.com\n\nThanks",
                        "Help", JOptionPane.INFORMATION_MESSAGE);
        }
        }
    }
    

