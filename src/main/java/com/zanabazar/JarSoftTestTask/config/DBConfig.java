package com.zanabazar.JarSoftTestTask.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.*;
import java.util.Properties;

@Configuration
public class DBConfig {

    private static final String DB_ADDRESS = "localhost";
    private static final String DB_PORT = "3306";
    private static final String DB_NAME = "jarsoft";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "thePassword";

    @Bean
    public DataSource getDBConfig() throws IOException {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
            properties.load(fileInputStream);
            String dbAddress = properties.getProperty("db-address");
            String dbPort = properties.getProperty("db-port");
            String dbName = properties.getProperty("db-name");
            String dbUser = properties.getProperty("db-user");
            String dbPassword = properties.getProperty("db-password");

            if (dbAddress == null ||
                    dbPort == null ||
                    dbName == null ||
                    dbUser == null ||
                    dbPassword == null ||
                    dbAddress.isEmpty() ||
                    dbPort.isEmpty() ||
                    dbName.isEmpty() ||
                    dbUser.isEmpty() ||
                    dbPassword.isEmpty()) {
                System.out.println("----------\nNot all db configuration in dbconfig.properties exist!\n----------");
                return null;
            }

            return generateDBConfig(dbAddress, dbPort, dbName, dbUser, dbPassword);

        } catch (IOException e) {

            System.out.println("----------\nFile 'dbconfig.properties' not found. " +
                    "Trying to create default 'dbconfig.properties' file.\n----------");
            try {
                OutputStream outputStream = new FileOutputStream("dbconfig.properties");
                properties.setProperty("db-address", DB_ADDRESS);
                properties.setProperty("db-port", DB_PORT);
                properties.setProperty("db-name", DB_NAME);
                properties.setProperty("db-user", DB_USER);
                properties.setProperty("db-password", DB_PASSWORD);
                properties.store(outputStream, null);

            } catch (IOException ex) {
                System.out.println("----------\nCan't find/load/write default dbconfig.properties file!" +
                        " Check writing rights.\nUsing default configuration.\n----------");
            }
        }
        return generateDBConfig(DB_ADDRESS, DB_PORT, DB_NAME, DB_USER, DB_PASSWORD);
    }

    private DataSource generateDBConfig(String address, String port, String name, String user, String password) {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();

        dataSourceBuilder.url("jdbc:mysql://" + address + ":" + port + "/" + name + "?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false");
        dataSourceBuilder.username(user);
        dataSourceBuilder.password(password);

        return dataSourceBuilder.build();
    }
}
