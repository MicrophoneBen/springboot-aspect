package com.ghostben.view;

import com.ghostben.component.DragAndDropFromGrid;
import com.ghostben.navigator.MynavigatorUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

public class DragView extends VerticalLayout implements View {

    static final DragAndDropFromGrid dragAndDropFromGrid =new DragAndDropFromGrid();


    public DragView(){

        setSizeFull();
        setSpacing(true);

        addComponent(dragAndDropFromGrid);
        addComponent(turnToCompany());
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification.show("Drag And Drop PageView");
    }

    public Button turnToCompany(){
        Button btn = new Button("CompanyRating", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                getUI().getNavigator().navigateTo(MynavigatorUI.COMPANYRATING);
            }
        });

        return btn;
    }
}
