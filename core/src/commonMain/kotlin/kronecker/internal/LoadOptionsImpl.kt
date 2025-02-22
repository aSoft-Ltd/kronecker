package kronecker.internal

import kotlinx.serialization.Serializable
import kronecker.LoadOptions
import kronecker.PageOptions
import kronecker.SearchOptions
import kronecker.Sort
import kroneker.filter.DataFilter

@Serializable
@PublishedApi
internal data class LoadOptionsImpl(
    override val page: Int,
    override val limit: Int,
    override val key: String?,
    override val sorts: List<Sort>,
    override val filter: DataFilter? = null
) : LoadOptions