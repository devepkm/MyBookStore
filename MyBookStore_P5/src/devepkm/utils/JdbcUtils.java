package devepkm.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Auther: dev
 * @Date: 20/9/2020 17:49
 * @Description:
 */
public class JdbcUtils {

    private static DruidDataSource dataSource;


    /**
     * Intialize the dataSource by load configuration file
     */
    static {
        Properties pros = new Properties();
        InputStream is = null;
        try {
            is = JdbcUtils.class.getClassLoader().getResourceAsStream("com/devepkm/dbresource/config.properties");
            pros.load(is);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * @return A db connection from datasource
     */
    public static Connection getConnection() {

        try {
            return dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;

    }

    /**
     * Return connection to dataSource pool
     * @param conn
     */
    public static void close(Connection conn) {

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


}
