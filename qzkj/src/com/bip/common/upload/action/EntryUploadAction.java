package com.bip.common.upload.action;

import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;

@Controller
public class EntryUploadAction extends baseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5144044616174172820L;

	public String entry() {
		return "success";
	}
}
