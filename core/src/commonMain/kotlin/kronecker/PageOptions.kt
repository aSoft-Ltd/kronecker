package kronecker

import kronecker.internal.LoadOptionsImpl
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

interface PageOptions {
    val page: Int
    val limit: Int

    companion object {
        @JvmField
        val DEFAULT_PAGE = 1

        @JvmField
        val DEFAULT_LIMIT = 10

        @JvmOverloads
        @JvmName("create")
        @JvmStatic
        operator fun invoke(
            page: Int = DEFAULT_PAGE,
            limit: Int = DEFAULT_LIMIT,
        ): PageOptions = LoadOptionsImpl(page, limit, null, emptyList())
    }
}