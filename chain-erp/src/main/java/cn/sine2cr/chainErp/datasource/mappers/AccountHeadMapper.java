package cn.sine2cr.chainErp.datasource.mappers;

import cn.sine2cr.chainErp.datasource.entities.AccountHead;
import cn.sine2cr.chainErp.datasource.entities.AccountHeadExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountHeadMapper {
    long countByExample(AccountHeadExample example);

    int deleteByExample(AccountHeadExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AccountHead record);

    int insertSelective(AccountHead record);

    List<AccountHead> selectByExample(AccountHeadExample example);

    AccountHead selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AccountHead record, @Param("example") AccountHeadExample example);

    int updateByExample(@Param("record") AccountHead record, @Param("example") AccountHeadExample example);

    int updateByPrimaryKeySelective(AccountHead record);

    int updateByPrimaryKey(AccountHead record);
}
