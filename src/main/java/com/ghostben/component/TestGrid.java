package com.ghostben.component;

import com.ghostben.entity.Company;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;

import java.util.ArrayList;
import java.util.List;

public class TestGrid extends CustomComponent {

    private static final long serialVersionUID = 1L;
    public Grid<Company> menugrid;
    private HorizontalLayout hlytbase;
    private List<Company> testitems;
    private ListDataProvider<Company> provider;
    // --> Data provider of Pojo

    public TestGrid() {
        init();
    }

    protected void init() {
        initialize();
        setdata();
        buildLayout();
        setLayout();
    }

    private void setdata() {
        testitems.add(new Company(1, "Chocolates"));
        testitems.add(new Company(2, "Icecream"));
        testitems.add(new Company(3, "Pizza"));
        testitems.add(new Company(4, "Sandwhich"));
        testitems.add(new Company(5, "Burger"));
        menugrid.addColumn(Company::getSerialNo).setCaption("sr no");
        menugrid.addColumn(Company::getName).setCaption("Menu");
    }

    private void initialize() {
        menugrid = new Grid<>();
        testitems = new ArrayList<>();
        provider = new ListDataProvider<>(testitems);
        // --> the Collection as Arguement
        hlytbase = new HorizontalLayout();

    }

    private void buildLayout() {
        hlytbase.setMargin(true);
        hlytbase.setSizeFull();
        menugrid.setDataProvider(provider);
    }

    private void setLayout() {
        hlytbase.addComponents(menugrid);
        setCompositionRoot(hlytbase);
    }
}
