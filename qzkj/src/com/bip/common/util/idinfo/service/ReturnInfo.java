package com.bip.common.util.idinfo.service;

/*********************************************
 * <p>Module:ReturnInfo.java</p>
 * <p>Description:返回值</p>
 * <p>Copyright: Copyright (c) 2008</p>
 * <p>Company: </p>
 * <p>author: zhaosy zhaosy_1022@163.com </p>
 * <p>version: version 1.0 </p>
 ********************************************/
import java.io.Serializable;

public class ReturnInfo implements java.io.Serializable
{

   /**
    * 操作成功与否的标志
    */
   private boolean flag;
   private String info;
   private String code;


   public ReturnInfo() {}

   /**
    * ReturnInfo overload constructor
    * @param nflag new flag
    * @param ncode new code
    * @param ninfo new info
    */
   public ReturnInfo(boolean nflag, String ncode, String ninfo)
   {
     this.flag = nflag;
     this.info = ninfo;
     this.code = ncode;
   }

   /**
    * 设置flag
    * @param newFlag
    * @roseuid 3D75874401F0
    */
   public void setFlag(boolean newFlag)
   {
    flag=newFlag;
   }

   /**
    * 获得flag
    * @return flag
    * @roseuid 3D7587440204
    */
   public boolean getFlag()
   {
    return flag;
   }

   /**
    * 设置信息
    * @param newInfo
    * @roseuid 3D758744020E
    */
   public void setInfo(String newInfo)
   {
    info=newInfo;
   }

   /**
    * 获得信息
    * @return info
    * @roseuid 3D7587440219
    */
   public String getInfo()
   {
    return info;
   }

   /**
    * 设置代码
    * @param newCode
    * @roseuid 3D7587440222
    */
   public void setCode(String newCode)
   {
    code=newCode;
   }

   /**
    * 获得代码
    * @return code
    * @roseuid 3D7587440236
    */
   public String getCode()
   {
    return code;
   }


   public String toString()
   {
     String temp="";
     temp=temp+"flag:"+flag+"\tcode:"+code+"\tinfo:"+info+"\n";
     return temp;
   }
}
