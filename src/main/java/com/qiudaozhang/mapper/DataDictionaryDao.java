package com.qiudaozhang.mapper;

import com.qiudaozhang.model.DataDictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DataDictionaryDao {
    List<DataDictionary> findByTypeCode(@Param("cardType") String card_type);

    DataDictionary selectCardName(@Param("typeCode") String typeCode, @Param("valueId") String valueId);
}