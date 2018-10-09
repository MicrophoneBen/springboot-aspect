package com.ghostben.view;

import com.ghostben.navigator.MynavigatorUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

public class HelpView extends VerticalLayout implements View {
    public HelpView() {
        setSizeFull();
        setSpacing(true);
        addComponent(helpbutton());
        addComponent(filterbutton());

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification.show("Showing view: help!");
    }


    private Button helpbutton() {
        Button button = new Button("HelpView", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(MynavigatorUI.DRAGANDDROP);
                //if you have any View here to navigate to and the cycle continuous
            }
        });
        return button;
    }

    private Button filterbutton() {
        Button button = new Button("FilterView", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(MynavigatorUI.FILTERGRID);
                //if you have any View here to navigate to and the cycle continuous
            }
        });
        return button;
    }
}
