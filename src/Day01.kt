fun main() {
    fun part1(input: List<String>): Int {
        return input.sumOf { line ->
            val digits = line.filter { it.isDigit() }

            digits.first().toString().plus(digits.last()).toInt()
        }
    }

    fun part2(input: List<String>): Int {
        val letters = mapOf(
            "one" to "o1e",
            "two" to "t2o",
            "three" to "t3e",
            "four" to "f4r",
            "five" to "f5e",
            "six" to "s6x",
            "seven" to "s7n",
            "eight" to "e8t",
            "nine" to "n9e"
        )

        return input.sumOf { line ->
            val replacedLine = letters.entries.fold(line) { acc, (target, replacement) ->
                acc.replace(target, replacement)
            }

            val digits = replacedLine.filter { it.isDigit() }

            digits.first().toString().plus(digits.last()).toInt()
        }
    }

    val part1TestInput = readInput("Day01_test_part1")
    check(part1(part1TestInput) == 142)

    val part2TestInput = readInput("Day01_test_part2")
    check(part2(part2TestInput) == 281)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
