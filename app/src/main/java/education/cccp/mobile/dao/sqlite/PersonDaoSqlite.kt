package education.cccp.mobile.dao.sqlite

import android.content.ContentUris.parseId
import android.content.ContentValues
import education.cccp.mobile.dao.IPersonDao
import education.cccp.mobile.dao.sqlite.PersonContentProvider.Companion.PERSON_CONTENT_URI
import education.cccp.mobile.model.Person
import education.cccp.mobile.model.Person.Companion.TABLE_PERSON_COL_EMAIL
import education.cccp.mobile.model.Person.Companion.TABLE_PERSON_COL_FIRST_NAME
import education.cccp.mobile.model.Person.Companion.TABLE_PERSON_COL_ID
import education.cccp.mobile.model.Person.Companion.TABLE_PERSON_COL_LAST_NAME
import education.cccp.mobile.model.Person.Companion.TABLE_PERSON_COL_NICKNAME

class PersonDaoSqlite(
    private val personContentProvider: PersonContentProvider = PersonContentProvider()
) : IPersonDao {

    private fun personToContentValues(person: Person): ContentValues =
        ContentValues().apply {
            person.apply {
                if (id != null) put(TABLE_PERSON_COL_ID, id)
                if (firstName != null) put(TABLE_PERSON_COL_FIRST_NAME, firstName)
                if (lastName != null) put(TABLE_PERSON_COL_LAST_NAME, lastName)
                if (email != null) put(TABLE_PERSON_COL_EMAIL, email)
                if (nickname != null) put(TABLE_PERSON_COL_NICKNAME, nickname)
            }
        }

    override fun save(person: Person): Person =
        person.copy(
            id = parseId(
                personContentProvider.insert(
                    PERSON_CONTENT_URI,
                    personToContentValues(person)
                )!!
            )
        )

    override fun findAll(): List<Person> {

        TODO("Not yet implemented")
    }

    override fun findOneById(id: Int): Person {
        TODO("Not yet implemented")
    }

    override fun findOneByEmail(email: String): Person {
        TODO("Not yet implemented")
    }

    override fun findOneByNickname(nickname: String): List<Person> {
        TODO("Not yet implemented")
    }

    override fun count(): Long {
        TODO("Not yet implemented")
    }
}