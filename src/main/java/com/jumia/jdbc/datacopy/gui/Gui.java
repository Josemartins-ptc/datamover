package com.jumia.jdbc.datacopy.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.jumia.jdbc.datacopy.DBCatalogReader;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Data

public class Gui {
    private static Terminal terminal;
    private static Screen screen;
    private static MultiWindowTextGUI multiWindowTextGUI;

    public Gui() throws IOException {
        terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);
        multiWindowTextGUI = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
    }

    public void start() throws IOException {
        screen.startScreen();
    }

    public void initDesign() throws SQLException {
        Panel panel = new Panel();
        panel.setLayoutManager(new GridLayout(2));
        ComboBox<String> comboBox=new ComboBox<String>();
        DBCatalogReader catalogReader=new DBCatalogReader();
        List<String> databaseList= catalogReader.getDatabaseCatalog();
        for (String database : databaseList){
            comboBox.addItem(database);
        }
        panel.addComponent(comboBox);

        // Create window to hold the panel
        BasicWindow window = new BasicWindow();
        window.setComponent(panel);
        multiWindowTextGUI.addWindowAndWait(window);
    }
}
