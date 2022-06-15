import models.Order


class HottestBrandsCalculator {
    fun calculate(orders: List<Order>): Map<String, String> {
        val groupedData = orders.groupBy { it.productName }
        val mostSellingBrand = HashMap<String, String>()
        groupedData.onEach {product->
            val hottestBrand = getBrandFrequencies(product.value)
            val itemWithMaxFreq = hottestBrand.maxByOrNull  {it.value  }
            itemWithMaxFreq?.key?.let {
                mostSellingBrand[product.key] =   it
            }

        }
        return mostSellingBrand
    }

   private fun getBrandFrequencies(input: Collection<Order>): Map<String,Int> {
        val newMap: MutableMap<String, Int> = HashMap()
        for (item in input) {
            if (newMap.containsKey(item.productBrand)) {
                val oldCount = newMap.getOrDefault(item.productBrand, 0)
                newMap[item.productBrand] = oldCount + 1
            } else {
                newMap[item.productBrand] = 1
            }
        }
        return newMap
    }
}