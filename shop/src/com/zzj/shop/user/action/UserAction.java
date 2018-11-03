package com.zzj.shop.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zzj.shop.user.service.UserService;
import com.zzj.shop.user.vo.User;


/**
 * �û�ģ���action��
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
	 * ��ת��ע��ҳ���ִ�з���
	 * @return
	 */
	public String registerPage()
	{
		return "registerPage";
	}
	
	/**
	 * ajax�첽У���û���
	 */
	public String findByName()
	{
		User existUser=userService.findByName(user.getUsername());
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		//�û����Ѿ�����
		if(existUser!=null)
		{
			
			try {
				response.getWriter().println("�û����Ѿ�����");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//�û���������
		else
		{
			
			try {
				response.getWriter().println("�û�������ʹ��");
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
	 * �û�ע��ķ���
	 */
	
	public String register()
	{
		
		userService.save(user);
		this.addActionMessage("ע��ɹ�����ȥ���伤��");
		return "msg";
	}
	
	//�û�����ķ���
	public String active()
	{
		User existUser=userService.findByCode(user.getCode());
		if(existUser==null)
			this.addActionError("����ʧ��");
		else
		{
		   existUser.setState(1);
		   existUser.setCode(null);
		   userService.update(existUser);
		   this.addActionMessage("����ɹ���ȥ��¼");
		   
		}
		return "msg";
	}
	
	//��ת����¼ҳ��
	public String loginPage()
	{
		return "loginPage";
	}
	
	//�û���¼�ķ���
	public String login( )
	{
		User existUser=userService.login(user);
		if(existUser==null)
		{
			this.addActionError("�û�������");
			return LOGIN;
		}
		else
		{
			System.out.println("aa===========");
			ServletActionContext.getRequest().getSession().setAttribute("existUser",existUser);
			return "loginSuccess";
		}
	}
	
	//�û��˳��ķ���
	public String quit()
	{
		ServletActionContext.getRequest().getSession().invalidate();
		return "loginOut";
	}
	
}
