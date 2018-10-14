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
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        Panel panel = new Panel();
        panel.setLayoutManager(new GridLayout(2));
        List<String> test=new ArrayList<>();
        test.add("aaa");
        test.add("bbb");
        ComboBox<String> comboBox=new ComboBox<>(test);

        ComboBox.Listener listener=new ComboBox.Listener() {
            @Override
            public void onSelectionChanged(int selectedIndex, int previousSelection) {
                System.out.println("Selected Index: " + selectedIndex + ", previous: " + previousSelection);
            }
        };

        comboBox.addListener(listener);
        panel.addComponent(comboBox);

        // Create window to hold the panel
        BasicWindow window = new BasicWindow();
        window.setComponent(panel);
        multiWindowTextGUI.addWindowAndWait(window);

        screen.refresh();

    }
}
