package com.alexis.chineseastrology.lib.flyingstars.time

enum class MonthlyBoundary(
    val month: Int,
    val day: Int,
    val monthEnd: Int,
    val dayEnd: Int
) {
    BOUNDARY1(2, 4, 3, 5),
    BOUNDARY2(3, 6, 4, 4),
    BOUNDARY3(4, 5, 5, 5),
    BOUNDARY4(5, 6, 6, 5),
    BOUNDARY5(6, 6, 7, 6),
    BOUNDARY6(7, 7, 8, 7),
    BOUNDARY7(8, 8, 9, 7),
    BOUNDARY8(9, 8, 10, 7),
    BOUNDARY9(10, 8, 11, 6),
    BOUNDARY10(11, 7, 12, 6),
    BOUNDARY11(12, 7, 1, 5),
    BOUNDARY12(1, 6, 2, 3)
    ;
}