package kronecker.internal

import kotlinx.serialization.Serializable
import kronecker.LoadOptions
import kronecker.PageOptions
import kronecker.SearchOptions

@Serializable
@PublishedApi
internal data class LoadOptionsImpl(
    override val page: Int,
    override val limit: Int,
    override val key: String?
) : LoadOptions