package com.bip.common.service;

import java.io.Serializable;

public class AdapterPart implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -3964282370538561969L;

    /**
     * �Ѿ�����Ϊstring�ĵ������ݡ�
     */
    private String encodedBody = null;

    /**
     * body������
     */
    private String charset = null;

    /**
     * �Ƿ�ѹ��
     */
    private boolean compression = false;

    /**
     * ���ܷ�����
     */
    private String cryptType = null;

    /**
     * ǩ������
     */
    private String signType = null;

    /**
     * ǩ���Ľ����
     */
    private String signValue = null;

    public AdapterPart() {
        super();
    }

    /**
     * �õ��Ѿ������body��
     * 
     * @return �Ѿ������body��
     */
    public String getEncodedBody() {
        return encodedBody;
    }

    /**
     * �����Ѿ������body��
     * 
     * @param encodedBody
     *            �Ѿ������body��
     */
    public void setEncodedBody(String encodedBody) {
        this.encodedBody = encodedBody;
    }

    /**
     * �õ�body���ַ����롣
     * 
     * @return body���ַ����롣
     */
    public String getCharset() {
        return charset;
    }

    /**
     * ����body���ַ����롣
     * 
     * @param charset
     *            body���ַ����롣
     */
    public void setCharset(String charset) {
        this.charset = charset;
    }

    /**
     * �Ƿ�ѹ����
     * 
     * @return true-�Ѿ�ѹ����false��û��ѹ����
     */
    public boolean isCompression() {
        return compression;
    }

    /**
     * �����Ƿ�ѹ����
     * 
     * @param compression
     *            true���Ѿ�ѹ����false��û��ѹ����
     */
    public void setCompression(boolean compression) {
        this.compression = compression;
    }

    /**
     * �õ�ǩ����ʽ��
     * 
     * @return ǩ����ʽ��
     */
    public String getCryptType() {
        return cryptType;
    }

    /**
     * ����ǩ����ʽ��
     * 
     * @param cryptType
     *            ǩ����ʽ��
     */
    public void setCryptType(String cryptType) {
        this.cryptType = cryptType;
    }

    /**
     * �õ�ǩ����ʽ��
     * 
     * @return ǩ����ʽ��
     */
    public String getSignType() {
        return signType;
    }

    /**
     * ����ǩ�����
     * 
     * @param signType
     *            ǩ�����
     */
    public void setSignType(String signType) {
        this.signType = signType;
    }

    /**
     * �õ�ǩ����ֵ��
     * 
     * @return ǩ����ֵ��
     */
    public String getSignValue() {
        return signValue;
    }

    /**
     * ����ǩ����ֵ��
     * 
     * @param signValue
     *            ǩ����ֵ��
     */
    public void setSignValue(String signValue) {
        this.signValue = signValue;
    }

}