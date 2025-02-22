package kronecker

import kroneker.filter.DataFilter

interface SearchOptions {
    val key: String?
    val filter: DataFilter?
}