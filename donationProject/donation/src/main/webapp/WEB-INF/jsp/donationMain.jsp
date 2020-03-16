<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- <link rel="stylesheet" type="text/css" href="/static/css/test.css"/> -->
<script src="/static/js/test.js"></script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>

<title>Spring Boot Application with JSP</title>

<script>
// $(document).ready(function(){
// 	alert(3);
// })
</script>
<body>
<input type="hidden" id="scriptKey" name="scriptKey" value="a099fdcbfae95ecd3b96b2a6f4ea1856"/>
<a id="kakao-login-btn" onclick="kakaoLoginBtn()"></a>






<script src="/static/js/donation.kakaoApi.js"></script>
<script type='text/javascript'>
  //<![CDATA[
    // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('a099fdcbfae95ecd3b96b2a6f4ea1856');
    // 카카오 로그인 버튼을 생성합니다.
    Kakao.Auth.createLoginButton({
      container: '#kakao-login-btn',
      success: function(authObj) {
        // 로그인 성공시, API를 호출합니다.
        Kakao.API.request({
          url: '/v2/user/me',
          success: function(res) {
            alert(JSON.stringify(res));
          },
          fail: function(error) {
            alert(JSON.stringify(error));
          }
        });
      },
      fail: function(err) {
        alert(JSON.stringify(err));
      }
    });
  //]]>
</script>

</body>
