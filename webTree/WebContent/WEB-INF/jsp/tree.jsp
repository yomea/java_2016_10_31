<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>tree</title>

<script src="<%=path %>/js/jquery-1.8.1.min.js" type="text/javascript"></script>

<style type="text/css">

*{
	margin:0;
	padding:0;
}

ul {
	list-style-type:none;
}

ul li {
	height:50px;
	line-height:50px;
	text-indent:20px;
	
}

.main{
	width:800px;
	
	margin:0 auto;	
    
	background:#0F0;
	
}

</style>

<script type="text/javascript">
	$(document).ready(function() {
		var currentPage = 1;
		var id = 0;
		
        function gainData(page, size, idValue) {
        	$.ajax({
    			url:"http://localhost:8888/webTree/tree",	
    			data:{pageNum:page, pageSize:size, id:idValue},
    			type:"POST",
    			cache:false,
    			dataType:"json",
    			success: function(data, textStatus){
    				tree(data);
    			}
    		});
        	
        }
		
        gainData(1, 1, 0);
		
		function tree(data) {
			 if(data.currentPage) {
				
				currentPage = data.currentPage;
			} 
			$.each(data.comments, function(index,element) {
				if(element.pid == 0) {
					id = element.id;
					$(".main ul").append("<li>" + element.content + "</li>");
					
				} else {
					
					$(".main ul").append("<li style='padding-left:20px'>" + element.id + "楼回复" + element.pid + "楼：" + element.content + "</li>");
				}
				if(1 == element.isLeaf) {
					
					tree(element);
				}
				
				
			});
			
			
			
			
			
		}
		$(".main").append("<p class='more' style='cursor:pointer;'>更多</p>");
		$(".more").on('click', function() {
			gainData(currentPage+1, 1, id);
		});
		
    });

</script>

</head>

<body>
	<div class="main">
    	<ul>
        	
        </ul>
    	
    </div>


</body>
</html>