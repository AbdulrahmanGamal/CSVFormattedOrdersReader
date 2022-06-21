import solution.fileparsers.FileParser
import solution.ordercalculations.AverageCalculator
import solution.ordercalculations.HottestBrandsCalculator
import solution.utils.mapToCSV
import java.util.*


class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val scanner = Scanner(System.`in`)
            val fileName = scanner.nextLine()
            val ordersFileParser = FileParser()

            val orders = ordersFileParser.parseCsvOrders(getFileDirAccordingOs("$fileName"))
            val ordersAverage = AverageCalculator().calculate(orders)
            val hottestBrandsCalculator = HottestBrandsCalculator().calculate(orders)
            ordersAverage.mapToCSV(getFileDirAccordingOs("0_$fileName"))
            hottestBrandsCalculator.mapToCSV(getFileDirAccordingOs("1_$fileName"))
        }

        private fun getFileDirAccordingOs(fileName: String): String {
            return when (Util.oS) {
                Util.OS.WINDOWS ->".\\$fileName"
                else ->  "$fileName"
            }
        }
    }


}

object Util {
    // Operating systems.
    private var os: OS? = null
    val oS: OS?
        get() {
            if (os == null) {
                val operSys: String = System.getProperty("os.name").toLowerCase()
                if (operSys.contains("win")) {
                    os = OS.WINDOWS
                } else if (operSys.contains("nix") || operSys.contains("nux")
                    || operSys.contains("aix")) {
                    os = OS.LINUX
                } else if (operSys.contains("mac")) {
                    os = OS.MAC
                } else if (operSys.contains("sunos")) {
                    os = OS.SOLARIS
                }
            }
            return os
        }

    enum class OS {
        WINDOWS, LINUX, MAC, SOLARIS
    }
}