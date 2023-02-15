package domain

class LottoStatistics(val winningLotto: WinningLotto) {
    fun compareNumbers(lotto: Lotto): Int {
        val winningNumbers = winningLotto.getWinningNumbers()
        return lotto.numbers.filter { number ->
            winningNumbers.contains(number)
        }.size
    }

    fun compareBonusNumber(lotto: Lotto): Boolean = lotto.numbers.contains(winningLotto.bonusNumber)

    fun compare(lotto: Lotto): Rank = Rank.valueOf(compareNumbers(lotto), compareBonusNumber(lotto))
}
