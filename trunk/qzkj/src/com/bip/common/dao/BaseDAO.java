package com.bip.common.dao;


import java.util.*;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

public class BaseDAO extends MapDataDao implements IBaseDAO{
    

	/** 
     * 向数据库添加一条对应于一个业务对象实例的记录 
     * @param entity 
     *            业务对象实例 
     * @throws DaoException 
     */ 
    public boolean create(Object entity)  { 
        try {   
        	super.getHibernateTemplate().save(entity);
        	return true;
        } catch (Exception e) { 
            System.out.println("保存 " + entity.getClass().getName() + " 实例到数据库失败"+e);
            return false;
        } 
    } 
    public List findByPage(DetachedCriteria dc,int start,int end)
	{
    	List listpage=this.getHibernateTemplate().findByCriteria(dc, start, end);
    	return listpage;
	}
    public List ListDeptInfor(DetachedCriteria dc) throws HibernateException{
    	List lists= this.getHibernateTemplate().findByCriteria(dc);
		return lists;
    	}
	/** 
     * 获得一个session        
     */ 
    public Session openSession() {
   	        return SessionFactoryUtils.getSession(super.getHibernateTemplate().getSessionFactory(), false);
    }

	/** 
     * 获得Query对象       
     */ 
    public Query getQuery(String sql){
        Session session = this.openSession();
        Query query = session.createQuery(sql); 
        return query;
    }
    
    /** 
     * 获得Criteria对象       
     */
    public Criteria getCriteria(Class clazz){
        
    Session session=this.openSession();
    Criteria criteria = session.createCriteria(clazz);
    return criteria;
    }

    /** 
     * 向数据库更新一条对应于一个业务对象实例的记录 
     * 
     * @param entity 
     *            业务对象实例 
     * @throws DaoException 
     *          
     */ 
    public boolean update(Object entity)  { 
        try { 
            super.getHibernateTemplate().update(entity); 
            return true;
        } catch (Exception e) { 
            System.out.println("更新 " + entity.getClass().getName() + " 实例到数据库失败"+e); 
           return false;
        } 
    } 

    /** 
     * 从数据库删除一条对应于一个业务对象的记录 
     * 
     * @param entity 
     *            业务对象实例 
     * @throws DaoException 
     *         
     */ 
    public boolean delete(Object entity)  { 
        try { 
            super.getHibernateTemplate().delete(entity); 
            return true;
        } catch (Exception e) { 
            System.out.println("从数据库删除 " + entity.getClass().getName() + " 实例失败"+e); 
            return false;
        } 
    } 
    /** 
     * 从数据库删除所有对应于一个业务对象的记录 
     * @param clazz 
     *            指定类型的业务对象 
     * @throws DaoException        
     */ 
    public boolean deleteAll(Class clazz) { 
        try { 
            List result = super.getHibernateTemplate().loadAll(clazz); 
            super.getHibernateTemplate().deleteAll(result); 
            return true;
        } catch (Exception e) { 
            System.out.println("从数据库删除 " + clazz.getName() + " 的所有记录失败"+ e); 
           return false;
        } 
    } 

    public boolean deleteAll(Collection entities) { 
        try { 
            super.getHibernateTemplate().deleteAll(entities);
            return true;
        } catch(Exception e) { 
           return false;
        } 
    } 
    /** 
     * 从数据库查询一个业务对象的所以记录 
     * @param clazz 
     *            指定类型的业务对象  
     */ 
    public List LoadAll(Class clazz){
        List list=null;
        try{
               list=super.getHibernateTemplate().loadAll(clazz);
        }catch(Exception e){
           System.out.println("从数据库查询"+clazz.getName()+"失败");
       }
        return list;
    }
    
    
    /** 
     * 根据关键字从数据库加载指定类型的业务对象。 
     * 
     * @param clazz 
     *            业务对象的Class 
     * @param keyName 
     *            指定关键字对应的字段名称 
     * @param keyValue 
     *            指定关键字的值 
     * @return <ul> 
     *         <li>当关键字唯一并存在该记录时，返回该记录对应的业务对象</li> 
     *         <li>当关键字不唯一，返回查询结果的第一条记录所对应的业务对象</li> 
     *         <li>当不存在该记录时,返回null</li> 
     *         </ul> 
     * @throws DaoException 
     *         
     */ 
    public Object loadByKey(Class clazz, String keyName, Object keyValue) 
            { 
      
            List result = super.getHibernateTemplate().find( 
                    "from " + clazz.getName() + " where " + keyName + " = ?", 
                    keyValue); 
            if (result != null && result.size() > 0) { 
                return result.get(0); 
            } else { 
                return null; 
            }
     }
    
    /** 
     * 根据主键查询唯一数据对象。 
     * 
     * @param clazz 
     *            业务对象的Class 
     * @return 返回查询结果包含的业务对象 
     * @throws DaoException 
     *           
     */ 
    public Object getByPk(Class clazz,Integer id){        
      Object obj = (Object)super.getHibernateTemplate().get(clazz,id);
      return obj;
    
    }
    public Object getByPk(Class clazz,Long id){
      Object obj = (Object)super.getHibernateTemplate().get(clazz,id);
      return obj;
    }
    public Object getByPk(Class clazz,String id){
      Object obj = (Object)super.getHibernateTemplate().get(clazz,id);
      return obj;
    }
    
    /** 
     * 根据查询语句查询数据库并返回查询结果所包含的业务对象集合。 
     * 
     * @param queryString 
     *            指定查询语句 
     * @return 返回查询结果包含的业务对象集合 
     * @throws DaoException 
     *      
     */ 
    public List find(String queryString)  {
    	List list =null;
        try { 
            list= super.getHibernateTemplate().find(queryString); 
        } catch (Exception e) { 
            System.out.println("执行查询 " + queryString + " 失败"+e); 
       } 
        return list;
    } 


    /** 
     * 根据带一个参数的查询语句查询数据库并返回查询结果所包含的业务对象集合。 
     * 
     * @param queryString 
     *            指定查询语句 
     * @param param 
     *            指定所带参数 
     * @return 返回查询结果包含的业务对象集合 
     * @throws DaoException 
     *            牭±查询失败时抛??鲆斐?? 
     */ 
    public List find(String queryString, Object param)  { 
    	List list= null;
        try { 
            list = super.getHibernateTemplate().find(queryString, param); 
        } catch (Exception e) { 
            System.out.println("执行参数为 " + param + " 的查询 " + queryString + " 失败"+e); 
        } 
        return list;
    } 

    
    /** 
     * 根据带多个参数的查询语句查询数据库并返回查询结果所包含的业务对象集合。 
     * 
     * @param queryString 
     *            指定查询语句 
     * @param params 
     *            指定参数数组 
     * @return 返回查询结果包含的业务对象集合 
     * @throws DaoException 
     *       
     */ 
    public List find(String queryString, Object[] params) { 
    	List list= null;
        try { 
            list= super.getHibernateTemplate().find(queryString, params); 
        } catch (Exception e) { 
            StringBuffer paramString = new StringBuffer(""); 
            for (int i = 0; i < params.length; i++) { 
                paramString.append(params[i]); 
                paramString.append(" "); 
            } 
            System.out.println("执行参数为 " + paramString + "的查询 " + queryString + " 失败"+e); 
           
        }
        return list;
    } 

}
