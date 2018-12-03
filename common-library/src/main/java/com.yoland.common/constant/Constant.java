package com.yoland.common.constant;

/**
 * @author leo
 * @since 2018/7/27 8:49
 */
public interface Constant<T> {
    
     String VALID = "1";//有效
     String INVALID = "0";//无效

     String DATA_DELETED = "1";  // 逻辑删除: 已删除
     String DATA_NORMAL = "0";  // 逻辑删除: 正常


    //消息推送状态
     String PUSH_STATUS_0 = "0";//未推送

}
