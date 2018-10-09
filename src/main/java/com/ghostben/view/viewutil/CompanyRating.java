package com.ghostben.view.viewutil;

import com.ghostben.entity.Company;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.navigator.View;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.dnd.DropEffect;
import com.vaadin.shared.ui.dnd.EffectAllowed;
import com.vaadin.shared.ui.grid.DropMode;
import com.vaadin.ui.*;
import com.vaadin.ui.components.grid.GridDragSource;
import com.vaadin.ui.components.grid.GridDropTarget;
import com.vaadin.ui.components.grid.GridRowDragger;
import com.vaadin.ui.renderers.ImageRenderer;

import java.util.*;

public class CompanyRating extends VerticalLayout implements View {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public HorizontalLayout hlytbase = new HorizontalLayout();
    private static Grid<Company> grid = new Grid<>();
    TextField name = new TextField();
    TextField srno = new TextField();
    Button btn = new com.vaadin.ui.Button("ADD");
    private ListDataProvider<Company> dataProvider;
    private List<Company> company;
    private Optional<Company> dragged;
    private Grid<Company> childgrid = new Grid<>();
    private ListDataProvider<Company> dp;
    private List<Company> items;

    public CompanyRating() {
        setSizeFull();
        srno.setPlaceholder("enter Serial no");
        name.setPlaceholder("enter name");
        company = new ArrayList<>();

        company.add(new Company(1, "Dominoes", new RatingStars()));
        company.add(new Company(2, "Google", new RatingStars()));
        company.add(new Company(3, "Yahoo", new RatingStars()));
        company.add(new Company(4, "Ford", new RatingStars()));
        company.add(new Company(5, "Nissan", new RatingStars()));
        company.add(new Company(6, "BMW", new RatingStars()));

        dataProvider = new ListDataProvider<>(company);


        Map<Company, TextField> textFields = new HashMap<>();


        GridDragSource<Company> dragSource = new GridDragSource<>(grid);


        dragSource.setEffectAllowed(EffectAllowed.MOVE);

        dragSource.setDragDataGenerator("text", person -> {
            return person.getName() + " " + person.getSerialNo();
        });

        dragSource.addGridDragStartListener(event -> {
            List<Company> list = new ArrayList<>(event.getDraggedItems());
            if (!list.isEmpty()) {
                dragged = Optional.of(list.get(0));
            }
        });

        dragSource.addGridDragEndListener(event -> {
            if (event.getDropEffect() == DropEffect.MOVE) {
                grid.getDataProvider().refreshAll();
            }
        });

        GridDropTarget<Company> dropTarget = new GridDropTarget<>(grid, DropMode.ON_TOP);
        dropTarget.setDropEffect(DropEffect.MOVE);


        dropTarget.addGridDropListener(event -> {
            Optional<Company> dropTargetRow = event.getDropTargetRow();
            if (dropTargetRow.isPresent() && dragged.isPresent()) {
                Company drag = dragged.get();
                Company drop = dropTargetRow.get();
                Collections.swap(company, company.indexOf(drag), company.indexOf(drop));
                dataProvider.refreshAll();
            }
        });


        grid.addColumn(Company::getSerialNo).setCaption("Number").setWidth(20);
        grid.addColumn(Company::getName).setCaption("Name").setWidth(100);
        grid.addComponentColumn(Company::getRtstars).setCaption("Rate It");
        Grid.Column<Company, ThemeResource> imageColumn = grid.addColumn(
                p -> new ThemeResource(p.getName() + ".jpg"),
                new ImageRenderer<Company>()).setCaption("Image");


        grid.setDataProvider(dataProvider);

        btn.addClickListener(e -> {
            if (!srno.getValue().isEmpty()) {
                company.add(new Company(Integer.parseInt(srno.getValue()), name.getValue(),
                        new RatingStars()));
                dataProvider.refreshAll();
            }
        });

        srno.setSizeFull();
        name.setSizeFull();
        btn.setSizeUndefined();
        grid.setSizeFull();
        new GridRowDragger<Company>(grid);

        VerticalLayout layout = new VerticalLayout();
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        layout.addComponent(grid);
        horizontalLayout.addComponents(srno,name,btn);

        addComponents(horizontalLayout,layout);

        items = new ArrayList<>();
        dp = new ListDataProvider<>(items);
        childgrid.addColumn(Company::getSerialNo).setCaption("Number");
        childgrid.addColumn(Company::getName).setCaption("Company");
        childgrid.setDataProvider(dp);
        addComponent(childgrid);
        childgrid.setVisible(false);

        grid.addItemClickListener(e -> {
            items.clear();
            Company company = e.getItem();
            if (company != null) {
                childgrid.setVisible(true);
                items.add(company);
            } else {
                childgrid.setVisible(false);
            }
            dp.refreshAll();
        });

    }
}
