package kroneker.filter


enum class DataFilterOp {
    IS_EQUAL_TO,IS_GREATER_THAN,IS_LESS_THAN,CONTAINS,HAS_NO_VALUE;

    val isEqualTo get() = this == IS_EQUAL_TO
    val isGreaterThan get() = this == IS_GREATER_THAN
    val isLessThan get() = this == IS_LESS_THAN
    val contains get() = this == CONTAINS
    val hasNoValue get() = this == HAS_NO_VALUE
}