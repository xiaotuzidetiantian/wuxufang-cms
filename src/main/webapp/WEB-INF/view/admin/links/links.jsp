<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>友情链接</title>
<!-- ?? css -->
<link rel="stylesheet" type="text/css" 
href="/resource/css/bootstrap.css">
<!-- ??js -->
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript">

	function add() {
		$("#center").load("/admin/links/add");
	}
	
	function goPage(page) {
		var url = "/admin/links/selects?page="+page;
		//在中间区域加载分页页面
		$("#center").load(url);
	}
</script>
</head>
<body>
	
	<div style="text-align: center">
		<table class="table table-hover table-bordered">
			<thead class="thead-light">
				<tr>
					<th>序号</th>
					<th>链接名称</th>
					<th>url</th>
					<th>创建时间</th>
					<th>操作<button class="btn btn-info" onclick="add()">增加链接</button></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${info.list }" var="l" varStatus="i">
					<tr>
						<td>${(info.pageNum-1) * info.pageSize+i.index+1 }</td>
						<td>${l.text }</td>
						<td>${l.url }</td>
						<td>
							<fmt:formatDate value="${l.created }" pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
						<td>
							<a href="${l.url }">浏览</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>