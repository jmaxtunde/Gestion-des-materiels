
package sgme.carder;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 *
 * @author Senghor AKOMINON
 */
public class MyTextField extends JTextField implements FocusListener
{
      
    public MyTextField()
    {
        this.setFocusable(true);
        this.setText(null);
    }
    
    @Override
    public void focusGained(FocusEvent e) {
         this.setText(null);
    }

    @Override
    public void focusLost(FocusEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
