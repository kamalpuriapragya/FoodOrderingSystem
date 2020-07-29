package com.universal.db;

import java.sql.Connection;

import java.sql.DriverManager;

public class DbConnection implements DbProperties{
static Connection con;
public static Connection getConnection(){
if(con==null){
   try{
    Class.forName(DRIVER);
    con=DriverManager.getConnection(URL,USERNAME,PASSWORD);

   }catch(Exception e){
       e.printStackTrace();
   }
   
}
return con;
}
}
