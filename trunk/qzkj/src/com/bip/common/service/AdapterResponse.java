/**
 * @(#)AdapterResult.java Created on 2007-8-6 ����11:53:52
 * 
 * ��Ȩ����Ȩ���� bsoft.com.cn ��������Ȩ����
 */
package com.bip.common.service;

import java.io.Serializable;
import java.util.Date;

/**
 * ��ƽ̨���صĽ�����Ѿ�ת��Ϊ�ܹ�����������װ�Ľ����
 * 
 * @author <a href="mailto:caoxj@bsoft.com.cn">caoxj</a>
 * 
 */
public class AdapterResponse extends AdapterPart implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date timestampCreated = new Date();

    /**
     * �ӷ�������Ľ�����룬Ĭ��Ϊ0���ɹ���
     */
    private int code = 0;

    /**
     * ��ƽ̨���صĽ��������Ĭ��Ϊ�ա�
     */
    private String descrption = null;

    /**
     * �����ķ����ʶ��
     */
    private String sourceServiceId = null;

    /**
     * ������<code>Call</code>��ʶ��
     */
    private String refCallId = null;

    private String refBodyId = null;

    private String crfResponseMode = null;

    /**
     * �õ����صĽ�����롣
     * 
     * @return ���صĽ�����롣
     */
    public int getCode() {
        return code;
    }

    /**
     * ���÷��صĽ�����롣
     * 
     * @param code
     *            ���صĽ�����롣
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * �õ����صĽ��������
     * 
     * @return ���صĽ��������
     */
    public String getDescrption() {
        return descrption;
    }

    /**
     * ���÷��صĽ��������
     * 
     * @param descrption
     *            ���صĽ��������
     */
    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    /**
     * �����ĵĵ��÷������ơ�
     * 
     * @return ���÷������ơ�
     */
    public String getSourceServiceId() {
        return sourceServiceId;
    }

    /**
     * �����ĵ��÷������ơ�
     * 
     * @param targetServiceId
     *            ���÷������ơ�
     */
    public void setSourceServiceId(String targetServiceId) {
        this.sourceServiceId = targetServiceId;
    }

    /**
     * �õ�������<code>Call</code>��ʶ��
     * 
     * @return ������<code>Call</code>��ʶ��
     */
    public String getRefCallId() {
        return refCallId;
    }

    /**
     * ���ù�����<code>Call</codE>��ʶ��
     * 
     * @param refCallId
     *            ������<code>Call</code>��ʶ��
     */
    public void setRefCallId(String refCallId) {
        this.refCallId = refCallId;
    }

   

    /**
     * ���ø�<code>AdapterResponse</code>������ʱ�䡣
     * 
     * @return ������ʱ�䡣
     */
    public Date getTimestampCreated() {
        return timestampCreated;
    }

    /**
     * �õ���<code>AdapterResponse</code>������ʱ�䡣
     * 
     * @param timestampCreated
     *            ������ʱ�䡣
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
