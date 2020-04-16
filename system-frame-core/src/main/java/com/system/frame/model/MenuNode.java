package com.system.frame.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import sun.reflect.generics.tree.Tree;

import java.io.Serializable;
import java.util.*;

/**
 *   菜单对象节点
 */
@Data
public class MenuNode implements Comparable, Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long menuId;
    /**
     * 菜单编号
     */
    private String code;
    /**
     * 菜单父编号
     */
    private String pcode;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * url地址
     */
    private String url;
    /**
     * 菜单排序号
     */
    private Integer sort;
    /**
     * 菜单层级
     */
    private Integer levels;
    /**
     * 是否是菜单(字典)
     */
    private String menuFlag;

    private List<MenuNode> children;


    public static List<MenuNode> buildMenuTree(List<MenuNode> nodes) {
        if (nodes.size() <= 0) {
            return nodes;
        }
        //剔除非菜单
        nodes.removeIf(node -> !node.getMenuFlag().equals("Y"));
        return buildTree(nodes,"0");
    }

    public static List<MenuNode> buildTree(List<MenuNode> list, String pcode) {
        List<MenuNode> resultList = new ArrayList<>();
        if (list == null || list.size() == 0 ) {
            return null;
        }
        for (MenuNode tree : list) {
            if (tree.getPcode().equals(pcode)) {
                resultList.add(tree);
                tree.setChildren(buildTree(list, tree.getCode()));
            }
        }
        return resultList;
    }


    @Override
    public int compareTo(Object o) {
        MenuNode menuNode = (MenuNode) o;
        Integer num = menuNode.getSort();
        Integer levels = menuNode.getLevels();
        if (num == null) {
            num = 0;
        }
        if (levels == null) {
            levels = 0;
        }
        if (this.levels.compareTo(levels) == 0) {
            return this.sort.compareTo(num);
        } else {
            return this.levels.compareTo(levels);
        }
    }
}
