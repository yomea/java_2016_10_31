<!-- 自定义tag标签块 -->
<%@tag pageEncoding="UTF-8" body-content="scriptless" dynamic-attributes="true" %>
<!-- 定义这个标签的属性 -->
<%@attribute name="a" rtexprvalue="false" required="true" type="java.lang.String"%>
<!-- 为JSP页面定义变量 -->
<%@variable name-given="test" scope="AT_BEGIN" %>
<jsp:useBean id="date" class="java.util.Date"></jsp:useBean>

<!-- 调用这个标签表示执行标签体,如果是直接输出就不要定义任何其他的属性，否则容易出错 -->
<jsp:doBody/>
${date.day } + ${a }日

