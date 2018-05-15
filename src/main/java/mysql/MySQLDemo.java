package mysql;

import java.sql.*;
import java.util.ArrayList;

public class MySQLDemo {
    /*
       // JDBC 驱动名及数据库 URL
       static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
       static final String DB_URL = "jdbc:mysql://localhost:3306/mysql";

       // 数据库的用户名与密码，需要根据自己的设置
       static final String USER = "root";
       static final String PASS = "123456";

       public static void main(String[] args) {
           Connection conn = null;
           Statement stmt = null;
           try{
               // 注册 JDBC 驱动
               Class.forName("com.mysql.jdbc.Driver");

               // 打开链接
               System.out.println("连接数据库...");
               conn = DriverManager.getConnection(DB_URL,USER,PASS);

               // 执行查询
               System.out.println(" 实例化Statement对象...");
               stmt = conn.createStatement();
               String sql;
               sql = "SELECT id, name, url FROM websites";
               ResultSet rs = stmt.executeQuery(sql);

               // 展开结果集数据库
               while(rs.next()){
                   // 通过字段检索
                   int id  = rs.getInt("id");
                   String name = rs.getString("name");
                   String url = rs.getString("url");

                   // 输出数据
                   System.out.print("ID: " + id);
                   System.out.print(", 站点名称: " + name);
                   System.out.print(", 站点 URL: " + url);
                   System.out.print("\n");
               }
               // 完成后关闭
               rs.close();
               stmt.close();
               conn.close();
           }catch(SQLException se){
               // 处理 JDBC 错误
               se.printStackTrace();
           }catch(Exception e){
               // 处理 Class.forName 错误
               e.printStackTrace();
           }finally{
               // 关闭资源
               try{
                   if(stmt!=null) stmt.close();
               }catch(SQLException se2){
               }// 什么都不做
               try{
                   if(conn!=null) conn.close();
               }catch(SQLException se){
                   se.printStackTrace();
               }
           }
           System.out.println("Goodbye!");
       }*/
    public static void main(String[] args) {
        /*Connection con;
        Statement sql;
        ResultSet rs;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        try {
            String url = "jdbc:mysql://localhost:3306/MySql"; *//* jdbc:mysql:// + 数据库地址/数据库名称*//*
            String username = "root";
            String password = "123456";
            con = DriverManager.getConnection(url, username, password);
            sql = con.createStatement();
            rs = sql.executeQuery("SELECT * FROM  students");
            ArrayList<String> ar = new ArrayList<String>();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                int javascore = rs.getInt(3);
                if (javascore >= 60) {
                    ar.add(id + " " + name + " " + String.valueOf(javascore));
                }
            }
            System.out.println("java及格人数" + ar.size());
            for (int i = 0; i < ar.size(); i++) {
                System.out.println(ar.get(i));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }*/
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
// mysql驱动
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/MySql",
                    "root", "123456");

            Statement ps = (Statement) con.createStatement();
            String sql = "select * from user";
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
// 循环输出结果集
                String account = rs.getString("User");
                System.out.println("User:" + account);
                String Host = rs.getString("Host");
                System.out.println("Host:" + Host);
            }
        } catch (Exception e) {
            System.out.println("MYSQL error----" + e.getMessage());
        }
    }
}