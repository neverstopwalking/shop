package com.zzj.shop.category.vo;

import java.util.Set;

import com.zzj.shop.categorysecond.vo.CategorySecond;

/**
 * һ�������ʵ�������
 * @author zhouz
 *
 */

public class Category {
	
	  private Integer cid;
	  private String cname;
	  //��������ļ���
	  private Set<CategorySecond> categorySeconds;
  public Set<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}
	public void setCategorySeconds(Set<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}
public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}

}
