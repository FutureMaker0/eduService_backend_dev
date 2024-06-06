# 1. 개념
## Session vs Token(JWT)
  - 최근 OAuth 인증 방식이 많이 활용되면서 확장성이 높은 토큰 방식이 많이 사용된다.

## Authentication(인증) vs Authorization(권한 부여)
  - Authentication(인증): 로그인과 같이 사용자 또는 프로세스의 신원을 확인하는 절차
  - Authorization(권한 부여): 누가 어떤 작업을 할 수 있는지 결정하는 절차

## Spring Security + JWT 로그인
  1. 클라이언트에서 서버로 ID/PW로 로그인을 요청한다.
  2. 서버에 저장되어 있는 ID/PW와 전송 데이터가 일치하여 검증되면, Access Token + Refresh Token을 발급한다.
  3. 클라이언트는 요청 헤더(request header)에 발급받은 Access Token을 포함하여 API를 요청한다.

### Access Token + Refresh Token 재발급 원리
  - Access Token과 Refresh Token은 웹/앱 어플리케이션에서 인증 및 권한 부여를 관리하기 위해 사용되는 토큰이다.
  1. 서버에서 클라이언트로 Access Token 만료를 알리는 응답을 보낸다.
  2. 클라이언트는 서버 측으로 Access Token + Refresh Token 재발급을 요청한다.
  3. 서버는 토큰 검증 후 Access Token + Refresh Token을 재발급한다.

#### Access Token
  - 인증된 사용자가 특정 리소스에 접근할 때 사용되는 토큰
  - 클라이언트는 Access Token을 사용하여 인증된 사용자의 신원을 확인하고, 서비스 또는 리소스에 접근
  - 유효기간이 지나면 만료(expired)
  - 만료가 되면, 새로운 Access Token을 얻기 위해 Refresh Token 사용

#### Refresh Token
  - Access Token의 갱신을 위해 사용되는 토큰
  - 일반적으로 Access Token과 함께 발급
  - Access Token이 만료되면 Refresh Token을 사용하여 새로운 Access Token 발급
  - 사용자가 지속적으로 인증 상태를 유지할 수 있도록 해줌 (접근 시마다 새롭게 로그인하지 않아도 되게 함)
  - Access Token보다는 길지만, 보안 상의 이유로 마찬가지로 유효 기간을 가짐

# 2. 구현
  1) 라이브러리 설정
     - Spring Security와 JWT 사용을 위해 라이브러리를 추가한다.(build.gradle)
  2) JwtTokenDTO 생성
     - 클라이언트에 토큰을 보내기 위한 JwtTokenDto를 생성한다.
     - String grantType은 JWT에 대한 인증 타입이다. Bearer 방식을 사용하며, 이 방식은 Access Token을 HTTP 요청의
       Authrization 헤더에 포함하여 전송한다. ex)Bearer<access_token>
  3) 암호 키 설정
     - "openssl rand -hex 32" 명령어를 통해 랜덤으로 암호 키를 생성한다.
     - 생성한 secret key를 application.yml에 등록한다.
     - 해당 키는 토큰의 암/복호화에 사용된다.
     - HS256 알고리즘을 사용하기 위해 32글자 이상으로 설정해준다.(32의 의미)
  4) JwtTokenProvider 구현
     - Spring Security와 JWT 토큰을 사용하여 인증 및 권한 부여를 처리하는 클래스.
     - JWT Token의 생성, 복호화, 검증 기능 등을 구현할 수 있다.
  5) JwtAuthenticationFilter 구현
  6) SecurityConfig 설정
  7) 인증을 위한 도메인, 리포지토리 레이어 구현
  8) 인증을 위한 서비스 레이어 구현
  9) UserDetailsService를 확장하는 서비스 구현(CustomUserDetailsService.java)

