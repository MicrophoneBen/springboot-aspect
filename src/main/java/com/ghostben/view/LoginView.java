package com.ghostben.view;

import com.ghostben.navigator.MynavigatorUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class LoginView extends VerticalLayout implements View {
    public LoginView() {
        setSizeFull();
        setSpacing(true);

        Label label = new Label("Enter your information below to log in.");
        TextField username = new TextField("username");
        TextField password = new TextField("password");

        addComponent(label);
        addComponent(username);
        addComponent(password);
        addComponent(loginButton());
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // TODO Auto-generated method stub

    }

    private Button loginButton() {
        Button button = new Button("Log In", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(MynavigatorUI.MAINVIEW);


            }
        });
        return button;

    }
}
