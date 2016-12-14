<%@page import="java.util.Locale"%>
<%@page import="java.util.Currency"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstl test</title>
</head>
<body>
	<jsp:useBean id="date" class="java.util.Date" scope="page"></jsp:useBean>
	<jsp:useBean id="d" beanName="一般写一个持久化后的ser文件.ser" type="java.util.Date"></jsp:useBean>
	<jsp:include page="/WEB-INF/jsp/index.jsp" flush="false">
		<jsp:param value="给index的page页面传递参数" name=""/>
	</jsp:include>
	<jsp:element name=""></jsp:element>
	<jsp:forward page="转发">
		<jsp:param value="" name=""/>
	</jsp:forward>
	<jsp:output doctype-public="<meta charset=''utf-8>" doctype-root-element="html" doctype-system="" omit-xml-declaration="no"></jsp:output>
	<!-- 自定义标签 -->
	<com:JspFragment>
	<!-- 一般用于JSPFragment类型的属性，定义的标签的jspfragment为TRUE -->
	<jsp:attribute name="jspFragment1">
		<jsp:getProperty name="date" property="year" ></jsp:getProperty>年<br />
	</jsp:attribute>
	<jsp:attribute name="jspFragment2">
		<jsp:getProperty name="date" property="month" ></jsp:getProperty>月<br />
	</jsp:attribute>
	<!-- 定义了JSP：attribute时定义标签体，必须用JSP：body了包裹 -->
	<jsp:body>
		<jsp:getProperty name="date" property="day"></jsp:getProperty>日<br />
	</jsp:body>
</com:JspFragment>
<jsp:getProperty property="year" name="date"/>
<jsp:params>
	<jsp:param value="" name=""/>
	<jsp:param value="" name=""/>
</jsp:params>
<jsp:plugin code="" codebase="" type="bean">
用于Java的applet应用，现在已经淘汰了，不用去纠结它
</jsp:plugin>
<jsp:element name="hello" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	生成一个叫hello的标签，如：<hello></hello>
</jsp:element>
	
	
	
	
	
	
	
	
	
	<!-- context表示相同服务器下的不同的web应用 -->
	<c:url value="http://www.baidu.com" context="" scope="" var="">
		<c:param name="" value=""></c:param>
	</c:url>
	<!-- varReader指将当前的URL的资源用一个reader流 -->
	<c:import url="http://www.baidu.com" context="同服务器下的不同的web应用名，如/jstl" charEncoding="UTF-8" varReader="reader" scope="page">
		<c:param name="">给http://www.baidu.com传递参数</c:param>
	</c:import>
	<c:redirect url="" context=""></c:redirect>
	<c:set property="Javabean中的属性名" scope="" target="写javaBean的ID值" value="" var=""></c:set>
	<c:catch var="">
		在这里写标签，如果标签出行异常，就会catch到异常，并且将异常对象存到var定义的属性名
	
	</c:catch>
	<c:forTokens items="java,jsp,servlet,spring,struts,springmvc,hibernate,mybatis" delims="," begin="" end="" step="" var="" varStatus="定义一个属性值来存储循环的状态对象">
		${varStatus.count }得到循环了多少次
		${varStatus.first }boolean值，表示是否为第一次循环
		${varStatus.last }boolean值，表示是否为最后一次循环
		${varStatus.begin }得到开始的下标，如果没有定义那么就是null
		${varStatus.end }得到结束时的下标，如果没有定义那么就是null
		${varStatus.index }得到当前循环的下标
		${varStatus.step }得到循环的步数
		${varStatus.current }得到当前循环到的对象
	</c:forTokens>
	<c:forEach items="其中有些参数的意义与c:forTokens一样"></c:forEach>
	<c:when test="${1 eq 1 }">
		<c:choose></c:choose>
		<c:otherwise></c:otherwise>
	</c:when>
	
	<c:if test="${1 gt 2 }" scope="" var=""></c:if>
	
	<c:out value="helloworld" default="" escapeXml="true">
		它的值也可以在这里写
	</c:out>
	<c:remove var="写要删除的属性的名字" scope="删除那个范围的属性"/>
	
	
	
	
	
	
	
	
	
	
	<fmt:setLocale value="可以是Locale对象，也可以是字符串信息，如zh_CN,en_US" scope="" variant=""/>
	<fmt:setBundle basename="国际化资源的基名" scope="" var="test将bundle对象存在这个属性名称中"/>
	<fmt:message bundle="${test }" key="国际化资源里的key" var="" scope="">
		<fmt:param value="这里设置国际化占位符的值"></fmt:param>
	</fmt:message>
	<fmt:setTimeZone value="可以是java.util.TimeZone的对象，也可以是字符串，它会使用java.util.TimeZone.getTimeZone('')得到这个实例"  scope="将设置的TimeZone对象存在那个范围" var="timeZone"/>
	<fmt:parseDate dateStyle="long" parseLocale="String或者java.util.Locale" pattern="yyyy-MM-dd HH:mm:ss" scope="" timeStyle="short" timeZone="${timeZone }" type="both, date, time表示解析哪部分，是date还是time，还是俩部分都解析" value="${date }" var="dateStr"></fmt:parseDate>
	<fmt:parseNumber integerOnly="如果为TRUE则只解析整数部分" parseLocale="String或者java.util.Locale" pattern="指定一个自定义的格式输出，如果指定这个属性，那么type将失去作用，必须符合java.text.DecimalFormat如：###.#00##" scope="request" type="货币还是百分数" value="134.54" var=""></fmt:parseNumber>
	<%
			String currencyCode = Currency.getInstance(Locale.CHINA).getCurrencyCode(); 
			String currencySymbol = Currency.getInstance(Locale.CHINA).getSymbol();
			pageContext.setAttribute("currencyCode", currencyCode);
			pageContext.setAttribute("currencySymbol", currencySymbol);
	%>
	<fmt:formatNumber currencyCode="${currencyCode }指定货币编码符号，只在当前type为currency的时候有效" currencySymbol="${currencySymbol }指定货币的表示符号，如果定义了currencyCode，那么以currencyCode优先" groupingUsed="指定格式化的数值是否使用组分隔符" maxFractionDigits="指定最大的小数位个数" maxIntegerDigits="指定最大的整数位数" minFractionDigits="指定最小的小数位个数" minIntegerDigits="指定最小的整数位数" pattern="指定解析格式" scope="" type="currency或者是百分比" value="21.23" var=""></fmt:formatNumber>
	<fmt:requestEncoding value="charsetName" />相当于request.setCharacterEncoding("charsetName"),这个标签一般在使用request对象中值前面定义
	<fmt:timeZone value="可以是java.util.TimeZone的对象，也可以是字符串，它会使用java.util.TimeZone.getTimeZone('')得到这个实例">
		这样设置的TimeZone只能在当前标签中使用
		<fmt:formatDate pattern="定义格式化成的时间模式yyyy-MM-dd HH:mm:ss定义了这个将会忽略type，dateStyle，timeStyle属性，这个pattern必须符合SimpleDateFormat的语法" value="${date日期值 }" dateStyle="full, short, meduid, long模式" type="both, date, time三个值，这个可以用eclipse按住Ctrl点进去查看他的定义" />
	</fmt:timeZone>
	<fmt:formatDate value=""/>
	<fmt:bundle basename="国际化资源的基名" prefix="会给标签体的fmt:message标签的key向前追加这里定义的字符">
		<fmt:message key=""></fmt:message>
		<fmt:param>定义占位符的值</fmt:param>
		这样创建的bundle只能在标签体内使用	
	</fmt:bundle>
	
	
	
	
	
	<sql:transaction dataSource="数据源" isolation="事物的隔离机制">
	<sql:setDataSource dataSource="指定数据源，如果这个标签在SQLtransaction中，则无需写如果为String则是JNDI数据源的名称，也可以是具体的数据源对象" driver="com.jdbc.mysql.Driver" user="root" password="root" scope="page" url="jdbc:mysql://localhost:3306/test" var="dataSource"/>
	<sql:query var="result" dataSource="指定数据源，如果在SQLtransaction中则不能再指定数据源" maxRows="" scope="" sql="select * from t_user" startRow="">
		<c:forEach items="${result.rows }" var="rs">
			<c:out value="${rs.username }"></c:out>
		</c:forEach>
	
	</sql:query>
	
	</sql:transaction>
	<sql:update dataSource="java/mysql" scope="application" sql="update t_user set username='hong' where id=1" var="">
		也可以在标签体重指定SQL语句，如
		insert into t_user values(null, 'may', 22, current_timestamp);
		DELET FROM t_user WHERE id = 1;
		如：
		CREATE table `t_person` (
			`id` INT AUTO_INCREMENT COMMENT '主键',
			`person_name` VARCHAR(20) NOT NULL,
			`person_password` VARCHAR(20) NOT NULL,
			PRIMARY KEY(id),
			KEY `KEY_ID`(id)
		)ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=UTF-8;
	</sql:update>
	<sql:query var="" dataSource="" maxRows="" scope="" sql="" startRow="">
		select * from t_user where birthday = ? and name = ?;
		<sql:dateParam value="${date }"/>
		<sql:param value="%o%"></sql:param>
	
	</sql:query>
	
	
	
	
	
	定义一个XML文件如：
	<!-- 
	<?xml version="1.0" encoding="UTF-8"?>
	<books>
		<book>
			<name id="1">Spring Boot</name>
			<author>Craig Walls</author>
		</book>
		<book>
			<name id="2">深入体验Java Web开发内幕--高级特性</name>
			<author>张孝祥 王建英 方立勋</author>
		</book>
	
	</books>
	
	
	 -->
	<h3>xml标签组</h3>
	<c:import url="books.xml" charEncoding="utf-8" var="b"></c:import>
	<x:parse doc="${b }" var="book"></x:parse>
	<x:parse var="b">
		<a>
			<b>直接在x：parse标签中定义XML标签</b>
		</a>
	</x:parse>
	<x:choose>
		<x:when select="$book//book"></x:when>
		<x:otherwise></x:otherwise>
	</x:choose>
	<x:if select="$book/books/book"></x:if>
	<x:forEach select="$book//book">
		<x:out select="name"/>
		<x:out select="author"/>
	</x:forEach>
	<x:set var="hello" scope="" select="$book//name[@id=1]"/><!-- 将book标签中属性为1的设置为这里设置的值 -->
	<c:import url="books.xml" charEncoding="" var="xml"></c:import>
	<c:import url="books.xsl" charEncoding=""  var="xsl"></c:import>
	<x:transform doc="${xml }"  xslt="${xsl }">直接输出
	
	</x:transform>
	
</body>
</html>