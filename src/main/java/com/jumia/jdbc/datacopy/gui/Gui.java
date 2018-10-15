package com.jumia.jdbc.datacopy.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.jumia.jdbc.datacopy.gui.components.DatabasePanel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Data
@Slf4j
public class Gui {
    private static Terminal terminal;
    private static Screen screen;
    private static MultiWindowTextGUI multiWindowTextGUI;

    public Gui() throws IOException {
        this.terminal = new DefaultTerminalFactory().createTerminal();
        this.screen = new TerminalScreen(terminal);
        this.multiWindowTextGUI = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
    }

    public void start() throws IOException {
        screen.startScreen();
    }

    public void design() throws IOException{
        DatabasePanel panel=new DatabasePanel();
        // Create window to hold the panel
        BasicWindow window = new BasicWindow();
        window.setComponent(panel.build());
        multiWindowTextGUI.addWindowAndWait(window);

        screen.refresh();

    }
}
