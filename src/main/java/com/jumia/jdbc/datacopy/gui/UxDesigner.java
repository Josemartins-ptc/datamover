package com.jumia.jdbc.datacopy.gui;

import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@Data
public class UxDesigner {

   public void design(){
       Panel panel = new Panel();
       panel.setLayoutManager(new GridLayout(2));

       panel.addComponent(new Label("Forename"));
       panel.addComponent(new TextBox());
   }


}
