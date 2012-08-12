
    $.extend($.fn.validatebox.defaults.rules, {
           custom_reg: {
            validator: function(value, param) {
                var m_reg = new RegExp(param[0]); 
                if (!m_reg.test(value)) {
                    $.fn.validatebox.defaults.rules.custom_reg.message = param[1];
                    return false;
                }
                else {
                    return true;
                }
            },
            message: ''
        },
     minLength: {   
       validator: function(value, param){   
            return value.length >= param[0];   
        },   
        message: '最少输入{0}个字符'  
    },
    maxLength: {   
       validator: function(value, param){   
            return value.length <= param[0];   
        },   
        message: '最多输入{0}个字符'  
    }   
       });