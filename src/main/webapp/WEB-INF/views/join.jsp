<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Join </title>
<script type="text/javascript">

	function chk() {
		var result = false;
		var frm = document.joinFrm;
		
		if(frm.id.value=="") {
			alert("ID를 입력해주세요!")
			frm.id.focus();
		}
		
		else if(frm.pwd.value=="") {
			alert("비밀번호를 입력해주세요!")
			frm.id.focus();
		}
		
		else if(frm.name.value=="") {
			alert("이름을 입력해주세요!")
			frm.id.focus();
		}
		
		else if(frm.birth.value=="") {
			alert("생일을 입력해주세요!")
			frm.id.focus();
		}
		
		else if(frm.addr.value=="") {
			alert("주소를 입력해주세요!")
			frm.id.focus();
		}
		
		else if(frm.phone.value=="") {
			alert("핸드폰 번호를 입력해주세요!")
			frm.id.focus();
		} 
		else {
			result = true;
		}
		return result;
}
		
	function joinCheck(check) {
			if(check==1) { alert("회원가입성공");
		}
}
	
	/* function formCheck() {
		var length=document.forms[0].length-1; // form[0] 은 form 태그의 첫번째 폼			 
		for(var i=0; i<length-1; i++) {				
			if(document.forms[0][i].value==null||document.forms[0][i].value=="") {					 
				alert(document.forms[0][i].name+"을/를 입력하세요.");    // 경고창				 
				document.forms[0][i].focus();					 
				return false;				 
			}			 
		} 		
	} */
</script>

<style>
	.subject {text-align:center; height:30px}

</style>

</head>
<!-- join.jsp -> MembersAction.java -> HomeController.java -> onload -> script -->
<!-- 회원가입에 성공하면 check=1 이 들어가고 메모리에 할당 후 이벤트 발생. script를 실행한다. -->
<body onLoad="joinCheck(${check})"> <!-- requestScope.check -->
<h1>
	회원가입!  
</h1>

	<!-- submit()이 실행되면 유효성 검사를 실시 -->
	<form name="joinFrm" action="memJoin" method="post" onsubmit="return chk();">
	<table border="0" width="300" height="50">
		<tr>
			<td>ID</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>PWD</td>
			<td><input type="password" name="pwd"></td>
		</tr>
		<tr>
			<td>NAME</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>BIRTH</td>
			<td><input type="text" name="birth"></td>
		</tr>
		<tr>
			<td>ADDR</td>
			<td><input type="text" name="addr"></td>
		</tr>
		<tr>
			<td>PHONE</td>
			<td><input type="text" name="phone"></td>
		</tr>
		<tr>
			<td colspan="2" class="subject">
			<input type="submit" onclick="location.href='memJoin'" value="회원가입">
			<input type="button" onclick="location.href='/'" value="처음화면"></td>
		</tr>
	</table>
</body>
</html>


