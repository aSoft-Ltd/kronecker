package kronecker

import kronecker.internal.LoadOptionsImpl
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

interface LoadOptions : PageOptions, SearchOptions {

    companion object {
        @JvmOverloads
        @JvmName("create")
        @JvmStatic
        operator fun invoke(
            page: Int = PageOptions.DEFAULT_PAGE,
            limit: Int = PageOptions.DEFAULT_LIMIT,
            key: String? = null
        ): LoadOptions = LoadOptionsImpl(page, limit, key)
    }
}