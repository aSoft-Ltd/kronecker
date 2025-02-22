package kroneker.filter

import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kronecker.filter.DataFilterConditionCombiner


@Serializable
sealed interface DataFilter {
    fun render():String
}

@Serializable
class SimpleDataFilter(
    val field:String,
    val eField:String?=null,
    val op: DataFilterOp,
    val value:String?
):DataFilter {

    override fun render(): String = "${field} ${op} ${value}"

    private fun passesValue(fieldValue:String?):Boolean {
        if (fieldValue == null) {
            return op == DataFilterOp.HAS_NO_VALUE
        }

        return when(op) {
            DataFilterOp.IS_EQUAL_TO -> (fieldValue.equals(value, ignoreCase = true))
            DataFilterOp.IS_GREATER_THAN -> fieldValue.lowercase().compareTo(value?.lowercase() ?: "") > 0
            DataFilterOp.IS_LESS_THAN -> fieldValue.lowercase().compareTo(value?.lowercase() ?: "") < 0
            DataFilterOp.CONTAINS -> fieldValue.contains(value ?: "")
            DataFilterOp.HAS_NO_VALUE -> fieldValue == null
        }
    }
}

@Serializable
class CompoundDataFilter(
    val conditions: List<DataFilter>,
    val combiner: DataFilterConditionCombiner
):DataFilter {

    override fun render(): String = conditions.map {
        it.render()
    }.joinToString(separator = combiner.name)
}

@Serializable
class SimpleListDataFilter(
    val conditions: List<SimpleDataFilter>,
    val combiner: DataFilterConditionCombiner
):DataFilter {

    override fun render(): String = conditions.map {
        it.render()
    }.joinToString(separator = combiner.name)
}