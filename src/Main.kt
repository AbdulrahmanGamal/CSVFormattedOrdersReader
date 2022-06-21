import solution.ordercalculations.AverageCalculator
import solution.ordercalculations.HottestBrandsCalculator
import solution.fileparsers.FileParser
import solution.utils.mapToCSV
import java.util.*


class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val scanner = Scanner(System.`in`)
            val fileName = scanner.nextLine()
            val ordersFileParser = FileParser()
            val orders = ordersFileParser.parseCsvOrders(".\\$fileName")
            val ordersAverage = AverageCalculator().calculate(orders)
            val hottestBrandsCalculator = HottestBrandsCalculator().calculate(orders)
            ordersAverage.mapToCSV(".\\0_$fileName")
            hottestBrandsCalculator.mapToCSV(".\\1_$fileName")
        }
    }
}