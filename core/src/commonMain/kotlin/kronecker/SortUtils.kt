package kronecker

fun sort(builder: SortBuilder.()->Unit):List<Sort> = SortBuilder().apply(builder).sorts