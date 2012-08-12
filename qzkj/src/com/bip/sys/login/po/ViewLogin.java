package com.bip.sys.login.po;



/**
 * ViewLogin entity. @author MyEclipse Persistence Tools
 */

public class ViewLogin  implements java.io.Serializable {


    // Fields    

     private ViewLoginId id;


    // Constructors

    /** default constructor */
    public ViewLogin() {
    }

    
    /** full constructor */
    public ViewLogin(ViewLoginId id) {
        this.id = id;
    }

   
    // Property accessors

    public ViewLoginId getId() {
        return this.id;
    }
    
    public void setId(ViewLoginId id) {
        this.id = id;
    }
   








}