/**
 * @(#)AdapterMessage.java Created on 2007-8-6 ����08:40:05
 * 
 * ��Ȩ����Ȩ���� bsoft.com.cn ��������Ȩ����
 */
package com.bip.common.service;

import java.io.Serializable;

/**
 * ��ת��<code>Adapter</code>��������� �κε�����Ϣ��������ת��Ϊ����
 * 
 * @author <a href="mailto:yanrubin@126.com">yanrubin</a>
 * 
 */
public class AdapterCall extends AdapterPart implements Serializable {

    private static final long serialVersionUID = -4762768126524580971L;

    /**
     * ��������Ϣ��ʶ��
     */
    private String refMsgId = null;

    /**
     * ����ģʽ�� ͬ�������첽
     */
    private String crfCallMode = null;

    /**
     * ���õ�Ŀ������ʶ������Ҫ�����Ĳ�������
     */
    private String logicService = null;

//    /**
//     * ���õ�Ŀ��������ڵ�Ӧ�ñ�ʶ��
//     */
//    private String targetLogicApp = null;

    /**
     * �ôε��õı�ʶ��
     */
    private String callId = null;

    /**
     * ������body��ʶ��
     */
    private String bodyId = null;

    /**
     * �õ�����ģʽ��
     * 
     * @return ����ģʽ��
     */
    public String getCrfCallMode() {
        return crfCallMode;
    }

    /**
     * ���õ���ģʽ��
     * 
     * @param crfCallMode
     *            ����ģʽ��
     */
    public void setCrfCallMode(String crfCallMode) {
        this.crfCallMode = crfCallMode;
    }

    /**
     * �õ����õı�ʶ��
     * 
     * @return ���ñ�ʶ��
     */
    public String getCallId() {
        return callId;
    }

    /**
     * ���õ��ñ�ʶ��
     * 
     * @param callId
     *            ���ñ�ʶ��
     */
    public void setCallId(String callId) {
        this.callId = callId;
    }



    /**
	 * @return the logicService
	 */
	public String getLogicService() {
		return logicService;
	}

	/**
	 * @param logicService the logicService to set
	 */
	public void setLogicService(String logicService) {
		this.logicService = logicService;
	}

	/**
     * �õ�body�ı�ʶ��
     * 
     * @return body��ʶ��
     */
    public String getBodyId() {
        return bodyId;
    }

    /**
     * ����body��ʶ��
     * 
     * @param bodyId
     *            body��ʶ��
     */
    public void setBodyId(String bodyId) {
        this.bodyId = bodyId;
    }

    /**
     * �õ���������Ϣ��ʶ��
     * 
     * @return ��������Ϣ��ʶ��
     */
    public String getRefMsgId() {
        return refMsgId;
    }

    /**
     * ���ù�������Ϣ��ʶ��
     * 
     * @param refMsgId
     *            ��������Ϣ��ʶ��
     */
    public void setRefMsgId(String refMsgId) {
        this.refMsgId = refMsgId;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("AdapterCall").append(", refMsgId[").append(
                getRefMsgId()).append("], crfCallMode[").append(
                getCrfCallMode()).append("], targetLogicService[").append(
                getLogicService()).append("], encodedBody[").append(
                getEncodedBody()).append("], bodyId[").append(getBodyId())
                .append("].");
        return sb.toString();
    }

}
