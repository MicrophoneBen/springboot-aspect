package com.ghostben.component;

import com.ghostben.entity.Country;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;

/**
 * author    : ben.zhang.b.q
 * date      : 2018/9/18 17:53
 * package   : com.ghostben.component
 * description : ${DESC}
 **/
public class EditGrid extends CustomComponent {
    private static final long serialVersionUID = 1L;
    public Grid<Country> menugrid;
    TextField name = new TextField("Name");
    TextField country = new TextField("country");
    TextField network = new TextField("Network");
    // --> Data provider of Pojo


    //=======================================================

    HorizontalLayout hlyt = new HorizontalLayout();
    TextField tf1 = new TextField();
    TextField tf2 = new TextField();
    TextField tf3 = new TextField();

    private HorizontalLayout hlytbase;

    //添加弹窗控制
    //++++++++++++++++++++++++++++++++++++++++++++++++++++

    private List<Country> testitems;
    private ListDataProvider<Country> provider;

    //+++++++++++++++++++++++++++++++++编辑行格式

    public EditGrid() {
        init();
    }

    protected void init() {
        initialize();
        setdata();
        buildLayout();
        setLayout();
    }

    private void setdata() {
        testitems.add(new Country("张三", "China", "网易"));
        testitems.add(new Country("李四", "US", "谷歌"));
        testitems.add(new Country("王五", "UK", "搜狐"));
        testitems.add(new Country("杰伦", "Germany", "搜狗"));
        testitems.add(new Country("张尚峰", "Greece", "百度"));
        testitems.add(new Country("省长孟", "Japan", "甲骨文"));
        testitems.add(new Country("舜玉娘", "Australia", "腾讯"));


    /*
       menugrid.addColumn(Country::getName).setCaption("名字");
        menugrid.addColumn(Country::getCountry).setCaption("国家");
        menugrid.addColumn(Country::getNetwork).setCaption("工作");

        */


        //设置允许编辑
        menugrid.getEditor().setEnabled(true);
        menugrid.addColumn(Country::getName).setEditorComponent(tf1, Country::setName).setCaption("名字").setExpandRatio(2);
        menugrid.addColumn(Country::getCountry).setEditorComponent(tf2, Country::setCountry).setCaption("国家").setExpandRatio(2);
        menugrid.addColumn(Country::getNetwork).setEditorComponent(tf3, Country::setNetwork).setCaption("工作").setExpandRatio(2);
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
