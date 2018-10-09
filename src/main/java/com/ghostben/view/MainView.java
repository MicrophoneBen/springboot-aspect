package com.ghostben.view;

import com.ghostben.navigator.MynavigatorUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

public class MainView extends VerticalLayout implements View {

    public MainView() {
        setSizeFull();
        setSpacing(true);
        Label label = new Label("Entered in mainview.");
        addComponent(label);
        addComponent(headingLabel());
        addComponent(mainButton());
    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification.show("Showing view: Main!");
    }


    private Label headingLabel() {
        return new Label("Main");
    }

    private Button mainButton() {
        Button button = new Button("mainView", (Button.ClickListener)
                event -> getUI().getNavigator().navigateTo(MynavigatorUI.HELPVIEW));
        return button;
    }
}
