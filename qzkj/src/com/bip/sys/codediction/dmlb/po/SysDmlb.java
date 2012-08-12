package com.bip.sys.codediction.dmlb.po;

/**
 * SysDmlb entity. @author MyEclipse Persistence Tools
 */

public class SysDmlb  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String lbbh;
     private String lbmc;


    // Constructors

    /** default constructor */
    public SysDmlb() {
    }

	/** minimal constructor */
    public SysDmlb(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public SysDmlb(Integer id, String lbbh, String lbmc) {
        this.id = id;
        this.lbbh = lbbh;
        this.lbmc = lbmc;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getLbbh() {
        return this.lbbh;
    }
    
    public void setLbbh(String lbbh) {
        this.lbbh = lbbh;
    }

    public String getLbmc() {
        return this.lbmc;
    }
    
    public void setLbmc(String lbmc) {
        this.lbmc = lbmc;
    }
   








}