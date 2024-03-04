package kronecker

import kronecker.exeptions.MissingParameterException
import kronecker.internal.LoadOptionsImpl
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

interface LoadOptions : PageOptions, SearchOptions, SortOptions {

    companion object {
        @JvmOverloads
        @JvmName("create")
        @JvmStatic
        operator fun invoke(
            page: Int = PageOptions.DEFAULT_PAGE,
            limit: Int = PageOptions.DEFAULT_LIMIT,
            key: String? = null,
            sorts: List<Sort> = sort {},
        ): LoadOptions = LoadOptionsImpl(page, limit, key, sorts)

        fun fromQueryStringOrNull(query: String?): LoadOptions? {
            if (query == null) return null
            if (query.isBlank()) return null
            return try {
                fromQueryString(query)
            } catch (_: Throwable) {
                null
            }
        }

        fun fromQueryString(query: String): LoadOptions {
            val splits = query.split("?")
            val string = if (splits.size > 1) {
                splits[1]
            } else splits[0]
            val params = string.split("&").associate {
                val (key, value) = it.split("=")
                key to value
            }
            return LoadOptions(
                page = params[LoadOptions::page.name]?.toIntOrNull() ?: throw MissingParameterException(query, LoadOptions::page),
                limit = params[LoadOptions::limit.name]?.toIntOrNull() ?: throw MissingParameterException(query, LoadOptions::limit),
                key = params[LoadOptions::key.name]
            )
        }
    }
}