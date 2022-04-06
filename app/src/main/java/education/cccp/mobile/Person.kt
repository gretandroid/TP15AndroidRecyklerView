package education.cccp.mobile

import java.io.Serializable
import java.util.*

data class Person(
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val email: String,
    val nickname:String,
) : Serializable {
    companion object {
        private const val serialVersionUID = 1L
    }
}