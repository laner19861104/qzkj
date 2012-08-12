/**
 * @(#)AdapterResult.java Created on 2007-8-6 下午11:53:52
 * 
 * 版权：版权所有 bsoft.com.cn 保留所有权力。
 */
package com.bip.common.service;

import java.io.Serializable;
import java.util.Date;

/**
 * 从平台返回的结果，已经转换为能够在适配器流装的结果。
 * 
 * @author <a href="mailto:caoxj@bsoft.com.cn">caoxj</a>
 * 
 */
public class AdapterResponse extends AdapterPart implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date timestampCreated = new Date();

    /**
     * 从服务过来的结果代码，默认为0，成功。
     */
    private int code = 0;

    /**
     * 从平台返回的结果描述，默认为空。
     */
    private String descrption = null;

    /**
     * 关联的服务标识。
     */
    private String sourceServiceId = null;

    /**
     * 关联的<code>Call</code>标识。
     */
    private String refCallId = null;

    private String refBodyId = null;

    private String crfResponseMode = null;

    /**
     * 得到返回的结果代码。
     * 
     * @return 返回的结果代码。
     */
    public int getCode() {
        return code;
    }

    /**
     * 设置返回的结果代码。
     * 
     * @param code
     *            返回的结果代码。
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * 得到返回的结果描述。
     * 
     * @return 返回的结果描述。
     */
    public String getDescrption() {
        return descrption;
    }

    /**
     * 设置返回的结果描述。
     * 
     * @param descrption
     *            返回的结果描述。
     */
    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    /**
     * 关联的的调用服务名称。
     * 
     * @return 调用服务名称。
     */
    public String getSourceServiceId() {
        return sourceServiceId;
    }

    /**
     * 关联的调用服务名称。
     * 
     * @param targetServiceId
     *            调用服务名称。
     */
    public void setSourceServiceId(String targetServiceId) {
        this.sourceServiceId = targetServiceId;
    }

    /**
     * 得到关联的<code>Call</code>标识。
     * 
     * @return 关联的<code>Call</code>标识。
     */
    public String getRefCallId() {
        return refCallId;
    }

    /**
     * 设置关联的<code>Call</codE>标识。
     * 
     * @param refCallId
     *            关联的<code>Call</code>标识。
     */
    public void setRefCallId(String refCallId) {
        this.refCallId = refCallId;
    }

   

    /**
     * 设置该<code>AdapterResponse</code>创建的时间。
     * 
     * @return 创建的时间。
     */
    public Date getTimestampCreated() {
        return timestampCreated;
    }

    /**
     * 得到该<code>AdapterResponse</code>创建的时间。
     * 
     * @param timestampCreated
     *            创建的时间。
     */
    public void setTimestampCreated(Date timestampCreated) {
        this.timestampCreated = timestampCreated;
    }

    public String getRefBodyId() {
        return refBodyId;
    }

    public void setRefBodyId(String refBodyId) {
        this.refBodyId = refBodyId;
    }

    public String getCrfResponseMode() {
        return crfResponseMode;
    }

    public void setCrfResponseMode(String crfResponseMode) {
        this.crfResponseMode = crfResponseMode;
    }

  

    public String toString() {

    	StringBuffer str=new StringBuffer("<?xml version=\"1.0\" encoding=\"GB2312\"?><result>");
    	str.append("<code>").append(this.getCode()).append("</code>");
    	str.append("<description>").append(this.getDescrption()).append("</description>");
    	str.append("<encodebody><![CDATA[").append(this.getEncodedBody()).append("]]></encodebody></result>");

        return str.toString();
        
        
//        "AdapterResponse, code[" + this.getCode() + "], descrption["
//        + this.getDescrption() + "], sourceServiceId["
//        + this.getSourceServiceId() + "],  refCallId["
//        + this.getRefCallId() + "], refBodyId[" + this.getRefBodyId()
//        + "], crfResponseMode[" + this.getCrfResponseMode() + "]."
        
    }
}
