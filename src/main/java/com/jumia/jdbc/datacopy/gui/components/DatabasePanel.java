package com.jumia.jdbc.datacopy.gui.components;

import com.googlecode.lanterna.gui2.*;
import com.jumia.jdbc.datacopy.gui.components.combos.*;
import com.jumia.jdbc.datacopy.gui.guicontrollers.GuiController;


public class DatabasePanel {

    //panels
    private Panel basePanel;
    private Panel databasePanel;
    private Panel tbPanel;
    private Panel sourceFieldPanel;
    private Panel destinationFieldPanel;
    private GuiController guiController;
    //combos
    private DataCombo dbCombo=null;
    private DataCombo tableCombo=null;
    private DataCombo sourceFieldCombo=null;
    private DataCombo destinationFieldCombo=null;

    public DatabasePanel(){
        guiController=new GuiController();
        basePanel=new Panel();
        databasePanel=new Panel();
        tbPanel=new Panel();
        sourceFieldPanel=new Panel();
        destinationFieldPanel=new Panel();

    }

    public Panel build(){
        basePanel.setLayoutManager(new GridLayout(5));
        databasePanel.setLayoutManager(new LinearLayout(Direction.HORIZONTAL).setSpacing(10));


        dbCombo=new DatabaseCombo();
        databasePanel.addComponent(dbCombo.getComBoBox());

        tableCombo=new TableCombo();
        EventBroadCaster.registerBrodcaster(dbCombo,tableCombo);
        tbPanel.addComponent(tableCombo.getComBoBox());

        sourceFieldCombo=new SourceCombo();
        EventBroadCaster.registerBrodcaster(tableCombo,sourceFieldCombo);
        sourceFieldPanel.addComponent(sourceFieldCombo.getComBoBox());

        destinationFieldCombo=new DestinationCombo();
        EventBroadCaster.registerBrodcaster(sourceFieldCombo,destinationFieldCombo);
        destinationFieldPanel.addComponent(destinationFieldCombo.getComBoBox());


        basePanel.addComponent(databasePanel.withBorder(Borders.singleLine("Select Database")));
        basePanel.addComponent(tbPanel.withBorder(Borders.singleLine("Select table")));
        basePanel.addComponent(sourceFieldPanel.withBorder(Borders.singleLine("Select Source Field")));
        basePanel.addComponent(destinationFieldPanel.withBorder(Borders.singleLine("Select Destination Field")));
       return basePanel;
    }


}
