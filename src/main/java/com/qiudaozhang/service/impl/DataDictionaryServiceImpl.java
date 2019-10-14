package com.qiudaozhang.service.impl;

import com.qiudaozhang.mapper.CountryDao;
import com.qiudaozhang.mapper.DataDictionaryDao;
import com.qiudaozhang.model.Country;
import com.qiudaozhang.model.DataDictionary;
import com.qiudaozhang.service.DataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {
    @Autowired
    private DataDictionaryDao dictionaryDao;

    @Override
    public List<DataDictionary> findByTypeCode(String card_type) {
        return dictionaryDao.findByTypeCode(card_type);

    }

    @Override
    public DataDictionary selectCardName(String typeCode, String valueId) {

        return dictionaryDao.selectCardName(typeCode, valueId);

    }
}
