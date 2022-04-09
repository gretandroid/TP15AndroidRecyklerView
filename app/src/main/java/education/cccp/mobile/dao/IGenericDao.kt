package education.cccp.mobile.dao

interface IGenericDao<T> {
    fun save(entity: T): T

    fun findAll(): List<T>

    fun findOneById(id: Int): T

    fun count(): Long
}