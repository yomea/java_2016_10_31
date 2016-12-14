/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2016-12-04 12:33:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Java后端WebSocket的Tomcat实现</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    Welcome<br/><input id=\"text\" type=\"text\"/>\r\n");
      out.write("    <button onclick=\"send()\">发送消息</button>\r\n");
      out.write("    <hr/>\r\n");
      out.write("    <button onclick=\"closeWebSocket()\">关闭WebSocket连接</button>\r\n");
      out.write("    <hr/>\r\n");
      out.write("    <div id=\"message\"></div>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    var websocket = null;\r\n");
      out.write("    //判断当前浏览器是否支持WebSocket\r\n");
      out.write("    if ('WebSocket' in window) {\r\n");
      out.write("    \t//ws://localhost:8080/websocket访问后台，ws是websocket的协议\r\n");
      out.write("        websocket = new WebSocket(\"ws://localhost:8080/websocket\");\r\n");
      out.write("    }\r\n");
      out.write("    else {\r\n");
      out.write("        alert('当前浏览器 Not support websocket')\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    //连接发生错误的回调方法\r\n");
      out.write("    websocket.onerror = function () {\r\n");
      out.write("        setMessageInnerHTML(\"WebSocket连接发生错误\");\r\n");
      out.write("    };\r\n");
      out.write("\r\n");
      out.write("    //连接成功建立的回调方法\r\n");
      out.write("    websocket.onopen = function () {\r\n");
      out.write("        setMessageInnerHTML(\"WebSocket连接成功\");\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    //接收到消息的回调方法\r\n");
      out.write("    websocket.onmessage = function (event) {\r\n");
      out.write("        setMessageInnerHTML(event.data);\r\n");
      out.write("        console.log(event);\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    //连接关闭的回调方法\r\n");
      out.write("    websocket.onclose = function () {\r\n");
      out.write("        setMessageInnerHTML(\"WebSocket连接关闭\");\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。\r\n");
      out.write("    window.onbeforeunload = function () {\r\n");
      out.write("        closeWebSocket();\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    //将消息显示在网页上\r\n");
      out.write("    function setMessageInnerHTML(innerHTML) {\r\n");
      out.write("        document.getElementById('message').innerHTML += innerHTML + '<br/>';\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    //关闭WebSocket连接\r\n");
      out.write("    function closeWebSocket() {\r\n");
      out.write("        websocket.close();\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    //发送消息\r\n");
      out.write("    function send() {\r\n");
      out.write("        var message = document.getElementById('text').value;\r\n");
      out.write("        websocket.send(message);\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
