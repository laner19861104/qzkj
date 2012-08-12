/**
 * @(#)AdapterMessage.java Created on 2007-8-6 下午08:40:05
 * 
 * 版权：版权所有 bsoft.com.cn 保留所有权力。
 */
package com.bip.common.service;

import java.io.Serializable;

/**
 * 流转在<code>Adapter</code>里面的请求。 任何调用信息都是现在转换为请求。
 * 
 * @author <a href="mailto:yanrubin@126.com">yanrubin</a>
 * 
 */
public class AdapterCall extends AdapterPart implements Serializable {

    private static final long serialVersionUID = -4762768126524580971L;

    /**
     * 关联的消息标识。
     */
    private String refMsgId = null;

    /**
     * 调用模式。 同步还是异步
     */
    private String crfCallMode = null;

    /**
     * 调用的目标服务标识。就是要请求哪部分数据
     */
    private String logicService = null;

//    /**
//     * 调用的目标服务所在的应用标识。
//     */
//    private String targetLogicApp = null;

    /**
     * 该次调用的标识。
     */
    private String callId = null;

    /**
     * 关联的body标识。
     */
    private String bodyId = null;

    /**
     * 得到调用模式。
     * 
     * @return 调用模式。
     */
    public String getCrfCallMode() {
        return crfCallMode;
    }

    /**
     * 设置调用模式。
     * 
     * @param crfCallMode
     *            调用模式。
     */
    public void setCrfCallMode(String crfCallMode) {
        this.crfCallMode = crfCallMode;
    }

    /**
     * 得到调用的标识。
     * 
     * @return 调用标识。
     */
    public String getCallId() {
        return callId;
    }

    /**
     * 设置调用标识。
     * 
     * @param callId
     *            调用标识。
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
     * 得到body的标识。
     * 
     * @return body标识。
     */
    public String getBodyId() {
        return bodyId;
    }

    /**
     * 设置body标识。
     * 
     * @param bodyId
     *            body标识。
     */
    public void setBodyId(String bodyId) {
        this.bodyId = bodyId;
    }

    /**
     * 得到关联的消息标识。
     * 
     * @return 关联的消息标识。
     */
    public String getRefMsgId() {
        return refMsgId;
    }

    /**
     * 设置关联的消息标识。
     * 
     * @param refMsgId
     *            关联的消息标识。
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
