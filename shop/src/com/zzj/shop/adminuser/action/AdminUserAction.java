package com.zzj.shop.adminuser.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zzj.shop.adminuser.service.AdminUserService;
import com.zzj.shop.adminuser.vo.AdminUser;

public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser> {

	
	private AdminUser adminUser=new AdminUser();
	
	//注入serverice层
	private AdminUserService adminUserService;
	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}
	@Override
	public AdminUser getModel() {
		// TODO Auto-generated method stub
		return adminUser;
	}
	
	
	//后台登录的方法
	public String login()
	{
		
		AdminUser existAdminUser=adminUserService.login(adminUser);
		if(existAdminUser==null)
		{
			//登录失败
			this.addActionError("用户名或密码错误");
			return "loginFail";
		}
		
		ServletActionContext.getRequest().getSession().setAttribute("existAdminUser", existAdminUser);
		return "loginSuccess";
	}

}
