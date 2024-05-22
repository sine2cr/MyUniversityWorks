package cn.sine2cr.chainErp.datasource.mappers;

import cn.sine2cr.chainErp.datasource.entities.MsgEx;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MsgMapperEx {

    List<MsgEx> selectByConditionMsg(
            @Param("userId") Long userId,
            @Param("name") String name,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByMsg(
            @Param("userId") Long userId,
            @Param("name") String name);

    int batchDeleteMsgByIds(@Param("ids") String ids[]);

    Long getMsgCountByStatus(
            @Param("status") String status,
            @Param("userId") Long userId);
}
