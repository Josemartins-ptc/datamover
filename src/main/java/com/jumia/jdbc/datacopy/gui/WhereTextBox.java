package com.jumia.jdbc.datacopy.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.Borders;
import com.googlecode.lanterna.gui2.TextBox;
import lombok.Data;

import java.util.UUID;

@Data
public class WhereTextBox {

    private final UUID uuid;
    private TextBox textBox;

    public WhereTextBox(){
        uuid=UUID.randomUUID();
        textBox=new TextBox(new TerminalSize(70,1));
        textBox.withBorder(Borders.singleLine("WHERE CLAUSE"));

    }

    private String getWhereClause(){
        return textBox.getText();
    }
}
