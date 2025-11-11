1. ERD: 데이터 청사진
Entity(개체): 데이터를 가진 대상
Relation(관계): 개체 사이의 연관성 ex)어떤 회원이 어떤 상품을 주문했는지
ER - Model: 개체와 관계 중심의 모델링 기법
ER - Model을 시각적으로 표현한 그림이 ERD.

2. DB 설계
a. 엔티티 ex) 회원, 상품, 주문
b. 속성(필드, 칼럼) ex) Member: id, name, address / Product: name, price, stack
c. 기본 키: 고유하게 식별하는데 사용되는 하나 이상의 필드(칼럼) ex) Member: id, name
d. 외래 키: 다른 테이블의 기본 키를 참조(저장)하는 속성(컬럼) ex) Order 테이블 안 member_id
e. 관계: 객체 사이의 연관성, 업무 규칙. 테이블과 외래 키로 구현
1:N 관계 -  한 명의 회원이 여러 주문 내역을 가짐. Member(1) : (N)Order. Order 테이블은 member_id를 외래 키로 가짐.
N:N 관계 - 한 명의 학생은 여러 강의를 들을 수 있고, 하나의 강의는 여러 학생이 들을 수 있음.
중간 테이블 Enrollment로 관계를 구현.
