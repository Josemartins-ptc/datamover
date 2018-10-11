import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.jumia.jdbc.datacopy.gui.Gui;
import com.jumia.jdbc.datacopy.gui.UxDesigner;

import java.io.IOException;

public class Start {
    public static void main(String[] args) throws IOException {

        Gui gui=new Gui();
        gui.start();
        gui.design();

    }
}
