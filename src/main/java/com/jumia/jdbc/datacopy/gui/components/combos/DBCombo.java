package com.jumia.jdbc.datacopy.gui.components.combos;

import com.googlecode.lanterna.gui2.ComboBox;
import lombok.Data;

import java.util.List;

@Data
public class DBCombo extends EventBroadCaster implements DataCombo,EventObserver {

    private DataCombo _self;
    private ComboBox<String> comboBox;
    private List<String> bagOfItens = guiController.getDatabases();
    private int currentlySelectedItem=0;

    public DBCombo(EventObserver obs){
        super(obs);
        this.comboBox=new ComboBox<>(bagOfItens);
        this.comboBox.addListener(listener);
        _self=this;
    }

    private ComboBox.Listener listener=new ComboBox.Listener(){
        @Override
        public void onSelectionChanged(int selectedIndex, int previousSelection) {
            //TODO Refactor
            System.out.println("Selected Index: " + selectedIndex + ", previous: " + previousSelection);
            System.out.println(comboBox.getItem(selectedIndex));
            currentlySelectedItem=selectedIndex;
            OnEvent(_self);
        }
    };


    @Override
    public String getItem() {
        return comboBox.getItem(currentlySelectedItem);
    }

    @Override
    public ComboBox<String> getComBoBox() {
        return this.comboBox;
    }

    @Override
    public ComboBox<String> addListener(ComboBox.Listener listener) {
        return null;
    }

    @Override
    public List<String> getBagOfItens() {
        return bagOfItens;
    }


    @Override
    public void OnEvent(DataCombo dc) {
        notifyObservers(dc);

    }

    @Override
    public void OnDataComboEvent() {

    }
}
