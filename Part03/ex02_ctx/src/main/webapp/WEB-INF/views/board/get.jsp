<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include  file="../includes/header.jsp" %>
	<!-- 페이지 콘텐츠 부분 -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Board Read Page</h1>
		</div> <!-- /.col-lg-12 -->
	</div> <!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">Board Read Page</div>
				<div class="panel-body">
					<div class="form-group">
						<label>Bno</label> 
						<input type="text" class="form-control" name="bno" 
							value="<c:out value='${board.bno}'/>" readonly="readonly"/>
					</div>
					<div class="form-group">
						<label>TItle</label> 
						<input type="text" class="form-control" name="title"
							value="<c:out value='${board.title}'/>" readonly="readonly" />
					</div>
					<div class="form-group">
						<label>Text area</label>
						<textarea class="form-control" rows="3" name="content" 
							readonly="readonly"><c:out value="${board.content}"/></textarea>
					</div>
					<div class="form-group">
						<label>Writer</label>
						<input type="text" class="form-control" name="writer" 
							value="<c:out value='${board.writer}'/>" readonly="readonly" />
					</div>
					<a href="<c:url value='/'/>board/modify?bno=<c:out value='${board.bno}'/>" data-oper="modify" class="btn btn-default">Modify</a>
					<a href="<c:url value='/'/>board/list"  data-oper="list"  class="btn btn-info">List</a>
					<form action="<c:url value="/"/>" id="modify" method="get">
						<input type="hidden" name="bno" id="bno" value="<c:out value="${board.bno}" />" />
					</form>
				</div><!-- /.panel-body -->
			</div><!-- /.panel -->
		</div>
	</div> <!-- /.row -->
	<!-- //페이지 콘텐츠 부분 -->
<script type="text/javascript">
	$(document).ready(function() {
		var operForm = $("#operForm");
		$("button[data-oper='modify']").on("click", function(e){
			
		});
	});
</script>
<%@ include  file="../includes/footer.jsp" %>		
