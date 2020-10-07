package devepkm.dao;


import devepkm.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: dev
 * @Date: 20/9/2020 18:35
 * @Description: BaseDao<T> for all Dao class to extends, it contain basic CRUD methods
 */
public abstract class BaseDao<T> {


    private QueryRunner runner = new QueryRunner();

    private Class clazz = null;

    {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        clazz = (Class) actualTypeArguments[0];
    }

    /**
     * @param sql  Sql Statement
     * @param args args for PreparedStatement
     * @return number of updated row, -1 if not success
     */
    public int update(String sql, Object... args) {

        Connection conn = JdbcUtils.getConnection();

        try {
            return runner.update(conn, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }

        return -1;

    }

    /**
     * @param sql  Sql Statement
     * @param args args for PreparedStatement
     * @return a Bean obj
     */
    public T queryForOne(String sql, Object... args) {
        Connection conn = JdbcUtils.getConnection();
        ResultSetHandler<T> handler = new BeanHandler<>(clazz);
        T rs = null;
        try {
            rs = runner.query(conn,sql, handler, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return rs;
    }


    /**
     * @param sql  Sql Statement
     * @param args args for PreparedStatement
     * @return a List of Bean obj
     */
    public List<T> queryForList(String sql, Object... args) {
        Connection conn = JdbcUtils.getConnection();
        BeanListHandler<T> listHandler = new BeanListHandler<>(clazz);
        List<T> rs = null;

        try {
            rs = runner.query(conn, sql, listHandler, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return rs;

    }


}
