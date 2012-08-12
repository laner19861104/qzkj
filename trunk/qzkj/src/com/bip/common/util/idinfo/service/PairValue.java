package com.bip.common.util.idinfo.service;

/*********************************************
 * <p>Module:PairValue.java</p>
 * <p>Description:数据对，加密使用</p>
 * <p>Copyright: Copyright (c) 2008</p>
 * <p>Company: </p>
 * <p>author: zhaosy zhaosy_1022@163.com </p>
 * <p>version: version 1.0 </p>
 ********************************************/


public class PairValue {
  public long min;
  public long max;

  public PairValue()
  {
  }
  public PairValue(long $min, long $max)
  {
    min = $min;
    max = $max;
  }
}