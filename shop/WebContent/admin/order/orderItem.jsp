<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<table border="0" width="100%">
<s:iterator var="orderItem" value="list">
		<tr>
		    <td><img alt="" width="40" height="50" src="${pageContext.request.contextPath}/<s:property value="#orderItem.product.image"/>"></td>
		    <td><s:property value="#orderItem.count"/></td>
		    <td><s:property value="#orderItem.subTotal"/></td>
		
		</tr>
</s:iterator>
</table>