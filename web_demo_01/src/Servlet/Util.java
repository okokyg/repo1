package Servlet;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static DataSource ds;

    static{
        Properties pro = new Properties();

        try {
            InputStream is = Util.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            ds= DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


public static  DataSource getDataSource(){
    return ds;
}

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
