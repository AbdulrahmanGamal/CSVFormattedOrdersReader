package utils

import java.io.FileWriter
import java.io.IOException
import java.lang.Exception


private val COMMA_DELIMITER = ","
private val NEW_LINE_SEPARATOR = "\n"

 fun Map<String,Any>.mapToCSV(fileName:String){
    var fileWriter: FileWriter? = null

    try {
        fileWriter = FileWriter(fileName)
        for (average in this) {
            fileWriter.append(average.key)
            fileWriter.append(COMMA_DELIMITER)
            fileWriter.append(average.value.toString())
            fileWriter.append(NEW_LINE_SEPARATOR)
        }
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        try {
            fileWriter?.flush()
            fileWriter?.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}