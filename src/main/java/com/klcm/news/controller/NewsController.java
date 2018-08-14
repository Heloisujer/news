package com.klcm.news.controller;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.klcm.news.pojo.Message;
import com.klcm.news.pojo.News;
import com.klcm.news.service.NewsService;
import com.klcm.news.utils.UpUtils;

/**
 * 新闻信息控制层
 * @author 王雨婷
 *
 */
@Controller
@RequestMapping("/newss")
public class NewsController {
	
	@Resource
	private NewsService newsService;
	
	@RequestMapping("/findAll")
	public ModelAndView findAll(){
		ModelAndView mav=new ModelAndView();
		List<News> newss = newsService.findAll();
		mav.setViewName("/news.jsp");
		mav.addObject("newss", newss);
		return mav;
	}
	
	@RequestMapping("/findByLike")
	public ModelAndView findByLike(String title) {
		ModelAndView mav =new ModelAndView();
		List<News> newss=newsService.findByLike(title);
		mav.setViewName("/news.jsp");
	    mav.addObject("newss",newss);
	    return mav;
	   }
	
	@RequestMapping("/addNews")
	@ResponseBody
	private Message addNews(News news,String type,MultipartFile file,HttpServletRequest request) {
		try {
			
			Message msg=newsService.addNews(news,type,file,request);
			return msg;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Message msg=new Message();
			msg.setMsg("操作异常！");
			return msg;
			
		}
	}
	
	@RequestMapping("/updateNews")
	@ResponseBody
	public Message updateNews(News news,String type,MultipartFile file,HttpServletRequest request) {
		try {
			Message msg = newsService.updateNews(news,type,file,request);
	        return msg;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Message msg=new Message();
			msg.setMsg("操作异常");
			return msg;
			
		}
				
	}
	
	@RequestMapping("/deleteNews")
	@ResponseBody
	public Message deleteNews(String nId) {
		try {
			Message msg = newsService.deleteById(nId);
			return msg;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Message msg = new Message();
			msg.setMsg("操作异常！");
			return msg;
		}				
	}
	
	
	@RequestMapping("/up")
	public void upImage(MultipartFile file,HttpServletRequest request) {
		
		String imgPath=UpUtils.upfile(file,request);
		System.out.println(imgPath);
	}
	

  }
