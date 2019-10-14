package com.qiudaozhang.service;

import com.qiudaozhang.model.DataDictionary;

import java.util.List;

public interface DataDictionaryService {
    List<DataDictionary> findByTypeCode(String card_type);

    DataDictionary selectCardName(String typeCode , String valueId);

}
