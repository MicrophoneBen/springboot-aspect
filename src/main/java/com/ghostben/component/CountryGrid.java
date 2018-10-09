package com.ghostben.component;


import com.ghostben.entity.Country;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.ui.*;
import de.steinwedel.messagebox.MessageBox;

import java.util.ArrayList;
import java.util.List;

/**
 * author    : ben.zhang.b.q
 * date      : 2018/9/18 16:54
 * package   : com.ghostben.component
 * description : 国家Grid绑定数据
 **/
public class CountryGrid extends CustomComponent {

    private static final long serialVersionUID = 1L;
    public Grid<Country> menugrid;
    private HorizontalLayout hlytbase;
    private List<Country> testitems;
    private ListDataProvider<Country> provider;
    // --> Data provider of Pojo


    //=======================================================

    TextField name = new TextField("Name");
    TextField country = new TextField("country");
    TextField network = new TextField("Network");
    SubWindow subWindow = new SubWindow();
    VerticalLayout subcontent = new VerticalLayout();

    //添加弹窗控制
    //++++++++++++++++++++++++++++++++++++++++++++++++++++

    HorizontalLayout hlyt = new HorizontalLayout();
    TextField tf1 = new TextField();
    TextField tf2 = new TextField();
    TextField tf3 = new TextField();
    //+++++++++++++++++++++++++++++++++编辑行格式

    public CountryGrid() {
        init();
    }

    protected void init() {
        initialize();
        setdata();
        buildLayout();
        setLayout();
        initWindow();
    }

    protected void initWindow(){
        subWindow.setCaption("Sub-window");
        subWindow.setContent(subcontent);
        subWindow.setHeight("350px");
        subWindow.setWidth("500px");
        subcontent.addComponents(name, country, network);
        subWindow.center();
    }

    private void setdata() {
        testitems.add(new Country("张三", "China","网易"));
        testitems.add(new Country("李四", "US","谷歌"));
        testitems.add(new Country("王五", "UK","搜狐"));
        testitems.add(new Country("杰伦", "Germany","搜狗"));
        testitems.add(new Country("张尚峰", "Greece","百度"));
        testitems.add(new Country("省长孟", "Japan","甲骨文"));
        testitems.add(new Country("舜玉娘", "Australia","腾讯"));


//        menugrid.addColumn(Country::getName).setCaption("名字");
//        menugrid.addColumn(Country::getCountry).setCaption("国家");
//        menugrid.addColumn(Country::getNetwork).setCaption("工作");




        //Grid添加按钮控制显示
        menugrid.addItemClickListener(e -> {
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

        menugrid.getEditor().setEnabled(true);

        menugrid.addColumn(Country::getName).setEditorComponent(tf1, Country::setName).setCaption("名字");
        menugrid.addColumn(Country::getCountry).setEditorComponent(tf2, Country::setCountry).setCaption("国家");
        menugrid.addColumn(Country::getNetwork).setEditorComponent(tf3, Country::setNetwork).setCaption("工作");

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

class SubWindow extends Window {

    private static final long serialVersionUID = 1L;

    @Override
    public void close() {
        MessageBox.createQuestion().withCaption("你确定关闭窗口吗")
                .withMessage("关闭 ?").withYesButton(() -> super.close())
                .withNoButton(() -> {})
                .open();
    }
}

