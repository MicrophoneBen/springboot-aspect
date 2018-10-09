package com.ghostben.view;

import com.ghostben.component.EditGrid;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

/**
 * author    : ben.zhang.b.q
 * date      : 2018/9/18 18:00
 * package   : com.ghostben.view
 * description : ${DESC}
 **/
public class EditView extends VerticalLayout implements View {

    private EditGrid editGrid = new EditGrid();

    public EditView(){
        setSizeFull();
        setSpacing(true);

        addComponent(editGrid);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification.show("支持编辑Grid页面");
    }
}
