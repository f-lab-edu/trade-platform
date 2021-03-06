## 프로젝트 목표
* 중고거래를 할 수 있는 플랫폼 개발

## 프로젝트 기능
* 사용자는 로그인 이후 중고거래 플랫폼을 이용가능.
* 중고거래 플랫폼을 이용하는 사용자는 상품을 등록,조회,수정,삭제 기능 가능
* 중고거래 플랫폼을 이용하는 사용자는 관심있는 중고상품을 올린 사용자에게 직접 DM 메세지를 이용해 채팅 가능
* 대용량의 사용자 동시 접속 및 플랫폼 이용 가능

## 프로젝트 중점상황
* 로그인 서비스
* Redis를 활용한 로그인 서비스
* 중고거래 상품의 등록 및 조회 구현 (인메모리 방식)
* 중고거래 상품의 등록 및 조회 구현 (데이터베이스 연동)
* 데이터베이스 설계
* 풀링 방식을 활용한 채팅 DM 구현
* 다중 사용자가 이용가능한 서비스 구현
* 분산처리 환경에서 동작할 수 있도록 설계
* 다수의 노드를 사용하여 대규모 트래픽 처리
* 가상화 기술을 사용한 손쉬운 배포 및 확장


## 프로젝트 구성도

추후 업데이트

## 프로젝트 진행단계
- [로그인 및 회원가입 기능 구현](https://github.com/f-lab-edu/trade-platform/wiki/%EA%B0%9C%EB%B0%9C-%EB%AA%A9%EB%A1%9D#1-%EB%A1%9C%EA%B7%B8%EC%9D%B8-%EB%B0%8F-%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85-%EA%B8%B0%EB%8A%A5-%EA%B5%AC%ED%98%84)

## 기술 스택

- Spring boot 2.6.2
- Java 11
- gradle


## 브랜치 관리 전략
[Github flow](https://docs.github.com/en/get-started/quickstart/github-flow) 를 사용하여 브랜치 관리
* main branch
  * 항상 최신이며 언제든 배포가 가능한 상태로 유지. 
* new (feature) branch
  * 새로운 기능 및 버그 수정등은 main branch 부터 새로운 브랜치 생성 후 작업.  
  * 브랜치의 이름을 의도가 드러나게 명확히 작성 필요.
* merge 전략
  * PR을 통해 다른 사용자에게 반드시 리뷰를 받은 후 main 브랜치에 merge 진행.

## 코드 스타일
[Checkstyle 9.0](https://github.com/checkstyle/checkstyle/releases/) 버전 적용

* google_checks.xml 사용
* Lint 적용을 통해 커밋 전 자동 코드 스타일 검사
* Lint 적용을 위해 아래 명령어 입력 (레포지토리 클론 후)
  * git config core.hooksPath .githooks (git version 2.9 이상)


## 테스트
* JUnit5를 사용하여 단위 테스트 수행
* 기타 등등..

## 성능 테스트
* 기타 등등..
