package solution.fileparsers

import solution.models.Order
import solution.models.OrderColumnPosition
import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException
import java.util.ArrayList

class CsvParser : OrdersReportParser {
    override fun extractOrders(filePath: String): List<Order> {
        val orders = ArrayList<Order>()
        var br: BufferedReader? = null
        try {
            var sCurrentLine =""
            br = BufferedReader(FileReader(filePath))

            while ((br.readLine()?.let { sCurrentLine = it }) != null){
            orders.add(splitLine(sCurrentLine).mapLineToOrder())

            }

        } catch (e: IOException) {
            e.printStackTrace()
        }

        try {
            br?.close()
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
        return orders
    }

    private fun splitLine(line: String): ArrayList<String> {
        val ar = line.split(",".toRegex()).toTypedArray()
        val d = ArrayList<String>()
        for (data in ar) {
            d.add(data)
        }
        return d
    }

    private fun ArrayList<String>.mapLineToOrder(): Order {
        val order = Order()
        this.mapIndexed { index, value ->
            when (index) {
                OrderColumnPosition.ID.getPosition() -> {
                    order.id = value
                }
                OrderColumnPosition.AREA.getPosition() -> {
                    order.area = value
                }
                OrderColumnPosition.PRODUCT_NAME.getPosition() -> {
                    order.productName = value
                }
                OrderColumnPosition.QUANTITY.getPosition() -> {
                    order.quantity = Integer.valueOf(value)
                }
                OrderColumnPosition.PRODUCT_BRAND.getPosition() -> {
                order.productBrand= value
                }
            }

        }
        return order
    }
}