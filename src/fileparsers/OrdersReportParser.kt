package fileparsers

import models.Order

interface OrdersReportParser {
    fun extractOrders(filePath:String):List<Order>
}