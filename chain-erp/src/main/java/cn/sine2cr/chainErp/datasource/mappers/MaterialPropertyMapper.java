package cn.sine2cr.chainErp.datasource.mappers;

import cn.sine2cr.chainErp.datasource.entities.MaterialProperty;
import cn.sine2cr.chainErp.datasource.entities.MaterialPropertyExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaterialPropertyMapper {
    long countByExample(MaterialPropertyExample example);

    int deleteByExample(MaterialPropertyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MaterialProperty record);

    int insertSelective(MaterialProperty record);

    List<MaterialProperty> selectByExample(MaterialPropertyExample example);

    MaterialProperty selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MaterialProperty record, @Param("example") MaterialPropertyExample example);

    int updateByExample(@Param("record") MaterialProperty record, @Param("example") MaterialPropertyExample example);

    int updateByPrimaryKeySelective(MaterialProperty record);

    int updateByPrimaryKey(MaterialProperty record);
}
