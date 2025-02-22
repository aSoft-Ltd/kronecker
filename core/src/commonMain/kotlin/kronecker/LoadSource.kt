package kronecker


enum class LoadSource {
    LOCAL, REMOTE;

    fun isRemote() = this == REMOTE
    fun isLocal() = this == LOCAL
}