package com.jumia.jdbc.datacopy.gui.components.combos;

import com.googlecode.lanterna.gui2.ComboBox;
import com.jumia.jdbc.datacopy.gui.guicontrollers.GuiController;

import java.util.List;


public interface DataCombo {
    GuiController guiController=new GuiController();
    String getItem();
    List<String> getBagOfItens();
    ComboBox<String> getComBoBox();
    ComboBox<String> addListener(ComboBox.Listener listener);
    void OnDataComboEvent();


}
