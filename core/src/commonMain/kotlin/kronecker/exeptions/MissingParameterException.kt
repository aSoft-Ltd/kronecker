package kronecker.exeptions

import kotlin.reflect.KProperty

class MissingParameterException(
    private val query: String,
    private val prop: KProperty<*>
) : IllegalStateException("Missing parameter ${prop.name} from query string $query")