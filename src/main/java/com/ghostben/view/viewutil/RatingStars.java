package com.ghostben.view.viewutil;

import com.vaadin.annotations.Theme;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;

import java.util.ArrayList;
import java.util.List;

@Theme("RatingStars")
public class RatingStars extends CustomComponent implements View {

    Button b1 = new Button();
    Button b2 = new Button();
    Button b3 = new Button();
    Button b4 = new Button();
    Button b5 = new Button();
    Label status = new Label("Review us");

    private Button.ClickListener listener;

    public RatingStars() {

        listener = this::test;

        b1.setIcon(VaadinIcons.STAR_O);
        b2.setIcon(VaadinIcons.STAR_O);
        b3.setIcon(VaadinIcons.STAR_O);
        b4.setIcon(VaadinIcons.STAR_O);
        b5.setIcon(VaadinIcons.STAR_O);

        b1.addClickListener(listener);
        b2.addClickListener(listener);
        b3.addClickListener(listener);
        b4.addClickListener(listener);
        b5.addClickListener(listener);

        List<Button> lstbtn = new ArrayList<>();
        lstbtn.add(b1);
        lstbtn.add(b2);
        lstbtn.add(b3);
        lstbtn.add(b4);
        lstbtn.add(b5);

        CssLayout hlyt = new CssLayout();
        status.setVisible(false);
        hlyt.addComponents(b1, b2, b3, b4, b5, status);
        addStyleName("RatingStars");
        hlyt.setSizeFull();
        setCompositionRoot(hlyt);
    }

    public void test(Button.ClickEvent event) {
        if (event.getButton() == b1) {
            b1.setIcon(VaadinIcons.STAR);
            b2.setIcon(VaadinIcons.STAR_O);
            b3.setIcon(VaadinIcons.STAR_O);
            b4.setIcon(VaadinIcons.STAR_O);
            b5.setIcon(VaadinIcons.STAR_O);
            status.setValue("worst");
            status.setVisible(true);
        } else if (event.getButton() == b2) {
            b1.setIcon(VaadinIcons.STAR);
            b2.setIcon(VaadinIcons.STAR);
            b3.setIcon(VaadinIcons.STAR_O);
            b4.setIcon(VaadinIcons.STAR_O);
            b5.setIcon(VaadinIcons.STAR_O);
            status.setValue("bad");
            status.setVisible(true);
        } else if (event.getButton() == b3) {
            b1.setIcon(VaadinIcons.STAR);
            b2.setIcon(VaadinIcons.STAR);
            b3.setIcon(VaadinIcons.STAR);
            b4.setIcon(VaadinIcons.STAR_O);
            b5.setIcon(VaadinIcons.STAR_O);
            status.setValue("OK");
            status.setVisible(true);
        } else if (event.getButton() == b4) {
            b3.setIcon(VaadinIcons.STAR);
            b2.setIcon(VaadinIcons.STAR);
            b1.setIcon(VaadinIcons.STAR);
            b4.setIcon(VaadinIcons.STAR);
            b5.setIcon(VaadinIcons.STAR_O);
            status.setValue("better");
            status.setVisible(true);
        } else if (event.getButton() == b5) {
            b4.setIcon(VaadinIcons.STAR);
            b3.setIcon(VaadinIcons.STAR);
            b2.setIcon(VaadinIcons.STAR);
            b1.setIcon(VaadinIcons.STAR);
            b5.setIcon(VaadinIcons.STAR);
            status.setValue("best");
            status.setVisible(true);
        }

    }

}
