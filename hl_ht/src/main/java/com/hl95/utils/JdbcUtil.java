package com.hl95.utils;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.ResultSetMetaData;  
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.hl95.utils.entity.ContantEntity;  

/**
 * @ClassName: JdbcUtil  
 * @Description: jdbc工具类
 * @author chenYan  
 * @date 2018年5月24日  
 */
public class JdbcUtil {  
  
	@Autowired
	private ContantEntity contantEntity;
	
    // 定义数据库的链接  
    private Connection connection;  
  
    // 定义sql语句的执行对象  
    private PreparedStatement pstmt;
    
    // sql语句的执行对象
    private Statement stmt;
  
    // 定义查询返回的结果集合  
    private ResultSet resultSet;
    
  
    /** 
     * 获取数据库连接 
     *  
     * @return 数据库连接 
     */  
    public Connection getConnection() {  
    	
    	if(connection!=null) {
    		return connection;
    	}
    	
        try { 
           /* Class.forName(contantEntity.getDriverClassName()); // 注册驱动  
            connection = DriverManager.getConnection(contantEntity.getJdbcUrl(), contantEntity.getJdbcUserName(), contantEntity.getJdbcPassWord()); // 获取连接
            */
            Class.forName("com.mysql.jdbc.Driver"); // 注册驱动  
            connection = DriverManager.getConnection("jdbc:mysql://203.195.179.183:18250/hljw", "hljw", "123456"); // 获取连接 
        } catch (Exception e) {  
            throw new RuntimeException("get connection error!", e);  
        }  
        return connection;  
    }  
  
    /** 
     * 执行更新操作 
     *  
     * @param sql 
     *            sql语句 
     * @param params 
     *            执行参数 
     * @return 执行结果 
     * @throws SQLException 
     */  
    public int updateByPreparedStatement(String sql, List<?> params)  
            throws SQLException {  
       
    	int result = -1;// 表示当用户执行添加删除和修改的时候所影响数据库的行数  
        pstmt = connection.prepareStatement(sql);  
        int index = 1;  
        // 填充sql语句中的占位符  
        if (params != null && !params.isEmpty()) {  
            for (int i = 0; i < params.size(); i++) {  
                pstmt.setObject(index++, params.get(i));  
            }  
        }  
        result = pstmt.executeUpdate();  
        
        return result;  
    }  
  
    /** 
     * 执行查询操作 
     *  
     * @param sql 
     *            sql语句 
     * @param params 
     *            执行参数 
     * @return 
     * @throws SQLException 
     */  
    public List<Map<String, Object>> findResult(String sql, List<?> params)  
            throws SQLException {  
    	System.out.println(sql);
    	
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();  
        int index = 1;  
        pstmt = connection.prepareStatement(sql);  
        if (params != null && !params.isEmpty()) {  
            for (int i = 0; i < params.size(); i++) {  
                pstmt.setObject(index++, params.get(i));  
            }  
        }  
        resultSet = pstmt.executeQuery();  
        ResultSetMetaData metaData = resultSet.getMetaData();  
        int cols_len = metaData.getColumnCount();  
        while (resultSet.next()) {  
            Map<String, Object> map = new HashMap<String, Object>();  
            for (int i = 0; i < cols_len; i++) {  
                String cols_name = metaData.getColumnName(i + 1);  
                Object cols_value = resultSet.getObject(cols_name);  
                if (cols_value == null) {  
                    cols_value = "";  
                }  
                map.put(cols_name, cols_value);  
            }  
            list.add(map);  
        }  
        return list;  
    }  
    /** 
     * 执行查询操作 
     *  
     * @param sql 
     *            sql语句 
     * @param params 
     *            执行参数 
     * @return 
     * @throws SQLException 
     */  
    public List<Map<String, Object>> findResult(String sql)throws SQLException {  
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();  
        stmt = connection.createStatement();
        		
        resultSet = stmt.executeQuery(sql);  
        ResultSetMetaData metaData = resultSet.getMetaData();  
        int cols_len = metaData.getColumnCount();  
        while (resultSet.next()) {  
            Map<String, Object> map = new HashMap<String, Object>();  
            for (int i = 0; i < cols_len; i++) {  
                String cols_name = metaData.getColumnName(i + 1);  
                Object cols_value = resultSet.getObject(cols_name);  
                if (cols_value == null) {  
                    cols_value = "";  
                }  
                map.put(cols_name, cols_value);  
            }  
            list.add(map);  
        }  
        return list;  
    }  
  
    /** 
     * 释放资源 
     */  
    public void releaseConn() {  
        if (resultSet != null) {  
            try {  
                resultSet.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }  
        if (pstmt != null) {  
            try {  
                pstmt.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }  
        if (stmt != null) {  
            try {  
            	stmt.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }  
        if (connection != null) {  
            try {  
                connection.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
  
    public static void main(String[] args) {  
        JdbcUtil jdbcUtil = new JdbcUtil();  
        jdbcUtil.getConnection();  
        try {  
            List<Map<String, Object>> result = jdbcUtil.findResult(  
                    "select * from sms_send_base", null);  
            
            System.out.println("大小="+result.size());
            for (Map<String, Object> m : result) {  
                System.out.println(m);  
            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } finally {  
            jdbcUtil.releaseConn();  
        }  
    }

	public ContantEntity getContantEntity() {
		return contantEntity;
	}

	public void setContantEntity(ContantEntity contantEntity) {
		this.contantEntity = contantEntity;
	}  
    
}  