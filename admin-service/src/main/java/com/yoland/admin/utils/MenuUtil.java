package com.yoland.admin.utils;

import com.yoland.common.entity.original.SysMenu;
import com.yoland.admin.dto.SysMenuVO;

import java.util.*;

/**
 * @author autoCode
 * @version 2017-10-31 14:10
 */
public class MenuUtil {
//
//    private static SysMenuVO convertToMenu(SysMenu sysMenu, Map<Long, SysMenuVO> treeNodeMap) {
//        Long id = sysMenu.getId();
//
//        if (!treeNodeMap.containsKey(id)) {
//            SysMenuVO sysMenuVO = new SysMenuVO();
//            sysMenuVO.setId(sysMenu.getId());
//            sysMenuVO.setName(sysMenu.getMenuName());
//            sysMenuVO.setPath(sysMenu.getMenuHref());
//            sysMenuVO.setComponent(sysMenu.getMenuComponent());
//            sysMenuVO.setIconCls(sysMenu.getMenuIcon());
//            sysMenuVO.setLeaf(true);
//
//            treeNodeMap.put(id, sysMenuVO);
//        }
//
//
//        return treeNodeMap.get(sysMenu.getId());
//    }
//
//    public static List<SysMenuVO> convertToTree(List<SysMenu> sysMenuList) {
//
//        Map<Long, SysMenuVO> treeNodeMap = new HashMap<>();
//        List<SysMenuVO> treeNodeList = new ArrayList<>();
//
//        for (SysMenu sysMenu : sysMenuList) {
//            SysMenuVO treeNode = convertToMenu(sysMenu, treeNodeMap);
//
//            if (sysMenu.getParentId() == 0) {
//                treeNodeList.add(treeNode);
//            }
//
//            for (SysMenu sysMenu1 : sysMenuList) {
//                if (Objects.equals(sysMenu1.getParentId(), sysMenu.getId())) {
//
//                    if (treeNode.getChildren() == null) {
//                        treeNode.setChildren(new ArrayList<>());
//                        treeNode.setLeaf(false);
//                    }
//
//                    treeNode.getChildren().add(convertToMenu(sysMenu1, treeNodeMap));
//                }
//            }
//        }
//
//        return treeNodeList;
//    }

}