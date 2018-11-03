package com.zzj.shop.adminuser.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zzj.shop.adminuser.service.AdminUserService;
import com.zzj.shop.adminuser.vo.AdminUser;

public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser> {

	
	private AdminUser adminUser=new AdminUser();
	
	//ע��serverice��
	private AdminUserService adminUserService;
	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}
	@Override
	public AdminUser getModel() {
		// TODO Auto-generated method stub
		return adminUser;
	}
	
	
	//��̨��¼�ķ���
	public String login()
	{
		
		AdminUser existAdminUser=adminUserService.login(adminUser);
		if(existAdminUser==null)
		{
			//��¼ʧ��
			this.addActionError("�û������������");
			return "loginFail";
		}
		
		ServletActionContext.getRequest().getSession().setAttribute("existAdminUser", existAdminUser);
		return "loginSuccess";
	}

}
