
package final1;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

public class Final1App extends SingleFrameApplication {


    @Override protected void startup() {
        show(new Final1View(this));
    }

    @Override protected void configureWindow(java.awt.Window root) {
    }

    public static Final1App getApplication() {
        return Application.getInstance(Final1App.class);
    }

    public static void main(String[] args)
    {
        launch(Final1App.class, args);
    }
}
