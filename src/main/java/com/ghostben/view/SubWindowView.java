package com.ghostben.view;

import com.ghostben.component.CountryGrid;
import com.ghostben.navigator.MynavigatorUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * author    : ben.zhang.b.q
 * date      : 2018/9/18 17:10
 * package   : com.ghostben.view
 * description : ${DESC}
 **/
public class SubWindowView extends VerticalLayout implements View {

    private static CountryGrid countryGrid = new CountryGrid();

    public SubWindowView(){
        setSizeFull();
        setSpacing(true);

        addComponent(countryGrid);
        addComponent(button);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification.show("弹窗设置");
    }

    public Button button = new Button("编辑页面",clickEvent -> {
        UI.getCurrent().getNavigator().navigateTo(MynavigatorUI.EDITGRID);
    });

}
