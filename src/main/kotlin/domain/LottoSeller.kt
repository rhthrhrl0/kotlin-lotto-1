package domain

class LottoSeller(private val numberGenerator: RandomGenerator = NumberRandomGenerator()) {
    fun sellLotto(): Lotto {
        return Lotto(numberGenerator.generate().map { LottoNumber.from(it) }.toSet())
    }

    fun sellLottos(count: Int): Ticket {
        return Ticket(List(count) { sellLotto() })
    }
}
