# Session vs Token(JWT)
  - 최근 OAuth 인증 방식이 많이 활용되면서 확장성이 높은 토큰 방식이 많이 사용된다.

# Authentication(인증) vs Authorization(권한 부여)
  - Authentication(인증): 로그인과 같이 사용자 또는 프로세스의 신원을 확인하는 절차
  - Authorization(권한 부여): 누가 어떤 작업을 할 수 있는지 결정하는 절차

# Spring Security + JWT 로그인
  1. 클라이언트에서 서버로 ID/PW로 로그인을 요청한다.
  2. 서버에 저장되어 있는 ID/PW와 전송 데이터가 일치하여 검증되면, Access Token + Refresh Token을 발급한다.
  3. 클라이언트는 요청 헤더(request header)에 발급받은 Access Token을 포함하여 API를 요청한다.

## Access Token + Refresh Token 재발급 원리
  - Access Token과 Refresh Token은 웹/앱 어플리케이션에서 인증 및 권한 부여를 관리하기 위해 사용되는 토큰이다.
  1. 서버에서 클라이언트로 Access Token 만료를 알리는 응답을 보낸다.
  2. 클라이언트는 서버 측으로 Access Token + Refresh Token 재발급을 요청한다.
  3. 서버는 토큰 검증 후 Access Token + Refresh Token을 재발급한다.
