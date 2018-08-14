package com.klcm.news.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.klcm.news.pojo.Message;
import com.klcm.news.pojo.User;
import com.klcm.news.service.UserService;

/**
 * 用户控制层
 * 
 * @author 王雨婷
 *
 */
@Controller
@RequestMapping("/users")
public class UserController {
	@Resource
	private UserService userService;

	@RequestMapping("/findByLike")
	public ModelAndView findByLike(String uName) {
		ModelAndView mav = new ModelAndView();
		User user = userService.findByName(uName);
		List<User> users = new ArrayList<User>();
		users.add(user);
		mav.setViewName("/userList.jsp");
		mav.addObject("users", users);
		return mav;
	}
	
	
	@RequestMapping("/login")
	public ModelAndView login(User user, HttpServletRequest request) {

		System.out.println(90);
		ModelAndView mav = new ModelAndView();
		Message msg = userService.login(user);
		if (msg.getMsg().equals("success")) {

			request.getSession().setAttribute("msg1", msg);
			mav.setViewName("/index.jsp");
			return mav;
		} else {
			mav.addObject("msg1", msg);
			mav.setViewName("/login.jsp");
			return mav;
		}
	}

	@RequestMapping("/findAll")

	public ModelAndView findAll() {
		ModelAndView mav = new ModelAndView();
		List<User> users = userService.findAll();
		mav.addObject("users", users);
		mav.setViewName("/userList.jsp");
		return mav;

	}

	@RequestMapping("/addUser")
	@ResponseBody
	public Message addUser( User user) {
  		try {			
  			Message msg=userService.addUser(user);
  			return msg;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Message msg=new Message();
			msg.setMsg("操作异常!");
			return msg;
		}
  		
      }

	@RequestMapping("/deleteUser")
	@ResponseBody
	public Message deleteUser(String uId) {
		try {
			Message msg = userService.deleteUser(uId);
			return msg;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Message msg = new Message();
			msg.setMsg("操作异常!");
			return msg;
		}
	}

	@RequestMapping("/updateUser")
	@ResponseBody
	public Message updateUser(User user) {
		try {

			Message msg = userService.updateUser(user);
			return msg;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Message msg = new Message();
			msg.setMsg("操作异常!");
			return msg;
		}
	}

	@RequestMapping("/checkPwd")
	@ResponseBody
	public Message checkPwd(String oPwd, HttpSession session) {
		Message msg = (Message) session.getAttribute("msg1");
		User currentUser = msg.getUser();
		Md5Hash md5 = new Md5Hash(oPwd);
		oPwd = md5.toString();
		if (oPwd.equals(currentUser.getuPwd())) {
			msg.setStatus(1);
			msg.setMsg("密码正确！");
		} else {
			msg.setStatus(0);
			msg.setMsg("密码错误！");
		}
		return msg;
	}

	@RequestMapping("/updatePwd")
	@ResponseBody
	public Message updatePwd(String nPwd, String rePwd, HttpSession session) {
		Message msg = new Message();
		if (!nPwd.equals(rePwd)) {
			msg.setStatus(0);
			msg.setMsg("密码输入不一致！");
			return msg;
		}
		Message message2 = (Message) session.getAttribute("msg1");
		User currentUser = message2.getUser();
		try {
			msg = userService.updatePwd(currentUser, nPwd);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus(0);
			msg.setMsg("操作异常！");
		}		
		return msg;
	}
	

}
