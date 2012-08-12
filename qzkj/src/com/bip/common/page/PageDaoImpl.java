package com.bip.common.page;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PageDaoImpl extends HibernateDaoSupport implements Page {    
	   
 
        
    public PageModel findAllList(String tableName,int offset, int pagesize) {    
            
        //�õ��ܼ�¼��    
    	
    	
        String queryCountHql = "select count(*) from "+tableName;    
            
        Query query = getSession().createQuery(queryCountHql);    
        int total = ((Long)query.uniqueResult()).intValue();    
            
        String queryList = " from "+tableName;
        
        List datas = getSession().createQuery(queryList)    
                    .setFirstResult(offset)    
                    .setMaxResults(pagesize)    
                    .list();    
        //�õ������    
        PageModel pm = new PageModel();    
        pm.setTotal(total);    
        pm.setDatas(datas);    
            
        return pm;    
    }

  
   
}  
