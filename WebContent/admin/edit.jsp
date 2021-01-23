<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
	String contextPath = request.getContextPath();
	pageContext.setAttribute("contextPath", contextPath);
%>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Title</title>
    <link rel="stylesheet" href="${contextPath }/admin/css/style.css" type="text/css" />
    <link rel="stylesheet" href="${contextPath }/admin/css/amazeui.min.css" />
</head>
<body>
<div class="main_top">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">修改商品</strong><small></small></div>
    </div>
    <hr>
	
    <div class="edit_content">
		<form action="${contextPath }/GoodsServlet?action=editServlet&currentPage=${currentPage}" method="post" id="edit_form" style="background: none; width: 700px;">
			<div class="item1">
			<input type="text" name="gid" value="${goods.gid }" style="display: none">
            <div>
                <span>商品名称：</span>
                <input type="text" class="am-form-field" name="gname" value="${goods.gname }">&nbsp;&nbsp;
            </div>
            <div>
                <span>商品价格：</span>
                <input type="text" class="am-form-field" name="gprice" value="${goods.gprice }">
            </div>

        </div>

        <div class="item1">
        	<div>
        		<span>所属分类：</span>
                 <select id="categorySel" name="cid">
                 	<c:forEach items="${allCategory }" var="category">
                 	 <option value="${category.cid }">${category.cname }</option>
                 	</c:forEach>
                 </select>
                 &nbsp;
        	</div>
        	
        	<div>
        		<span>是否热门：</span>
                 <select id="isHotSel" name="gis_hot">
                    <option value="0">否</option>
                     <option value="1">是</option>
                 </select>
        	</div>        
                 
        </div>

        <div class="item1">
                <span>商品图片：</span>
                <input type="file" name="gimage"/>
        </div>
        
        <div class="item1 item_desc">
            <span>商品描述：</span>
         <textarea  id="gdesc" name="gdesc" rows="4" cols="50">${goods.gdesc }</textarea>
        </div>
        <button class="am-btn am-btn-default" type="button" id="edit">更新</button>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <button class="am-btn am-btn-default" type="button" id="reset">重置</button>
		</form>
   </div>

</div>

<script src="${contextPath }/admin/js/jquery.min.js"></script>

<script>

	$(function(){
		
		 $("#edit").click(function () {
		        //让表单提交 editServlet
		        //获取表单  让其提交
		        $("#edit_form").submit();
		    });
		 
		 // 让分类和热门的value值被选中
		 $("#categorySel option[value=${goods.cid}]").prop("selected", true);
		 $("#isHotSel option[value=${goods.gis_hot}]").prop("selected", true);
		 
	});
</script>
</body>
</html>