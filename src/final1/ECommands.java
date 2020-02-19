/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package final1;


public enum ECommands {
    MOUSE_PRESS(-1),
    MOUSE_RELEASE(-2),
    KEY_PRESS(-3),
    KEY_RELEASE(-4),
    MOUSE_MOVE(-5),
    MOUSE_WHEELMOVE(-6);;

    private int let;

    ECommands(int let){
        this.let = let;
    }

   public int getlet(){
        return let;
    }
}
