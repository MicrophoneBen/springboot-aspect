package com.ghostben.component;

import com.ghostben.entity.Company;
import com.vaadin.data.HasValue;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class FilterGrid extends CustomComponent {

    private VerticalLayout vlytbase;

    private TextField search;
    //for searching the Respctive Text

    TestGrid tstgrid = new TestGrid();
    String input;

    public FilterGrid() {
        vlytbase = new VerticalLayout();
        vlytbase.setMargin(true);
        vlytbase.setSizeFull();
        search = new TextField();
        search.setPlaceholder("Search");
        vlytbase.addComponents(search, tstgrid);
        vlytbase.setSpacing(true);
        vlytbase.setMargin(true);
        vlytbase.setSizeFull();
        setCompositionRoot(vlytbase);
        addListener();
    }

    private void addListener() {
        search.addValueChangeListener(e -> CheckHasValue(e));
        //Listener

    }

    private void CheckHasValue(HasValue.ValueChangeEvent<String> e) {
        //casting provider

        input = e.getValue();
        ((ListDataProvider<Company>)tstgrid.menugrid.getDataProvider())
                .setFilter(p -> Casesensitivesearch(p, input));
    }

    private boolean Casesensitivesearch(Company p, String searchedToken) {
        return p.getName().toLowerCase().contains(searchedToken.toLowerCase());

    }
}
