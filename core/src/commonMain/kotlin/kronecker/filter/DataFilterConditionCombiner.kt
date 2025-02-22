package kronecker.filter

enum class DataFilterConditionCombiner {
    AND,OR;

    val and get() = this == AND
    val or get() = this == AND
}