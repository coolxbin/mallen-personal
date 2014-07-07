package com.huangzb.test.dbunit;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

public class LoadDbToXmlTest {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://192.168.1.110:3306/mallen-personal", "root", "root");

		IDatabaseConnection connection = new DatabaseConnection(conn);
		QueryDataSet dataSet = new QueryDataSet(connection);
		// 将整个person表里的数据导出到 xml文件里
		dataSet.addTable("person");
		// 将users表里符合条件的数据导出到xml文件里
		dataSet.addTable("users", "select * from users where id < 4");
		// 导出到dbunit.xml文件里
		FlatXmlDataSet.write(dataSet, new FileOutputStream("D:/dbunit.xml"));
		
		//如果想把某个数据库里的所有表里的数据全部导出到某个xml里,又不想通过addTable一个个来添加的话。则必须通过IDatabaseConnection的createDataSet()来创建IDataSet  
        //IDataSet dataSet = connection.createDataSet();  
        //导出到dbunit.xml文件里  
       // FlatXmlDataSet.write(dataSet,new FileOutputStream("dbunit1.xml"));  
        //也可以用FlatDtdDataSet导出一个对应的dtd文件  
        //FlatDtdDataSet.write(dataSet,new FileOutputStream("dbunit1.dtd"));  
	}
}
