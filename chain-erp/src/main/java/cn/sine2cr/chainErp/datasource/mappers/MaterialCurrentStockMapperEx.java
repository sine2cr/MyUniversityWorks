package cn.sine2cr.chainErp.datasource.mappers;

import cn.sine2cr.chainErp.datasource.entities.MaterialCurrentStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialCurrentStockMapperEx {

    int batchInsert(List<MaterialCurrentStock> list);

    List<MaterialCurrentStock> getCurrentStockMapByIdList(
            @Param("materialIdList") List<Long> materialIdList);
}
