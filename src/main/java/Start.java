import com.jumia.jdbc.datacopy.gui.Gui;

import java.io.IOException;
import java.sql.SQLException;

public class Start {
    public static void main(String[] args) throws IOException, SQLException {

        Gui gui=new Gui();
        gui.start();
        gui.initDesign();

    }
}
