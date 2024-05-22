package cn.sine2cr.chainErp.datasource.mappers;

import cn.sine2cr.chainErp.datasource.entities.MaterialAttribute;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialAttributeMapperEx {

    List<MaterialAttribute> selectByConditionMaterialAttribute(
            @Param("attributeName") String attributeName,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByMaterialAttribute(
            @Param("attributeField") String attributeField);

    int batchDeleteMaterialAttributeByIds(
            @Param("ids") String ids[]);
}
