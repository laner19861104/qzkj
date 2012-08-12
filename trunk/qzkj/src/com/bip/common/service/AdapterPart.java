package com.bip.common.service;

import java.io.Serializable;

public class AdapterPart implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -3964282370538561969L;

    /**
     * 已经编码为string的调用数据。
     */
    private String encodedBody = null;

    /**
     * body的属性
     */
    private String charset = null;

    /**
     * 是否压缩
     */
    private boolean compression = false;

    /**
     * 加密方法。
     */
    private String cryptType = null;

    /**
     * 签名方法
     */
    private String signType = null;

    /**
     * 签名的结果。
     */
    private String signValue = null;

    public AdapterPart() {
        super();
    }

    /**
     * 得到已经编码的body。
     * 
     * @return 已经编码的body。
     */
    public String getEncodedBody() {
        return encodedBody;
    }

    /**
     * 设置已经编码的body。
     * 
     * @param encodedBody
     *            已经编码的body。
     */
    public void setEncodedBody(String encodedBody) {
        this.encodedBody = encodedBody;
    }

    /**
     * 得到body的字符编码。
     * 
     * @return body的字符编码。
     */
    public String getCharset() {
        return charset;
    }

    /**
     * 设置body的字符编码。
     * 
     * @param charset
     *            body的字符编码。
     */
    public void setCharset(String charset) {
        this.charset = charset;
    }

    /**
     * 是否压缩。
     * 
     * @return true-已经压缩；false－没有压缩。
     */
    public boolean isCompression() {
        return compression;
    }

    /**
     * 设置是否压缩。
     * 
     * @param compression
     *            true－已经压缩；false－没有压缩。
     */
    public void setCompression(boolean compression) {
        this.compression = compression;
    }

    /**
     * 得到签名方式。
     * 
     * @return 签名方式。
     */
    public String getCryptType() {
        return cryptType;
    }

    /**
     * 设置签名方式。
     * 
     * @param cryptType
     *            签名方式。
     */
    public void setCryptType(String cryptType) {
        this.cryptType = cryptType;
    }

    /**
     * 得到签名方式。
     * 
     * @return 签名方式。
     */
    public String getSignType() {
        return signType;
    }

    /**
     * 设置签名类别。
     * 
     * @param signType
     *            签名类别。
     */
    public void setSignType(String signType) {
        this.signType = signType;
    }

    /**
     * 得到签名的值。
     * 
     * @return 签名的值。
     */
    public String getSignValue() {
        return signValue;
    }

    /**
     * 设置签名的值。
     * 
     * @param signValue
     *            签名的值。
     */
    public void setSignValue(String signValue) {
        this.signValue = signValue;
    }

}