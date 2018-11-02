<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include  file="../includes/header.jsp" %>
	<!-- 페이지 콘텐츠 부분 -->
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Tables</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div><!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Board List Page</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<table width="100%"	class="table table-striped table-bordered table-hover" id="dataTables-example">
							<thead>
								<tr>
									<th style="width:10%;">#번호</th>
									<th>제목</th>
									<th style="width:12%;">작성자</th>
									<th style="width:14%;">작성일</th>
									<th style="width:14%;">수정일</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${list}" var="board">						
								<tr class="odd gradeX">
										<td class="text-right"><c:out value="${board.bno}" /></td>
										<td><c:out value="${board.title}" /></td>
										<td><c:out value="${board.writer}" /></td>
										<td class="text-center"><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}"/></td>
										<td class="text-center"><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}"/></td>
								</tr>
							</c:forEach>
							</tbody>
							</table><!-- /.table-responsive -->
						</div><!-- /.panel-body -->
					</div><!-- /.panel -->
				</div><!-- /.col-lg-12 -->
			</div><!-- /.row -->
	<!-- //페이지 콘텐츠 부분 -->
<%@ include  file="../includes/footer.jsp" %>		
