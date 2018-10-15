package com.jumia.jdbc.datacopy.gui.components;

import com.googlecode.lanterna.gui2.*;
import com.jumia.jdbc.datacopy.gui.components.combos.DBCombo;
import com.jumia.jdbc.datacopy.gui.components.combos.DataCombo;
import com.jumia.jdbc.datacopy.gui.components.combos.TableCombo;
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
    private ComboBox<String> sourceFieldCombo=null;
    private ComboBox<String> destinationFieldCombo=null;

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

        tableCombo=new TableCombo();
        dbCombo=new DBCombo(tableCombo);
        databasePanel.addComponent(dbCombo.getComBoBox());


        tbPanel.addComponent(tableCombo.getComBoBox());

        sourceFieldCombo=new ComboBox<String>("g","h","j");
        sourceFieldPanel.addComponent(sourceFieldCombo);

        destinationFieldCombo=new ComboBox<String>("k","l","m");
        destinationFieldPanel.addComponent(destinationFieldCombo);


        basePanel.addComponent(databasePanel.withBorder(Borders.singleLine("Select Database")));
        basePanel.addComponent(tbPanel.withBorder(Borders.singleLine("Select table")));
        basePanel.addComponent(sourceFieldPanel.withBorder(Borders.singleLine("Select Source Field")));
        basePanel.addComponent(destinationFieldPanel.withBorder(Borders.singleLine("Select Destination Field")));
       return basePanel;
    }


}
