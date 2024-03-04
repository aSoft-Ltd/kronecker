package kronecker

class SortBuilder(val sorts:MutableList<Sort> = mutableListOf<Sort>()) {

    fun by(key:String):SortKey = SortKey(key, sorts)


}