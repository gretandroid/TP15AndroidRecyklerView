package education.cccp.mobile.dao

import education.cccp.mobile.model.Person
import java.util.*

interface IPersonDao {
    fun save(person: Person): Person

    fun findAll(): List<Person>

    fun findOneById(id: UUID): Person

    fun findOneByEmail(email: String): Person

    fun findOneByNickname(nickname: String): Person

    fun count(): Long
}