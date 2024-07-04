package org.apache.dolphinscheduler.plugin.datasource.api.datasource;

import lombok.Data;

import java.io.Serializable;

@Data
public class JdbcUrl implements Serializable {

    private String driverName;
    private String host;
    private String port;
    private String database;
    private String params;
}
