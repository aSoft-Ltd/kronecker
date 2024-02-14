package kronecker

fun LoadOptions?.toQueryParams(): String {
    if (this == null) return ""
    val res = "${LoadOptions::page.name}=$page&${LoadOptions::limit.name}=$limit"
    return if (key == null) res else "$res&${LoadOptions::key.name}=$key"
}

fun LoadOptions?.toQueryParams(prefix: String): String {
    if (this == null) return ""
    return "$prefix${toQueryParams()}"
}