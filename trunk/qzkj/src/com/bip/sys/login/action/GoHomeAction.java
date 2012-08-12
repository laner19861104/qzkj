package com.bip.sys.login.action;

import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class GoHomeAction extends baseAction {
	public String goHome() {
		return "success";
	}
}
