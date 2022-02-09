<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이름 추가하기</title>
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
		<b>이름:</b>
		<div class="d-flex">
			<input tpye="text" class="form-control col-3" id="name" placeholder="이름을 입력하세요"> 
			<%-- ajax로 보낼것이기 때문에 id로 넘겨주는 게 쉽다. --%>
			<button type="button" id="nameCheckBtn" class="btn btn-info">중복확인</button>
		</div>
		
		<div id="nameStatusArea"></div>
		
		<button id="joinBtn" class="btn btn-success mt-3" type="submit">가입하기</button>
	</div>

<!-- 스크립트는 body 안쪽에, 검사 띄워서 확인하면서 해야 한다. -->
<script>
	$(document).ready(function() {
		// 중복확인 버튼 클릭
		$('#nameCheckBtn').on('click',function(e){
			//alert("click");
			var name = $('#name').val().trim();
			
			// div 태그 안에 있는 내용을 모두 비운다.
			$('#nameStatusArea').empty();
			
			
			// validation check
			if (name == '') {
				$('#nameStatusArea').append('<span class="text-danger">이름이 비어있습니다.</span>');
				return; // return: 이 벨리데이션을 통과해야 다음으로 넘어간다.
			}
			
			// 이름이 중복되는지 확인(DB) -> AJAX
			$.ajax({
				 type: "GET"
				, url: "/is_duplication"
				, data: {"name":name}
				, success: function(data) {
					//alert(data.is_duplication);
					<!-- boolean: 0,false / 1,true -->
					if (data.is_duplication == true) {
						$('#nameStatusArea').append('<span class="text-danger">중복된 이름입니다.</span>');
					}
					
				}
				,error: function(e) {
					alert("error");
				}
			});
		});
		
		// 회원가입 버튼 클릭
		$('#joinBtn').on('click',function(e) {
			e.preventDefault; // 기본 동작 멈춤
			
			// nameStatusArea 태그 안에 누가 있는지 (안의 자식로드의 길이로 판단)
			console.log($('#nameStatusArea').children().length);
			
			if ($('#nameStatusArea').children().length > 0) {
				alert("서브밋 불가");
			} else {
				alert("서브밋 가능");
			}
		});
	});
</script>
</body>
</html>












