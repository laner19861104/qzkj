package com.bip.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bip.common.action.baseAction;
import com.bip.common.upload.service.JocFileService;
@Controller
public class PlayerAction extends baseAction{
	private JocFileService jocFileService;
	
	public String entryPlayer()
	{
	return "success";
	}
	public String getMovie()
	{
		String uuid=this.getRequest().getParameter("name");
		this.getRequest().setAttribute("file",this.jocFileService.get(uuid));
		return "success";
	}
	@Autowired
	public void setJocFileService(JocFileService jocFileService) {
		this.jocFileService = jocFileService;
	}
}
