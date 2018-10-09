package com.ghostben.component;

import com.ghostben.entity.Company;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.shared.ui.dnd.DropEffect;
import com.vaadin.shared.ui.dnd.EffectAllowed;
import com.vaadin.shared.ui.grid.DropMode;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.components.grid.GridDragSource;
import com.vaadin.ui.components.grid.GridDropTarget;
import com.vaadin.ui.components.grid.GridRowDragger;
import com.vaadin.ui.renderers.ButtonRenderer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author ben.zhang.b.q
 */
public class DragAndDropFromGrid extends CustomComponent {

    private static final long serialVersionUID = 1L;

    private HorizontalLayout hlytbase;

    private Grid<Company> grid1;
    private Grid<Company> grid2;

    private ListDataProvider<Company> provider1;
    private ListDataProvider<Company> provider2;

    private Optional<Company> dragged;

    private List<Company> lstgridsecond;
    private List<Company> cmpy;
    private List<Company> list;

    public DragAndDropFromGrid() {
        init();
    }

    private void init() {
        lstgridsecond = new ArrayList<Company>();
        hlytbase = new HorizontalLayout();

        cmpy = new ArrayList<Company>();
        cmpy.add(new Company(1, "idli"));
        cmpy.add(new Company(2, "Pizza"));
        cmpy.add(new Company(3, "samosa"));
        cmpy.add(new Company(4, "Pani puri"));
        cmpy.add(new Company(5, "Ragdo"));

        provider1 = new ListDataProvider<>(cmpy);
        provider2 = new ListDataProvider<>(lstgridsecond);

        grid1 = new Grid<>();
        // enable DnD reordering within the grid
        new GridRowDragger<>(grid1);
        grid2 = new Grid<>();

        grid1.addColumn(Company::getSerialNo).setCaption("sr no");
        grid1.addColumn(Company::getName).setCaption("name");
        grid2.addColumn(Company::getSerialNo).setCaption("sr no");
        grid2.addColumn(Company::getName).setCaption("name");
        grid2.addColumn(del -> "Delete", new ButtonRenderer<Company>(clickEvent -> {
            lstgridsecond.remove(clickEvent.getItem());
            provider2.refreshAll();
        })).setCaption("Delete");

        grid1.setCaption("Menu Drag and Drop to Select" + ">>> ");
        grid2.setCaption("Selected Menu to be Ordered");

        grid2.setDataProvider(provider2);
        grid1.setDataProvider(provider1);

        hlytbase.setMargin(true);
        hlytbase.addComponents(grid1, grid2);
        setCompositionRoot(hlytbase);

        implementDragAndDrop();
    }

    @SuppressWarnings("unchecked")
    private void implementDragAndDrop() {
        GridDragSource<Company> dragSource = new GridDragSource<>(grid1);
        dragSource.setEffectAllowed(EffectAllowed.MOVE);

        dragSource.setDragDataGenerator("text", person -> {
            return person.getName() + " " + person.getSerialNo();
        });

        dragSource.addGridDragStartListener(event -> {
            list = new ArrayList<>(event.getDraggedItems());
            if (!list.isEmpty()) {
                dragged = Optional.of(list.get(0));
            } else {
                dragged = Optional.empty();
            }
        });

        dragSource.addGridDragEndListener(event -> {
            // If drop was successful, remove dragged items from source Grid
            if (event.getDropEffect() == DropEffect.MOVE) {
                ((ListDataProvider<Company>) grid1.getDataProvider()).getItems().remove(dragged);
                grid1.getDataProvider().refreshAll();
                // Remove reference to dragged items
                dragged = null;
            }
        });

        GridDropTarget<Company> dropTarget = new GridDropTarget<>(grid2, DropMode.ON_TOP);
        dropTarget.setDropEffect(DropEffect.MOVE);

        dropTarget.addGridDropListener(event -> {
            if (dragged.isPresent() && !lstgridsecond.contains(list.get(0))) {
                lstgridsecond.add(dragged.get());
                provider2.refreshAll();
            }
        });
    }
}
