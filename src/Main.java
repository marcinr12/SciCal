import com.SciCal.Form;

import java.awt.EventQueue;

public class Main
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
            Form myForm = new Form();
            myForm.setVisible(true);
        });
    }
}
