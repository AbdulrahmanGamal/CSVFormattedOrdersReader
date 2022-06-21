package solution.models

enum class OrderColumnPosition(private val columnPosition:Int) {
    ID(0),
    AREA(1),
    PRODUCT_NAME(2),
    QUANTITY(3),
    PRODUCT_BRAND(4);
    fun getPosition():Int{
      return columnPosition
    }
}