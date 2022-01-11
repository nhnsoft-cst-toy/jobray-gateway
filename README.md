[![CodeFactor](https://www.codefactor.io/repository/github/nhnsoft-cst-toy/jobray-gateway/badge)](https://www.codefactor.io/repository/github/nhnsoft-cst-toy/jobray-gateway)
# Jobray Gateway 애플리케이션
Jobray 서비스 간 통신의 Routing과 인증 처리를 담당하는 애플리케이션입니다.

## 의존성
* Spring Boot
* Spring Cloud Gateway
* Spring Cloud Resilience4j

## 테스트
### 라우팅 테스트
1. 다른 애플리케이션의 엔드포인트를 확인합니다.
```
http://localhost:8888/test
```
2. `application.properties` 에 아래 설정을 추가합니다.
```properties
app.config.routes.user-path=/user-api/**
app.config.routes.user-host=user.jobray.com
app.config.routes.user-url=[다른 애플리케이션의 도메인]
```
3. 1번 애플리케이션과 jobray-gateway 애플리케이션을 구동합니다.
4. curl 명령어로 path 기준 요청 시 라우팅 처리를 테스트합니다.
```shell
curl http://localhost:8080/user-api/test
```
5. curl 명령어로 host 기준 요청 시 라우팅 처리를 테스트합니다.
```shell
curl --dump-header - --header 'Host: user.jobray.com' http://localhost:8080/test
```
6. 응답 본문이 1번 애플리케이션의 엔드포인트에서 응답하는 내용이 맞는지 확인합니다.