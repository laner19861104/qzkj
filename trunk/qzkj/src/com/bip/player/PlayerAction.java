package com.bip.player;

import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
@Controller
public class PlayerAction extends baseAction{
	public String entryPlayer()
	{
	return "success";
	}
	public String getMovie()
	{
		String uuid=this.getRequest().getParameter("uuid");
		return "success";
	}
}
