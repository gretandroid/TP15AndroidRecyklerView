package education.cccp.mobile.dao

import android.content.Entity

interface IGenericDao<T> {
    fun save(entityType: T): T

    fun findAll(): List<T>

    fun findOneById(id: Int): T

    fun count(): Long
}