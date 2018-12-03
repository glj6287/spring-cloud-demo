package com.yoland.admin.utils;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.yoland.common.utils.BeanUtil.copy;

/**
 * @author autoCode
 * @version 2017-10-30 11:34
 */
public class TreeUtil {

    private static final Long DEFUALT_ROOT_ID = 0L;

    /**
     *
     * 将list转换为树形结构，并且树形节点里包含响应对象的完整信息
     * @param list sql查询的list
     * @param <T> list具体的泛型
     * @return 具有相应泛型数据的树形结构，如果传入参数为null或空list则返回null
     */
    public static <T> List<TreeNode<T>> convert(List<T> list) {
        return convert(list, true, DEFUALT_ROOT_ID);
    }

    /**
     * 将list转换为树形结构，并且树形节点里包含响应对象的完整信息
     * @param list sql查询的list
     * @param <T> list具体的泛型
     * @param containData 是否包含需要转换对象的全部信息
     * @return 具有相应泛型数据的树形结构，如果传入参数为null或空list则返回null
     */
    public static <T> List<TreeNode<T>> convert(List<T> list, Boolean containData) {
        return convert(list, containData, DEFUALT_ROOT_ID);
    }

    /**
     * 将list转换为树形结构
     * @param list sql查询的list
     * @param <T> list具体的泛型
     * @param containData 是否包含需要转换对象的全部信息
     * @param rootId 根的ID
     * @return 具有相应泛型数据的树形结构，如果传入参数为null或空list则返回null
     */
    public static <T> List<TreeNode<T>> convert(List<T> list, Boolean containData, Long rootId) {

        if (list == null || list.isEmpty()) {
            return null;
        }

        List<TreeNode<T>> treeNodeList = new ArrayList<>(list.size());
        List<TreeNode<T>> resultList = new ArrayList<>();

        for (T data : list) {
            treeNodeList.add(wrap(data, containData));
        }

        for (TreeNode<T> outterTreeNode : treeNodeList) {
            if (rootId.equals(outterTreeNode.getParentId())) {
                resultList.add(outterTreeNode);
            }

            for (TreeNode<T> innerTreeNode : treeNodeList) {

                if (Objects.equals(innerTreeNode.getParentId(), outterTreeNode.getId())) {

                    outterTreeNode.addChild(innerTreeNode);
                }
            }
        }

        return resultList;
    }

    /**
     * 将指定的对象转换为树形节点对象，前提是指定的对象需要包含id、name、parentId这三个必要字段
     * @param data 需要转换的对象
     * @param <T> 转换对象的泛型
     * @return 返回包含对象信息的树节点对象
     */
    public static <T> TreeNode<T> wrap(T data) {
        return wrap(data, true);
    }

    /**
     * 将指定的对象转换为树形节点对象，前提是指定的对象需要包含id、name、parentId这三个必要字段
     * @param data 需要转换的对象
     * @param containData 是否在节点中包含转换对象的全部信息
     * @param <T> 转换对象的泛型
     * @return 返回包含对象信息的树节点对象，如果containData为false，则只包含三个必要字段的数据
     */
    public static <T> TreeNode<T> wrap(T data, Boolean containData) {
        Type treeNodeClass = new TypeToken<TreeNode<T>>(){}.getType();
        TreeNode<T> treeNode = copy(data, treeNodeClass);

        if (containData) {
            treeNode.setData(data);
        }
        return treeNode;
    }

    public static <T> TreeNode<T> rootNode(String name) {
        return rootNode(name, DEFUALT_ROOT_ID);
    }

    public static <T> TreeNode<T> rootNode(String name, Long rootId) {
        TreeNode<T> treeNode = new TreeNode<>();

        treeNode.setId(rootId);
        treeNode.setName(name);

        return treeNode;
    }

}
