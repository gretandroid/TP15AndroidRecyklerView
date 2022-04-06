package education.cccp.mobile.dao

import education.cccp.mobile.model.Person

interface IPersonDao {
    fun save(person: Person): Person

    fun findAll(): List<Person>

    fun findOneById(id: Int): Person

    fun findOneByEmail(email: String): Person

    fun findOneByNickname(nickname: String): List<Person>

    fun count(): Long
}