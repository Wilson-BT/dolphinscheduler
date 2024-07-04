package org.apache.dolphinscheduler.plugin.datasource.api.utils;

import org.apache.dolphinscheduler.plugin.datasource.api.datasource.JdbcUrl;
public class JdbcUrlSplitUtil{

    public static JdbcUrl split(String jdbcUrl) {
        String driverName = "";
        String host="";
        String port="";
        String database="";
        String params="";
        int pos, pos1, pos2;
        String connUri;

        if(jdbcUrl == null || !jdbcUrl.startsWith("jdbc:")
                || (pos1 = jdbcUrl.indexOf(':', 5)) == -1){
            throw new IllegalArgumentException("Invalid JDBC url.");
        }

        driverName = jdbcUrl.substring(5, pos1);
        if((pos2 = jdbcUrl.indexOf(';', pos1)) == -1) {
            connUri = jdbcUrl.substring(pos1 + 1);
        } else {
            connUri = jdbcUrl.substring(pos1 + 1, pos2);
            params = jdbcUrl.substring(pos2 + 1);
        }

        if(connUri.startsWith("//")) {
            connUri = connUri.replace("//","");
            if((pos = connUri.indexOf('/', 2)) != -1) {
                host = connUri.substring(2, pos);
                database = connUri.substring(pos + 1);
            } else if((pos = connUri.indexOf(':')) != -1) {
                host = connUri.substring(0, pos);
                port = connUri.substring(pos + 1);
            }
        } else {
            database = connUri;
        }
        JdbcUrl jdbcUrlEntity = new JdbcUrl();
        jdbcUrlEntity.setPort(port);
        jdbcUrlEntity.setHost(host);
        jdbcUrlEntity.setParams(params);
        jdbcUrlEntity.setDriverName(driverName);
        jdbcUrlEntity.setDatabase(database);
        return jdbcUrlEntity;
    }

    public static void main(String[] args) {
        String jdbc = "jdbc:mysql://172.19.110.14:9030";
        System.out.println(split(jdbc).getHost());
    }
}
