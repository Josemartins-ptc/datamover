package com.jumia.jdbc.datacopy.gui.components.combos;



import com.googlecode.lanterna.gui2.ComboBox;

import java.util.List;

public class TableCombo extends EventBroadCaster implements DataCombo,EventObserver {

    private ComboBox<String> comboBox;
    private List<String> bagOfItens;
    private int currentlySelectedItem=0;

    public TableCombo(){
        this.bagOfItens=guiController.getTables("");
        this.comboBox=new ComboBox<>(bagOfItens);
        this.comboBox.addListener(listener);
    }

    private ComboBox.Listener listener=new ComboBox.Listener(){
        @Override
        public void onSelectionChanged(int selectedIndex, int previousSelection) {
            System.out.println("Selected Index: " + selectedIndex + ", previous: " + previousSelection);
            System.out.println(comboBox.getItem(selectedIndex));
            currentlySelectedItem=selectedIndex;
            //Interested inform
        }
    };

    @Override
    public String getItem() {
        return comboBox.getItem(currentlySelectedItem);
    }

    @Override
    public ComboBox<String> addListener(ComboBox.Listener listener) {
        return this.comboBox;
    }

    @Override
    public void OnDataComboEvent() {
       ;
    }

    @Override
    public ComboBox<String> getComBoBox() {
        return this.comboBox;
    }

    @Override
    public List<String> getBagOfItens() {
        return this.bagOfItens;
    }


    @Override
    public void OnEvent(DataCombo dc) {
        notifyObservers(dc);
    }
}
