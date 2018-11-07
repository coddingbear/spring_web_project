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
                    <div class="form-group">
                      <label>RegDate</label>
                      <input type="text" class="form-control" name="regDate" 
                        value="<fmt:formatDate pattern='yyyy/MM/dd' value='${board.regdate}'/>" readonly="readonly" />
                    </div>
                    <button type="button" data-oper="modify" class="btn btn-default">Modify</button>
                    <button type="button" data-oper="list" class="btn btn-info">List</button>
					<form  id="operForm" action="<c:url value="/"/>board/modify" method="get">
						<input type="hidden" name="bno" id="bno" value="<c:out value="${board.bno}" />" />
					</form>
				</div><!-- /.panel-body -->
			</div><!-- /.panel -->
		</div>
	</div> <!-- /.row -->
	<!-- //페이지 콘텐츠 부분 -->
<script type="text/javascript">
	$(document).ready(function() {
		var contextUrl = '<c:url value="/"/>';
		var operForm = $("#operForm");
		$("button[data-oper='modify']").on("click", function(e){
			operForm.attr("action", contextUrl + "board/modify").submit();
		});
		
		$("button[data-oper='list']").on("click", function(e){
			operForm.find("#bno").remove();
			operForm.attr("action", contextUrl + "board/list");
			operForm.submit();
		});
	});
</script>
<%@ include  file="../includes/footer.jsp" %>		
