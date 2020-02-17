<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
	<title></title>
<!-- 引入 css -->
<link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap.css">
<!-- 引入js -->
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript">

function goPage(page){
	$("#center").load("/my/article/collects?page="+page)
}

</script>
</head>

<body>
    
	<c:forEach items="${info.list}" var="selectByTitleAndUserId">
		<div class="media">
			<img src="/pic/${selectByTitleAndUserId.picture}"
				class="align-self-center mr-3 rounded" alt="..." width="156px"
				height="101.8">
			<div class="media-body">
				<h5 class="mt-0">${selectByTitleAndUserId.title }
					
				</h5>
				<button type="button" class="btn btn-link"  style="float: right"
						onclick="articleDetail(${selectByTitleAndUserId.id })" data-toggle="modal"
						data-target="#exampleModalLong">详情</button>
				
				<p>${selectByTitleAndUserId.summary }</p>
				<p>
					<fmt:formatDate value="${selectByTitleAndUserId.created }"
						pattern="yyyy-MM-dd HH:mm:ss" />
					0 评论
				</p>
			</div>
		</div>
		<hr>
	</c:forEach>

	<jsp:include page="/WEB-INF/view/common/pages.jsp"></jsp:include>
	</div>


	<!-- Modal -->
	<div class="modal fade" id="exampleModalLong" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLongTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-lg " role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">
						<span id="mytitle"></span>
					</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body" id="articleConent"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
</body>

</html>