package fileparsers

class FileParser() {
    private val csvParser = CsvParser()
    fun parseCsvOrders(filePath: String) = csvParser.extractOrders(filePath)
}