package com.qiudaozhang.components;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:config/file.properties")
@Setter
@Getter
public class FileConfig {

    @Value("${uploadRootPath}")
    private String uploadRootPath;
}
