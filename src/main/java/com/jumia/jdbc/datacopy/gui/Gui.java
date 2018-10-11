package com.jumia.jdbc.datacopy.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.IOException;

@Data

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

    public void design(){
        Panel panel = new Panel();
        panel.setLayoutManager(new GridLayout(2));
        ComboBox<String> comboBox=new ComboBox<String>();
        comboBox.addItem("item 1");
        comboBox.addItem("itemmmmmmmmmmmmmmmmmmm 2");
        comboBox.addItem("item 3");
        panel.addComponent(comboBox);

        // Create window to hold the panel
        BasicWindow window = new BasicWindow();
        window.setComponent(panel);
        multiWindowTextGUI.addWindowAndWait(window);
    }
}
