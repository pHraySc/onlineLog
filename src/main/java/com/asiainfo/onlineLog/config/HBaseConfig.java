package com.asiainfo.onlineLog.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * All rights Reserved, Designed By asiainfo.com
 *
 * @version V1.0
 * @Title:  onlineLog
 * @Package com.asiainfo.onlineLog.config
 * @Description: 数据源配置
 * @author: sc
 * @date: 2017年04月4/25/17日 下午20: 32
 * @updater: sc
 * @updates: TODO
 */
@Configuration
public class HBaseConfig {

    @Bean(name = "phoenix")
    @Qualifier("connect")
    public Connection getConnection() {
        Connection connection  = null;
        try{
            String keytabFile = "user.keytab";
            String principal = "yx_swrz";
            String confDirPath = System.getProperty("user.dir") + File.separator + "conf" + File.separator;
            System.setProperty("java.security.auth.login.config", confDirPath + "jaas.conf");
            System.setProperty("java.security.krb5.conf", confDirPath + "krb5.conf");
            Properties properties = new Properties();
            properties.put("username.client.keytab.file", confDirPath + keytabFile);
            properties.put("username.client.kerberos.principal", principal);
            Class.forName("org.apache.phoenix.jdbc.PhoenixDriver");
            System.out.println("====================分割线===========================");
            properties.forEach((k,v) -> {
                System.out.println("k=" + k + "===== v=" + v);
            });
            System.out.println("====================分割线===========================");
            connection = DriverManager.getConnection("jdbc:phoenix", properties);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException se){
            se.printStackTrace();
        }
        System.out.println("====================连接" + connection + "====================");
        return connection;
    }

}
