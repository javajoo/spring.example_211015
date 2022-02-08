<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 추가</title>
<!-- ajax 통신을 사용하려면 가장 기본적인 제이쿼리 cdn 가져와야 한다. -->
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<!-- bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>회원 정보 추가</h1>
		<!-- 기능을 봐야 하기 때문에  action="/lesson06/add_user"-->
		<form method="post" action="/lesson06/add_user">
			<div class="form-group">
				<label for="name">이름:</label> <input type="text"
					class="form-control" id="name" name="name" placeholder="이름을 입력하세요">
			</div>

			<div class="form-group">
				<label for="yyyymmdd">생년월일:</label> <input type="text"
					class="form-control" id="yyyymmdd" name="yyyymmdd"
					placeholder="생년월일을 입력하세요">
			</div>

			<div class="form-group">
				<label for="email">이메일 주소:</label> <input type="text"
					class="form-control" id="email" name="email"
					placeholder="이메일을 입력하세요">
			</div>

			<div class="form-group">
				<label for="introduce">자기소개:</label>
				<textarea rows="10" cols="100" class="form-control" id="introduce"
					name="introduce"></textarea>
			</div>

			<input type="button" id="addBtn" class="btn btn-success" value="추가">
		</form>
	</div>
</body>

<!-- 스크립트가 먼저 실행되고 뷰가 실행된다. -->
<!-- 서버에 보낼때는 벨리데이션 체크까지 해준다. form 태그를 script태그에서 거른다.-->
<script>
	$(document).ready(function() {
		// 1) jquery의 submit 기능 이용하기
		// 버튼의 타입 submit 
		/* // id: '#id', form태그: 'form'
		// submit 되었을때  function(e){ 안에 들어있는 이벤트 내용이 발생한다.
			// submit 타입일때는 return false; 해줘도 된다. 
		$('form').on('submit', function(e){
			//e.preventDefault(); // submit이 되는 것을 막는다. 항상 상단에 넣어준다.
			// 유효성 체크
			let name = $('#name').val().trim();
			if (name.length < 1) {
				alert("이름을 입력해 주세요")
				return false;
			}
			
			let yyyymmdd = $('#yyyymmdd').val().trim();
			if (yyyymmdd == '') {
				alert("생년월일을 입력해 주세요")
				return false;
			}
			
			let email = $('#email').val().trim();
			if (email == '') {
				alert("이메일을 입력해 주세요")
				return false;
			}
			
			// 유효성 체크 통과 -> 여기까지 도달하면 서브밋  
			
			//alert("서브밋");
		}); */

		// 2) jquery의 AJAX 통신 이용하기
		// 버튼의 타입을 submit -> button 변경
		// click 타입일때는 return; 해줘도 된다. 
		$('#addBtn').on('click', function(e) {
		
			//alert("추가 버튼 클릭");

			let name = $('#name').val().trim();
			if (name.length < 1) {
				alert("이름을 입력해 주세요")
				return;
			}

			let yyyymmdd = $('#yyyymmdd').val().trim();
			if (yyyymmdd == '') {
				alert("생년월일을 입력해 주세요")
				return;
			}

			// 모두 숫자인지 확인 
			if (isNaN(yyyymmdd)) { // 숫자가 아닌 문자가 있을 때 true
				alert("숫자만 입력 해주세요");
				return;
			}
			
			let email = $('#email').val().trim();
			if (email == '') {
				alert("이메일을 입력해 주세요")
				return;
			}
			
			let introduce = $('#introduce').val();
			console.log(name);
			console.log(yyyymmdd);
			console.log(email);
			console.log(introduce);
			
			// AJAX 통신 : 폼태크와 상관없이 비동기로 요청(request)
			$.ajax({
				type: 'POST'
				, url: '/lesson06/add_user'
				, data: {'name':name, 'yyyymmdd':yyyymmdd, 'email':email, 'introduce':introduce}
			// data : controller @ResponseBody에 들어있는 내용이 수행된다. 
				, success: function(data) {
					alert(data); // 완전하게 성공했을 때 수행된다.
					location.href = "https://google.com"; // 페이지로 이동한다.
					//location.reload(); // 새로고침
				}
				, complete: function(data) {
					alert("완료"); // 실패를 했던지 성공을 했던지 모두 뜬다. 잘 안씀.
				}
				, error: function(e) {
					alert("error : " + e) // 에러가 발생했을 때 수행된다.
				}
			});
		});
	});
</script>
</html>












