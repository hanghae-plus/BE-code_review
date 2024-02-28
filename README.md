# BE-code_review

항해 플러스 주최 웹개발 스터디의 우수 스터디원 한정 코드리뷰 문제입니다.

<br/>
<br/>

<p align="middle" >
  <img width="100px;" src="assets/ic_bank.png"/>
</p>
<h2 align="middle"></h2>
<p align="middle">뱅킹과 할일 목록으로 살펴보는 도메인 설계</p>

## ⚙️ 구현 요구사항

### 🏧 뱅킹

##### 계좌 생성 [POST] `/accounts`

- accountName: String

##### 현금 입금 [POST] `/accounts/{accountId}/deposit`

- amount: Integer

##### 현금 출금 [POST] `/accounts/{accountId}/withdraw`

- amount: Integer

##### 송금 [POST] `/accounts/{accountId}/transfer`

- recipientAccountId: String
- amount: Integer

##### 계좌 내역 조회 [GET] `/accounts/{accountId}`

### 📋 Todo

##### 할일 목록 조회 [GET] `/todos`

##### 할일 추가 [POST] `/todos`

- description: String

##### 할일 달성 여부 변경 [PATCH] `/todos/{todoId}/change`

- isCompleted: Boolean

##### 할일 삭제 [DELETE] `/todos/{todoId}/change`

## ✅ 기능 요구사항

### 🏧 뱅킹

- [ ] 계좌에 현금을 입금할 수 있다. 현금의 금액만큼 계좌의 잔액이 증가한다.
- [ ] 계좌에서 현금을 출금할 수 있다. 출금한 금액만큼 계좌의 잔액이 줄어든다.
- [ ] 다른 계좌에 송금을 할 수 있다. 송금한 금액만큼 계좌의 잔액은 줄고, 수신계좌의 잔액이 늘어난다.
- [ ] 계좌의 잔액보다 큰 금액을 송금하거나 인출할 수는 없다.
- [ ] 계좌 잔액의 증감은 전부 거래내역으로 남아야한다.
- [ ] 거래내역은 '계좌의 증감(+, -) 금액', '거래 일시'가 표시되며 거래 일시의 오름차순으로 표시된다.
- [ ] 한 계좌에 동시에 여러 요청 (입금과 동시 출금, 동시 전액 출금)이 왔을 때 정상적으로 연산이 진행된다.
- [ ] 위 요구사항에 대한 테스트코드를 작성한다.

### 📋 Todo

- [ ] 할일을 추가할 수 있다. 할일은 일에 대한 구체적인 '내역'만 입력하면 된다.
- [ ] 등록한 할일을 전체 목록으로 한 번에 확인할 수 있다.
- [ ] 개별적인 할일의 '달성여부'를 끄거나 킬 수 있다.
- [ ] 할일의 상태가 '달성'으로 변경되면 달성시각을 확인할 수 있다.
- [ ] 할일 목록의 우선순위는 '달성여부', '등록일시' 순이다.
- [ ] 할일을 할일 목록의 리스트에서 삭제할 수 있다.
- [ ] 한 할일에 동시에 상태 변경 요청이 왔을 때 (달성으로 변환, 미달성으로 변환) 정상적으로 연산이 진행된다.
- [ ] 위 요구사항에 대한 테스트코드를 작성한다.

## 🔥 참고 사항

- 백엔드 프레임워크(NestJs-Ts, Spring-Kotlin) 제외 추가로 필요한 패키지는 없습니다.
- 도메인 및 인터페이스 설계에 대해 중점적으로 고민해주시면 됩니다.
- 영속성을 담당하는 서비스는 따로 사용하지 않는 것으로 합니다.
