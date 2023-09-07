# jpashop

### 기본 기능 및 개발 순서

![image](https://github.com/ManchanTime/jpashop/assets/127479677/198e437f-f580-4a3f-a7a0-f69c468ec204)

메인 화면

![image](https://github.com/ManchanTime/jpashop/assets/127479677/9a0cc1d3-392c-4e0b-bd88-f0e86503416c)

회원 

![image](https://github.com/ManchanTime/jpashop/assets/127479677/4e7ffcb7-57fd-4eb1-aebf-cfdccf304c4a)

상품 

![image](https://github.com/ManchanTime/jpashop/assets/127479677/8bb17011-e45a-4f93-9ab4-fd516fcaf3fd)

주문

+ 회원 기능
  + 회원 등록
  + 회원 조회

+ 상품 기능
  + 상품 등록
  + 상품 수정
  + 상품 조회(상세 정보)

+ 주문 기능
  + 상품 주문
  + 주문 내역 조회
  + 주문 취소
 
+ 참고
  예제의 단순화를 위해 로그인, 권환 관리 기능, 파라미터 검증, 예외 처리 기능, 카테고리 기능, 배송 정보 기능은 구현x

+ 아키텍처

  ![image](https://github.com/ManchanTime/jpashop/assets/127479677/018bf3fc-b6c6-401a-b0f4-981684b17bae)

  계층형 구조를 사용한다.
  + controller, web: 웹 계층
  + service: 비즈니스 로직, 트랜잭션 처리
  + repository: JPA를 직접 사용하는 계층, 엔티티 매니저를 사용한다.
  + domain: 엔티티 계층, 모든 계층에서 사용한다.
 
+ 구현 순서
  서비스, 레포지토리 계층을 개발하고, 테스트 코드를 작성해서 검증한 후 웹 계측을 적용한다.

### 개발 요구사항

+ 도메인 모델

  ![image](https://github.com/ManchanTime/jpashop/assets/127479677/ce409e35-0ca1-4e44-80cf-46e3a2dacfd9)

+ 엔티티

  ![image](https://github.com/ManchanTime/jpashop/assets/127479677/319a35bd-bbea-4961-bb59-45da68593314)

+ 테이블

  ![image](https://github.com/ManchanTime/jpashop/assets/127479677/5d695672-114f-42dc-b397-f998c53a6175)
