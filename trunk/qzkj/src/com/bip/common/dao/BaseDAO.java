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
     * �����ݿ����һ����Ӧ��һ��ҵ�����ʵ���ļ�¼ 
     * @param entity 
     *            ҵ�����ʵ�� 
     * @throws DaoException 
     */ 
    public boolean create(Object entity)  { 
        try {   
        	super.getHibernateTemplate().save(entity);
        	return true;
        } catch (Exception e) { 
            System.out.println("���� " + entity.getClass().getName() + " ʵ�������ݿ�ʧ��"+e);
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
     * ���һ��session        
     */ 
    public Session openSession() {
   	        return SessionFactoryUtils.getSession(super.getHibernateTemplate().getSessionFactory(), false);
    }

	/** 
     * ���Query����       
     */ 
    public Query getQuery(String sql){
        Session session = this.openSession();
        Query query = session.createQuery(sql); 
        return query;
    }
    
    /** 
     * ���Criteria����       
     */
    public Criteria getCriteria(Class clazz){
        
    Session session=this.openSession();
    Criteria criteria = session.createCriteria(clazz);
    return criteria;
    }

    /** 
     * �����ݿ����һ����Ӧ��һ��ҵ�����ʵ���ļ�¼ 
     * 
     * @param entity 
     *            ҵ�����ʵ�� 
     * @throws DaoException 
     *          
     */ 
    public boolean update(Object entity)  { 
        try { 
            super.getHibernateTemplate().update(entity); 
            return true;
        } catch (Exception e) { 
            System.out.println("���� " + entity.getClass().getName() + " ʵ�������ݿ�ʧ��"+e); 
           return false;
        } 
    } 

    /** 
     * �����ݿ�ɾ��һ����Ӧ��һ��ҵ�����ļ�¼ 
     * 
     * @param entity 
     *            ҵ�����ʵ�� 
     * @throws DaoException 
     *         
     */ 
    public boolean delete(Object entity)  { 
        try { 
            super.getHibernateTemplate().delete(entity); 
            return true;
        } catch (Exception e) { 
            System.out.println("�����ݿ�ɾ�� " + entity.getClass().getName() + " ʵ��ʧ��"+e); 
            return false;
        } 
    } 
    /** 
     * �����ݿ�ɾ�����ж�Ӧ��һ��ҵ�����ļ�¼ 
     * @param clazz 
     *            ָ�����͵�ҵ����� 
     * @throws DaoException        
     */ 
    public boolean deleteAll(Class clazz) { 
        try { 
            List result = super.getHibernateTemplate().loadAll(clazz); 
            super.getHibernateTemplate().deleteAll(result); 
            return true;
        } catch (Exception e) { 
            System.out.println("�����ݿ�ɾ�� " + clazz.getName() + " �����м�¼ʧ��"+ e); 
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
     * �����ݿ��ѯһ��ҵ���������Լ�¼ 
     * @param clazz 
     *            ָ�����͵�ҵ�����  
     */ 
    public List LoadAll(Class clazz){
        List list=null;
        try{
               list=super.getHibernateTemplate().loadAll(clazz);
        }catch(Exception e){
           System.out.println("�����ݿ��ѯ"+clazz.getName()+"ʧ��");
       }
        return list;
    }
    
    
    /** 
     * ���ݹؼ��ִ����ݿ����ָ�����͵�ҵ����� 
     * 
     * @param clazz 
     *            ҵ������Class 
     * @param keyName 
     *            ָ���ؼ��ֶ�Ӧ���ֶ����� 
     * @param keyValue 
     *            ָ���ؼ��ֵ�ֵ 
     * @return <ul> 
     *         <li>���ؼ���Ψһ�����ڸü�¼ʱ�����ظü�¼��Ӧ��ҵ�����</li> 
     *         <li>���ؼ��ֲ�Ψһ�����ز�ѯ����ĵ�һ����¼����Ӧ��ҵ�����</li> 
     *         <li>�������ڸü�¼ʱ,����null</li> 
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
     * ����������ѯΨһ���ݶ��� 
     * 
     * @param clazz 
     *            ҵ������Class 
     * @return ���ز�ѯ���������ҵ����� 
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
     * ���ݲ�ѯ����ѯ���ݿⲢ���ز�ѯ�����������ҵ����󼯺ϡ� 
     * 
     * @param queryString 
     *            ָ����ѯ��� 
     * @return ���ز�ѯ���������ҵ����󼯺� 
     * @throws DaoException 
     *      
     */ 
    public List find(String queryString)  {
    	List list =null;
        try { 
            list= super.getHibernateTemplate().find(queryString); 
        } catch (Exception e) { 
            System.out.println("ִ�в�ѯ " + queryString + " ʧ��"+e); 
       } 
        return list;
    } 


    /** 
     * ���ݴ�һ�������Ĳ�ѯ����ѯ���ݿⲢ���ز�ѯ�����������ҵ����󼯺ϡ� 
     * 
     * @param queryString 
     *            ָ����ѯ��� 
     * @param param 
     *            ָ���������� 
     * @return ���ز�ѯ���������ҵ����󼯺� 
     * @throws DaoException 
     *            ������ѯʧ��ʱ��??���?? 
     */ 
    public List find(String queryString, Object param)  { 
    	List list= null;
        try { 
            list = super.getHibernateTemplate().find(queryString, param); 
        } catch (Exception e) { 
            System.out.println("ִ�в���Ϊ " + param + " �Ĳ�ѯ " + queryString + " ʧ��"+e); 
        } 
        return list;
    } 

    
    /** 
     * ���ݴ���������Ĳ�ѯ����ѯ���ݿⲢ���ز�ѯ�����������ҵ����󼯺ϡ� 
     * 
     * @param queryString 
     *            ָ����ѯ��� 
     * @param params 
     *            ָ���������� 
     * @return ���ز�ѯ���������ҵ����󼯺� 
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
            System.out.println("ִ�в���Ϊ " + paramString + "�Ĳ�ѯ " + queryString + " ʧ��"+e); 
           
        }
        return list;
    } 

}
