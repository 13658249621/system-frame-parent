package com.system.frame.factory;


import com.system.frame.model.LayuiTreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 封装layui属性组件数据
 */
public class LayuiTreeFactory {

    /**
     * 生成layuiTree根节点
     */
    public static LayuiTreeNode createRoot() {
        LayuiTreeNode treeNode = new LayuiTreeNode();
        treeNode.setChecked(true);
        treeNode.setId(0L);
        treeNode.setTitle("顶级");
        treeNode.setSpread(true);
        treeNode.setPid(-1L);
        return treeNode;
    }

    /**
     *   构造layui树形控件
     * @param allNodes
     * @return
     */
    public static List<LayuiTreeNode>  buildTree(List<LayuiTreeNode> allNodes){
        List<LayuiTreeNode> rootMenu = new ArrayList<LayuiTreeNode>();
        for (LayuiTreeNode nav : allNodes) {
            if(nav.getPid()==0){//父节点是0的，为根节点。
                rootMenu.add(nav);
            }
        }
        //为根菜单设置子菜单，getClild是递归调用的
        for (LayuiTreeNode nav : rootMenu) {
            /* 获取根节点下的所有子节点 使用getChild方法*/
            List<LayuiTreeNode> childList = getChild(nav.getId(), allNodes);
            nav.setChildren(childList);//给根节点设置子节点
        }
        return rootMenu;


    }

    /**
     * 获取子节点
     * @param id 父节点id
     * @param allMenu 所有菜单列表
     * @return 每个根节点下，所有子菜单列表
     */
    public static List<LayuiTreeNode> getChild(Long id,List<LayuiTreeNode> allMenu){
        //子菜单
        List<LayuiTreeNode> childList = new ArrayList<LayuiTreeNode>();
        for (LayuiTreeNode nav : allMenu) {
            // 遍历所有节点，将所有菜单的父id与传过来的根节点的id比较
            //相等说明：为该根节点的子节点。
            if(nav.getPid().equals(id)){
                childList.add(nav);
            }
        }
        //递归
        for (LayuiTreeNode nav : childList) {
            nav.setChildren(getChild(nav.getId(), allMenu));
        }
        //如果节点下没有子节点，返回一个空List（递归退出）
        if(childList.size() == 0){
            return new ArrayList<>();
        }
        return childList;
    }




}
