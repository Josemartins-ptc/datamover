package com.jumia.jdbc.datacopy.gui.components;

import com.googlecode.lanterna.gui2.*;

public class WherePanel {

    private Panel basePanel;


    public WherePanel(){
        basePanel=new Panel();
    }

    public Panel build(){
        basePanel.setLayoutManager(new LinearLayout(Direction.HORIZONTAL).setSpacing(10));
        basePanel.addComponent(new TextBox().withBorder(Borders.singleLine("Where")));
        return basePanel;
    }
}
