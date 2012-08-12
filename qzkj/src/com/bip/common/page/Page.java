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
     * @param offset  从第几条记录开始查询   
     * @param pagesize  每页显示多少条记录   
     * @return   
     */   
    public PageModel findAllList(String tableName,int offset, int pagesize);    

}
