fun main() {
    class Draw(var red: Int = 0, var green: Int = 0, var blue: Int = 0)
    class Game(val id: Int, val draws: MutableList<Draw> = mutableListOf())

    fun parse(input: List<String>): List<Game> {
        val games: MutableList<Game> = mutableListOf()

        for (line in input) {
            val (start, end) = line.split(": ")
            val id = start.substring(5).toInt()
            val game = Game(id)

            val sets = end.split("; ")

            for (set in sets) {
                val draw = Draw()

                val dice = set.split(", ")

                for (die in dice) {
                    val (count, type) = die.split(' ')

                    when (type) {
                        "red" -> draw.red += count.toInt()
                        "green" -> draw.green += count.toInt()
                        "blue" -> draw.blue += count.toInt()
                    }
                }

                game.draws.add(draw)
            }

            games.add(game)
        }

        return games
    }

    fun part1(input: List<String>): Int {
        val maxRed = 12
        val maxGreen = 13
        val maxBlue = 14

        val games = parse(input)

        return games.filter { game ->
            game.draws.all { draw -> draw.red <= maxRed && draw.green <= maxGreen && draw.blue <= maxBlue }
        }.sumOf { it.id }
    }

    fun part2(input: List<String>): Int {
        val games = parse(input)

        return games.sumOf { game ->
            val red = game.draws.maxOf { it.red }
            val green = game.draws.maxOf { it.green }
            val blue = game.draws.maxOf { it.blue }

            red * green * blue
        }
    }

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 8)
    check(part2(testInput) == 2286)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}