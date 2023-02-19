# kotlin-lotto

# domain
## LottoNumber
- [X] 로또 숫자의 원시 값을 포장

## PurchaseLottoMoney
- [X] 로또 구입 금액의 원시값을 포장
  - [X] 구입 금액은 최소한 1000원 이상이여야 한다.
- [X] 구입 금액으로부터 몇 장을 구매가능한지 반환해주는 기능

## Lotto
- [X] 일급 컬렉션으로 사용(Set)  
- [X] 검증이 필요한 부분  
    - [X] 개수가 6개면 로또 생성
    - [X] 개수가 6개가 아니라면 exception 발생
    - [X] 번호가 범위안에 들어오는지 검증 
    - [X] 당첨번호와 매칭되는 등수를 반환하는지 검증

## Lottos 
- [X] 로또들의 정보를 저장  
 
## WinningLotto
- [X] 일급 컬렉션으로 사용
- [X] 검증
  - [X] 당첨번호와 보너스 번호가 같으면 exception 발생
  - [X] 당첨번호와 보너스 번호가 다르면 winningLotto 생성
  - [X] 보너스번호가 범위안에 들어오는지 검증

## LottoSeller
- [X] 로또를 한 장 발급한다.  
- [X] 파라미터(PurchaseLottoMoney)로 살 수 있는 만큼 로또를 발급한다.  

## LottoStatistics
- [X] 당첨 통계를 낸다.
    - [X] 단일 로또를 넘겨 받아서 당첨 결과를 반환한다.
- [X] Ticket을 넘겨 받아서 당첨 번호와 비교한다.
  - [X] 총 수익률을 계산한다.  

## RandomGenerator
- [X] 6개의 무작위 수 생성

## Enum class
- [X] 등수와 금액을 저장한다.
- [X] 당첨 번호와 보너스 볼 매치 여부로 당첨 등수 반환

---

# view
## InputView
- [X] 구입 금액을 입력받는다.  
- [X] 당첨 번호를 입력받는다.  
- [X] 보너스 볼을 입력받는다.  

## ResultView
- [X] 당첨 통계를 출력한다.  
- [X] 수익률을 출력한다.  

---

# Controller
## Controller
- [X] 전체 로직을 담당한다.  
  - [X] 구입 금액을 입력받아 Lotto들이 담겨있는 Ticket 생성
  - [X] 당첨 번호와 보너스 볼을 입력받아 WinningLotto 생성
  - [X] LottoStatistics를 통해 당첨 통계 계산
  - [X] resultView에 결과를 전달하여 출력
