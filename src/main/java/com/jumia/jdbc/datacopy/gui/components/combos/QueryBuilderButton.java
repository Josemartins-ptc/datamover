package com.jumia.jdbc.datacopy.gui.components.combos;


import java.util.UUID;

import com.googlecode.lanterna.gui2.Button;
import com.jumia.jdbc.datacopy.gui.guicontrollers.GuiController;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author josemartins 2018-10-17
 */
@Slf4j
@Data
public class QueryBuilderButton {

	private final UUID uuid;
	private final GuiController guiController=new GuiController();
	private final Button queryBuilderButton;

	public QueryBuilderButton() {
		queryBuilderButton=new Button("Build Query");
		queryBuilderButton.addListener(listener);
		uuid=UUID.randomUUID();
	}

	private Button.Listener listener = new Button.Listener() {
		@Override
		public void onTriggered(Button button) {
			log.info("Build query event received...building query");
			guiController.queryBuild();
		}
	};

	{

	}



}
