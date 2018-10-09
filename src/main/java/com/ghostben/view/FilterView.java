package com.ghostben.view;

import com.ghostben.component.FilterGrid;
import com.ghostben.navigator.MynavigatorUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

public class FilterView extends VerticalLayout implements View {

    private static FilterGrid filterGrid = new FilterGrid();

    public FilterView(){
    setSizeFull();
    setSpacing(true);

    addComponent(filterGrid);
    addComponent(button);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

        Notification.show("Grid过滤查找功能");
    }

    public Button button =  new Button("国家", clickEvent -> {
        UI.getCurrent().getNavigator().navigateTo(MynavigatorUI.COUNTRYVIEW);
    });
}
