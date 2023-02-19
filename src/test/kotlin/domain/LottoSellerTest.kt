package domain

import common.convertToLottoNumberSet
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoSellerTest {
    @Test
    fun `로또를 한 장 발급한다`() {
        val money = PurchaseLottoMoney(1 * 1000)
        val lottoSeller = LottoSeller(TestNumberGenerator())
        val lotto = lottoSeller.sellLottos(money)
        assertThat(lotto.lottos.size).isEqualTo(1)
        assertThat(lotto.lottos[0].numbers).isEqualTo(setOf(1, 2, 3, 4, 5, 6).convertToLottoNumberSet())
    }

    @ParameterizedTest(name = "{0}개의 로또를 발급한다.")
    @ValueSource(ints = [2, 3, 4])
    fun `입력받은 개수만큼 로또를 발급한다`(count: Int) {
        val money = PurchaseLottoMoney(count * 1000)
        val generator = TestNumberGenerator()
        val lottoSeller = LottoSeller(generator)
        val ticket = lottoSeller.sellLottos(money)
        assertThat(ticket.lottos.map { lotto -> lotto.numbers }).isEqualTo(
            generator.pattern.map { it.convertToLottoNumberSet() }.take(count)
        )
    }

    inner class TestNumberGenerator : RandomGenerator {
        val pattern = listOf(
            setOf(1, 2, 3, 4, 5, 6),
            setOf(9, 8, 7, 6, 5, 4),
            setOf(45, 30, 27, 1, 2, 7),
            setOf(5, 8, 9, 2, 10, 17)
        )
        private var i = 0

        override fun generate(): Set<Int> {
            return pattern[i++]
        }
    }
}
