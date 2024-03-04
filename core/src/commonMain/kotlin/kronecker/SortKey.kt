package kronecker

class SortKey(val key:String, val sorts: MutableList<Sort>) {
    fun asc() {
        sorts.add(Sort(
            by = key,
            order = Order.asc
        ))
    }

    fun dsc() {
        sorts.add(Sort(
            by = key,
            order = Order.dsc
        ))
    }
}

