package com.bip.main;

import java.sql.*;
import java.io.*;

import com.bip.common.util.Tool;

import oracle.sql.*;
public class WriteBlob {

  public static void main(String[] args) {

    try {
      DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());;
      Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.117.110:1521:WFZF","qzkj","qzkj");
      conn.setAutoCommit(false);;

      BLOB blob = null;

      PreparedStatement pstmt = conn.prepareStatement("insert into sys_file(uuid,content,name) values(?,empty_blob(),?)");
      String uuid=Tool.getStringUUid();
      pstmt.setString(1,uuid);
      pstmt.setString(2, "test.flv");
      pstmt.executeUpdate();
      pstmt.close();

      pstmt = conn.prepareStatement("select content from sys_file where uuid= ? for update");
      pstmt.setString(1,uuid);
      ResultSet rset = pstmt.executeQuery();;
      if (rset.next())
    	  blob = (BLOB)rset.getBlob(1);;

      String fileName = "test.flv";
      File f = new File("C://Documents and Settings//Administrator//桌面//FlvPlayer201002//FlvPlayer201002//"+fileName);
      FileInputStream fin = new FileInputStream(f);;
      System.out.println("file size = " + fin.available());

      pstmt = conn.prepareStatement("update sys_file set content=? where uuid=?");;

      OutputStream out = blob.getBinaryOutputStream();;

      int count = -1, total = 0;
      byte[] data = new byte[(int)fin.available()];
      fin.read(data);;
      out.write(data);;
      /*
      byte[] data = new byte[blob.getBufferSize();];  另一种实现方法,节省内存
      while ((count = fin.read(data);); != -1); {
        total += count;
        out.write(data, 0, count);;
      }
      */

      fin.close();;
      out.close();;

      pstmt.setBlob(1,blob);;
      pstmt.setString(2,uuid);

      pstmt.executeUpdate();;
      pstmt.close();;

      conn.commit();;
      conn.close();;
    } catch (SQLException e) {
      System.err.println(e.getMessage());;
      e.printStackTrace();
    } catch (IOException e) {
      System.err.println(e.getMessage());;
    }
  }

}