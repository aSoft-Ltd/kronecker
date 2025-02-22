package bitframe.filter

import kronecker.filter.DataFilterConditionCombiner
import kroneker.filter.CompoundDataFilter
import kroneker.filter.DataFilter
import kroneker.filter.DataFilterOp
import kroneker.filter.SimpleDataFilter
import kroneker.filter.SimpleListDataFilter


fun greaterThanOrEqualTo(field:String, value:String) = SimpleDataFilter(
    field=field,
    op=DataFilterOp.IS_GREATER_THAN,
    value=value,
    eField = null
).or(SimpleDataFilter(
    field=field,
    op=DataFilterOp.IS_EQUAL_TO,
    value=value,
    eField = null
)
)

fun lessThanOrEqualTo(field:String, value:String) = SimpleDataFilter(
    field=field,
    op=DataFilterOp.IS_LESS_THAN,
    value=value,
    eField = null
).or(SimpleDataFilter(
        field=field,
        op=DataFilterOp.IS_EQUAL_TO,
        value=value,
        eField = null
    )
)

fun DataFilter.and(other:DataFilter) = combine(
    combiner = DataFilterConditionCombiner.AND,
    other = other
)

fun DataFilter.or(other:DataFilter) = combine(
    combiner = DataFilterConditionCombiner.OR,
    other = other
)

fun DataFilter.combine(combiner:DataFilterConditionCombiner, other:DataFilter):DataFilter {
    return CompoundDataFilter(
        conditions = listOf(this, other),
        combiner = combiner
    )
}

fun Map<String, String>.toEqualsFilter(combiner:DataFilterConditionCombiner):SimpleListDataFilter {
    return SimpleListDataFilter(
        conditions = this.keys.map {
            SimpleDataFilter(
                field = it,
                op = DataFilterOp.IS_EQUAL_TO,
                value = this[it],
                eField = null
            )
        }.toList(),
        combiner = combiner,
    )
}