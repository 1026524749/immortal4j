package com.immortal.immortal4j.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/4 22:39
 */
@Component
public class ApplicationProperties {
    @Value("${com.neo.title}")
    private String title;

    @Value("${com.neo.description}")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
