package com.bip.common.page;
import java.util.List;    
   
public class PageModel {    
   
    /**   
     * �ܼ�¼��   
     */   
    private int total;    
    /**   
     * ��ǰҳ�ļ�¼��   
     */   
    private List datas;    
   
    public List getDatas() {    
        return datas;    
    }    
   
    public void setDatas(List datas) {    
        this.datas = datas;    
    }    
   
    public int getTotal() {    
        return total;    
    }    
   
    public void setTotal(int total) {    
        this.total = total;    
    }    
}  
