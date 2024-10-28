package com.TripilarProject.filehandling.excel;

import java.io.FileInputStream;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class ReadExcelFile {
  public static void main(String args[]) {
	  String file="C:\\Users\\Rahul\\OneDrive\\Desktop\\iuyt.xlsx";
	  String jdbcURL = "jdbc:mysql://localhost:3306/user_data";
      String username = "root";
      String password = "Rahul.mysql";
      String stmt="INSERT INTO user (id, name, branch) VALUES (?, ?, ?)";
      try {
    	  
      FileInputStream fileInputStream = new FileInputStream(file);
      Workbook workbook = new XSSFWorkbook(fileInputStream);
      Connection connection = DriverManager.getConnection(jdbcURL, username, password);
      PreparedStatement psmt=connection.prepareStatement(stmt);
      Sheet sheet=workbook.getSheetAt(0);
      Iterator<Row> iteratorRow=sheet.iterator();
      if(iteratorRow.hasNext())iteratorRow.next();
      while(iteratorRow.hasNext()) {
    	  Row row=iteratorRow.next();
    	  
    		  int id=(int)row.getCell(0).getNumericCellValue();
    		  String name = row.getCell(1).getStringCellValue();
              String branch = row.getCell(2).getStringCellValue();
              psmt.setInt(1, id);
              psmt.setString(2, name);
              psmt.setString(3, branch);
              psmt.executeUpdate();
      }
      System.out.println("Data imported from Excel to database successfully.");

      } catch (IOException e) {
          e.printStackTrace();
      } catch (SQLException e) {
          e.printStackTrace();
      }
      }
}
