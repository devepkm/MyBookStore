package com.devepkm.test;

import com.devepkm.utils.JdbcUtils;

import java.sql.Connection;

/**
 * @Auther: dev
 * @Date: 20/9/2020 18:21
 * @Description:
 */
public class JdbcUtilsTest {

    @org.junit.Test
    public void getConnection() {
        // since maxconnection is 10, get 100 connection to see if connection is closed

        for (int i = 0; i < 100; i++) {
            Connection conn = JdbcUtils.getConnection();
            System.out.println(conn);
            JdbcUtils.close(conn);
        }

    }


}