package com.yoland.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yoland.common.entity.original.SysMsgPush;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SysMsgPushMapper extends BaseMapper<SysMsgPush> {

}