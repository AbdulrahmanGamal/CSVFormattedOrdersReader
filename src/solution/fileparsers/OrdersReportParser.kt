package solution.fileparsers

import solution.models.Order

interface OrdersReportParser {
    fun extractOrders(filePath:String):List<Order>
}