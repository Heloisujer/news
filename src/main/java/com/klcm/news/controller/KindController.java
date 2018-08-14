package com.klcm.news.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.klcm.news.pojo.Kind;
import com.klcm.news.pojo.Message;
import com.klcm.news.service.KindService;

/**
 * 新闻分类控制层
 * @author 王雨婷
 *
 */
@Controller
@RequestMapping("/kinds")
public class KindController {
	@Resource
	private KindService kindService;
	
	@RequestMapping("/findAll")
	public ModelAndView findAll() {
		ModelAndView mav=new ModelAndView();
		List<Kind> kinds=kindService.findAll();
		mav.addObject("kinds",kinds);
		mav.setViewName("/newsKind.jsp");
		return mav;
	}
	
	@RequestMapping("/addKind")
	@ResponseBody
	public Message addKind(Kind kind) {
		try {			
			Message msg=kindService.addKind(kind);
			return msg;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Message msg=new Message();
			msg.setMsg("操作异常！");
			return msg;
		}		
	}
	
	@RequestMapping("/updateKind")
	@ResponseBody
	public Message updateKind(Kind kind) {
		try {
			Message msg =kindService.updateKind(kind);
			return msg;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Message msg=new Message();
			msg.setMsg("操作异常！");
			return msg;
		}
		
	}
	
	@RequestMapping("/deleteKind")
	@ResponseBody
	public Message deleteKind(String kId) {
		try {
			
			Message msg  =	kindService.deleteById(kId);
			return  msg;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Message msg=new Message();
			msg.setMsg("操作异常！！");
			return msg;
		}
	
	}

}
