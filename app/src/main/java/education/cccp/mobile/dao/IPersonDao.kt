package education.cccp.mobile.dao

import education.cccp.mobile.model.Person

interface IPersonDao : IGenericDao<Person> {

    override fun save(person: Person): Person

    override fun findAll(): List<Person>

    override fun findOneById(id: Int): Person

    fun findOneByEmail(email: String): Person

    fun findAllByNickname(nickname: String): List<Person>

    override fun count(): Long
}

