package com.bip.common.page;

/**
 * @description: Interface for the page utils
 * @copyright: Copyright (c) 2009
 * @author hui.wang
 * @version 1.0
 */
public interface Page {

	
    /**   
     *    
     * @param offset  �ӵڼ�����¼��ʼ��ѯ   
     * @param pagesize  ÿҳ��ʾ��������¼   
     * @return   
     */   
    public PageModel findAllList(String tableName,int offset, int pagesize);    

}
