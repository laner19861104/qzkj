package com.bip.common.util;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */
import java.io.*;
import java.util.logging.Logger;
import java.util.*;

public class IpMac {
  public IpMac() {
  }
  static private final int MACLength = 18;

  private static Logger logger = Logger.getLogger(
      "com.bip.common");
     static public String getMACAddress() {
        SysCommand syscmd = new SysCommand();
        //系统命令
        String cmd = "cmd.exe /c ipconfig/all";
        Vector result;
        result = syscmd.execute(cmd);
        return getCmdStr(result.toString());
    }

    static public String getCmdStr(String outstr) {
        String find = "Physical Address. . . . . . . . . :";
        int findIndex = outstr.indexOf(find);
        if (findIndex == -1) {
            return "未知错误！";
        } else {
            return outstr.substring(findIndex + find.length() + 1, findIndex
                    + find.length() + MACLength);
        }
    }
}

//SysCommand类
class SysCommand {
    Process p;

    public Vector execute(String cmd) {
        try {
            Start(cmd);
            Vector vResult = new Vector();
            DataInputStream in = new DataInputStream(p.getInputStream());
            BufferedReader myReader = new BufferedReader(new InputStreamReader(
                    in));
            String line;
            do {
                line = myReader.readLine();
                if (line == null) {
                    break;
                } else {
                    vResult.addElement(line);
                }
            } while (true);
            myReader.close();
            return vResult;
        } catch (Exception e) {
            return null;

        }

    }

    public void Start(String cmd) {
        try {
            if (p != null) {
                kill();
            }
            Runtime sys = Runtime.getRuntime();
            p = sys.exec(cmd);

        } catch (Exception e) {

        }
    }

    public void kill() {
        if (p != null) {
            p.destroy();
            p = null;
        }
    }

}
