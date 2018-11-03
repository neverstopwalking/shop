package com.zzj.shop.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zzj.shop.user.service.UserService;
import com.zzj.shop.user.vo.User;


/**
 * 用户模块的action类
 * @author zhouz
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
  
	  private User user=new User();
	  
	  public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private UserService userService;
	/**
	 * 跳转到注册页面的执行方法
	 * @return
	 */
	public String registerPage()
	{
		return "registerPage";
	}
	
	/**
	 * ajax异步校验用户名
	 */
	public String findByName()
	{
		User existUser=userService.findByName(user.getUsername());
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		//用户名已经存在
		if(existUser!=null)
		{
			
			try {
				response.getWriter().println("用户名已经存在");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//用户名不存在
		else
		{
			
			try {
				response.getWriter().println("用户名可以使用");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return NONE;
		
		
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	/**
	 * 用户注册的方法
	 */
	
	public String register()
	{
		
		userService.save(user);
		this.addActionMessage("注册成功，请去邮箱激活");
		return "msg";
	}
	
	//用户激活的方法
	public String active()
	{
		User existUser=userService.findByCode(user.getCode());
		if(existUser==null)
			this.addActionError("激活失败");
		else
		{
		   existUser.setState(1);
		   existUser.setCode(null);
		   userService.update(existUser);
		   this.addActionMessage("激活成功请去登录");
		   
		}
		return "msg";
	}
	
	//跳转到登录页面
	public String loginPage()
	{
		return "loginPage";
	}
	
	//用户登录的方法
	public String login( )
	{
		User existUser=userService.login(user);
		if(existUser==null)
		{
			this.addActionError("用户不存在");
			return LOGIN;
		}
		else
		{
			System.out.println("aa===========");
			ServletActionContext.getRequest().getSession().setAttribute("existUser",existUser);
			return "loginSuccess";
		}
	}
	
	//用户退出的方法
	public String quit()
	{
		ServletActionContext.getRequest().getSession().invalidate();
		return "loginOut";
	}
	
}
