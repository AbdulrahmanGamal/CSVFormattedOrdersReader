package models

data class Order(
    var id: String = "",
    var area: String = "",
    var productName: String = "",
    var quantity: Int = 0,
    var productBrand: String = ""
)