package cn.sine2cr.chainErp.datasource.mappers;

import cn.sine2cr.chainErp.datasource.entities.MaterialInitialStock;

import java.util.List;

public interface MaterialInitialStockMapperEx {

    int batchInsert(List<MaterialInitialStock> list);

    List<MaterialInitialStock> getListExceptZero();

}
