package kronecker

fun LoadOptions?.toQueryParams(): String {
    if (this == null) return ""
    val res = "${LoadOptions::page.name}=$page&${LoadOptions::limit.name}=$limit"
    return if (key == null) res else "$res&${LoadOptions::key.name}=$key"
}