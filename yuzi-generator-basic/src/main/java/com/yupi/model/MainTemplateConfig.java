package com.yupi.model;

import lombok.Data;

@Data
public class MainTemplateConfig {

    /**
     * 填充文本
     */
    private String author = "yue";
    private String outputText = "求和结果";

    /**
     * 是否循环
     */
    private boolean loop = false;
}
