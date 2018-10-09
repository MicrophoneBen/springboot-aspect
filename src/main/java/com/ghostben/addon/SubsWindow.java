package com.ghostben.addon;


import com.ghostben.component.CountryGrid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import de.steinwedel.messagebox.MessageBox;

public class SubsWindow {
    TextField name = new TextField("Name");
    TextField country = new TextField("country");
    TextField network = new TextField("Network");
    SubWindow subWindow = new SubWindow();

    CountryGrid grid = new CountryGrid();

    public SubsWindow() {
        subWindow.setCaption("Sub-window");
        VerticalLayout subcontent = new VerticalLayout();
        subWindow.setContent(subcontent);

        subWindow.setHeight("350px");
        subWindow.setWidth("500px");

        subcontent.addComponents(name, country, network);

        subWindow.center();


        grid.menugrid.addItemClickListener(e ->
        {
            String putName = e.getItem().getName();
            name.setValue(putName);
            name.focus();
            String putCountry = e.getItem().getCountry();
            country.setValue(putCountry);
            String putNetwork = e.getItem().getNetwork();
            network.setValue(putNetwork);
            if (subWindow.isAttached()) {
                UI.getCurrent().removeWindow(subWindow);
            }
            UI.getCurrent().addWindow(subWindow);
        });

    }

}

class SubWindow extends Window {

    private static final long serialVersionUID = 1L;

    @Override
    public void close() {
        MessageBox.createQuestion().withCaption("Do you want to Really close the Window")
                .withMessage("Pakku Me ?").withYesButton(() -> super.close())
                .withNoButton(() -> {
                })
                .open();
    }
}

