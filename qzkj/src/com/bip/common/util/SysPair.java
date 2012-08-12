package com.bip.common.util;

/*********************************************
 * <p>Module:SysPair.java</p>
 * <p>Description:Êý¾Ý¶Ô</p>
 * <p>Copyright: Copyright (c) 2008</p>
 * <p>Company: </p>
 * <p>author: zhaosy zhaosy_1022@163.com </p>
 * <p>version: version 1.0 </p>
 ********************************************/

import java.util.*;
import java.io.Serializable;
public class SysPair
    implements Serializable {
  private int val;
  private String def;
  private int parentVal;
  private String parentDef;
  private String url;

  public SysPair(int val, String def, int parentVal, String parentDef,String url) {
    this.val = val;
    this.def = def;
    this.parentVal = parentVal;
    this.parentDef = parentDef;
    this.url=url;

  }

  public void setVal(int val) {
    this.val = val;
  }

  public int getVal() {
    return val;
  }

  public void setDef(String def) {
    this.def = def;
  }

  public String getDef() {
    return def;
  }

  public void setParentVal(int parentVal) {
    this.parentVal = parentVal;
  }

  public int getParentVal() {
    return parentVal;
  }

  public void setParentDef(String parentDef) {
    this.parentDef = parentDef;
  }

  public String getParentDef() {
    return parentDef;
  }
  public void setUrl(String url) {
     this.url = url;
   }

   public String getUrl() {
     return url;
   }

  public String toString() {
    return new String("{attrVal = " + val + "; attrDef = " + def +
                      ";attrParentVal=" + parentVal + ";attrParentDef=" +
                      parentDef + ";url="+url+"}");
  }
}