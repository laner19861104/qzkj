package com.bip.common.page;
import java.util.List;    
   
public class PageModel {    
   
    /**   
     * 总记录数   
     */   
    private int total;    
    /**   
     * 当前页的记录集   
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
