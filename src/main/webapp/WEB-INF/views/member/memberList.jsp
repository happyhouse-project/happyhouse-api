<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>회원 정보 관리</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="../css/user_manage.css" />
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="user_manage.js"></script>
</head>
<body>
	<div class="container-xxl">
		<div class="table-responsive">
			<div class="table-wrapper">
				<div class="table-title">
					<div class="row">
						<div class="col-sm-6">
							<h2>회원 정보 관리</h2>
						</div>
						<div class="col-sm-6">
							<a href="#addEmployeeModal" class="btn btn-success"
								data-toggle="modal"><i
								class="material-icons">&#xE147;</i> <span>회원 추가</span></a> <a
								href="#deleteEmployeeModal" class="btn btn-danger"
								data-toggle="modal"><i
								class="material-icons">&#xE15C;</i> <span>선택 회원 삭제</span></a>
						</div>
					</div>
				</div>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th><span class="custom-checkbox"> <input
									type="checkbox" id="selectAll" /> <label for="selectAll"></label>
							</span></th>
							<th>이메일</th>
							<th>성</th>
							<th>이름</th>
							<th>전화번호</th>
							<th>도/광역시</th>
							<th>시/구/군</th>
							<th>동</th>
							<th>관리</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${list}" var="member">
						<tr>
							<td><span class="custom-checkbox"> <input
									type="checkbox" id="checkbox1" name="options[]" value="1" />
									<label for="checkbox1"></label>
							</span></td>
							<td>${member.email}</td>
							<td>${member.lastname}</td>
							<td>${member.firstname}</td>
							<td>${member.phone}</td>
							<td>${member.si}</td>
							<td>${member.gu}</td>
							<td>${member.dong}</td>
							<td><a href="#editEmployeeModal" class="edit"
								data-toggle="modal"><i
									class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
								<a href="#deleteEmployeeModal" class="delete"
								data-toggle="modal"><i
									class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
							</td>
						</tr>
					</c:forEach>						
					</tbody>
				</table>
				<div class="clearfix">
					<div class="hint-text">
						Showing <b>5</b> out of <b>25</b> entries
					</div>
					<ul class="pagination">
						<li class="page-item disabled"><a href="#">Previous</a></li>
						<li class="page-item active"><a href="#" class="page-link">1</a>
						</li>
						<li class="page-item"><a href="#" class="page-link">2</a></li>
						<li class="page-item"><a href="#" class="page-link">3</a></li>
						<li class="page-item"><a href="#" class="page-link">4</a></li>
						<li class="page-item"><a href="#" class="page-link">5</a></li>
						<li class="page-item"><a href="#" class="page-link">Next</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
