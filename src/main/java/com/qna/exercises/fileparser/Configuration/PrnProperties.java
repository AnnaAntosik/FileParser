package com.qna.exercises.fileparser.Configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties("prn")
public class PrnProperties {

    private int[] splitter;

    public int[] getSplitter() {
        return splitter;
    }

    public void setSplitter(int[] splitter) {
        this.splitter = splitter;
    }
}
