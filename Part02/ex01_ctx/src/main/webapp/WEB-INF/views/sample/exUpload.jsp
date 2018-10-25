<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
<style>
	.container { width: 80%; padding: 20px; margin: 20px auto;}
	.form-control { height: 30px; }
</style>
</head>
<body>
	<div class="container">
		<form action="${pageContext.request.contextPath }/sample/exUploadPost" method="POST" enctype="multipart/form-data">
			<div class="form-control">
				<input type="file" name="files" />
			</div>
			<div class="form-control">
				<input type="file" name="files" />
			</div>
			<div class="form-control">
				<input type="file" name="files" />
			</div>
			<div class="form-control">
				<input type="file" name="files" />
			</div>
			<div class="form-control">
				<input type="submit" value="제출" />
			</div>
		</form>
	</div>
</body>
</html>