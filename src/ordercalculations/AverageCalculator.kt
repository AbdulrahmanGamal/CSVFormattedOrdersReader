package ordercalculations

import models.Order


class AverageCalculator {
    fun calculate(orders: List<Order>): Map<String, Double> {
        val productAverage = HashMap<String, Double>()
        val productTotalQuantity = HashMap<String, Double>()
        orders.onEach {
            if (productTotalQuantity.containsKey(it.productName)) {
                val oldCount = productTotalQuantity.getOrDefault(it.productName,0.0)
                productTotalQuantity[it.productName] = oldCount + it.quantity
            } else {
                productTotalQuantity[it.productName] = it.quantity.toDouble()
            }
        }
        productTotalQuantity.onEach {
            productAverage[it.key] = it.value / orders.size
        }
        return productAverage
    }
}