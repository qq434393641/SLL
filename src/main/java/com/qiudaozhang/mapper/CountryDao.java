package com.qiudaozhang.mapper;

import com.qiudaozhang.model.Country;

import java.util.List;

public interface CountryDao {
    List<Country> findAll();
}