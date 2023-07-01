package com.hls.hlsservicerider.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * 自动生成代码工具类
 */
public class MysqlGenerator {
    public static void main(String[] args) {

        FastAutoGenerator.create("jdbc:mysql://localhost:3306/service-rider?characterEncoding=utf-8&serverTimezone=GMT%2B8",
                "root","root")
                .globalConfig(builder -> {
                    builder.author("hls").fileOverride().outputDir("F:\\java\\大三下\\Nacos\\nacos-exam\\hls-service-rider\\src\\main\\java");
                })
                .packageConfig(builder -> {
                    builder.parent("com.hls.hlsservicerider").pathInfo(Collections.singletonMap(OutputFile.mapperXml,
                            "F:\\java\\大三下\\Nacos\\nacos-exam\\hls-service-rider\\src\\main\\java\\com\\hls\\hlsservicerider\\mapper"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude("rider_work_status");
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
