package com.jumia.jdbc.datacopy.gui.components;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import com.jumia.jdbc.datacopy.gui.WhereTextBox;
import com.jumia.jdbc.datacopy.gui.components.buttons.QueryBuilderButton;
import com.jumia.jdbc.datacopy.gui.components.combos.*;
import com.jumia.jdbc.datacopy.gui.guicontrollers.GuiController;
import jdk.nashorn.internal.objects.annotations.Where;

import javax.xml.soap.Text;


public class DatabasePanel {

    //panels
    private Panel backgroundPanel;
    private Panel basePanel;
    private Panel databasePanel;
    private Panel tbPanel;
    private Panel sourceFieldPanel;
    private Panel destinationFieldPanel;
    private Panel queryBuildButtonPanel;
    private Panel wherePanel;
    private GuiController guiController;
    //combos
    private DataCombo dbCombo=null;
    private DataCombo tableCombo=null;
    private DataCombo sourceFieldCombo=null;
    private DataCombo destinationFieldCombo=null;
    private QueryBuilderButton queryBuilderButton=null;
    private WhereTextBox whereTextBox=null;

    public DatabasePanel(){
        guiController=new GuiController();
        backgroundPanel=new Panel();
        basePanel=new Panel();
        databasePanel=new Panel();
        tbPanel=new Panel();
        sourceFieldPanel=new Panel();
        destinationFieldPanel=new Panel();
        queryBuildButtonPanel=new Panel();
        wherePanel=new Panel();


    }

    public Panel build(){
        backgroundPanel.setLayoutManager(new GridLayout(1));
        basePanel.setLayoutManager(new GridLayout(4));
        databasePanel.setLayoutManager(new LinearLayout(Direction.HORIZONTAL));
        wherePanel.setLayoutManager((new LinearLayout((Direction.HORIZONTAL)).setSpacing(10)));


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

        queryBuilderButton = new QueryBuilderButton();
        queryBuildButtonPanel.addComponent(queryBuilderButton.getQueryBuilderButton());

        WhereTextBox whereTextBox=new WhereTextBox();
        wherePanel.addComponent(whereTextBox.getTextBox());


        basePanel.addComponent(databasePanel.withBorder(Borders.singleLine("Select Database")));
        basePanel.addComponent(tbPanel.withBorder(Borders.singleLine("Select table")));
        basePanel.addComponent(sourceFieldPanel.withBorder(Borders.singleLine("Select Source Field")));
        basePanel.addComponent(destinationFieldPanel.withBorder(Borders.singleLine("Select Destination Field")));
       // basePanel.addComponent(queryBuildButtonPanel);
        backgroundPanel.addComponent(basePanel);
        backgroundPanel.addComponent(wherePanel);
        backgroundPanel.addComponent(queryBuildButtonPanel);
        return backgroundPanel;
    }


}
