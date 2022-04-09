package education.cccp.mobile.dao.contentprovider

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.content.ContentUris.parseId
import android.content.ContentValues
import android.database.Cursor
import education.cccp.mobile.dao.IPersonDao
import education.cccp.mobile.dao.contentprovider.PersonContentProvider.Companion.PERSON_CONTENT_URI
import education.cccp.mobile.model.Person
import education.cccp.mobile.model.Person.Companion.TABLE_PERSON_COL_EMAIL
import education.cccp.mobile.model.Person.Companion.TABLE_PERSON_COL_FIRST_NAME
import education.cccp.mobile.model.Person.Companion.TABLE_PERSON_COL_ID
import education.cccp.mobile.model.Person.Companion.TABLE_PERSON_COL_LAST_NAME
import education.cccp.mobile.model.Person.Companion.TABLE_PERSON_COL_NICKNAME
import java.lang.Long.parseLong

class PersonDaoContentProvider(
    private val contentResolver: ContentResolver
) : IPersonDao {
    private fun personToContentValues(person: Person): ContentValues =
        ContentValues().apply {
            person.apply {
                if (id != null) put(TABLE_PERSON_COL_ID, id)
                if (firstName != null) put(TABLE_PERSON_COL_FIRST_NAME, firstName)
                if (lastName != null) put(TABLE_PERSON_COL_LAST_NAME, lastName)
                put(TABLE_PERSON_COL_EMAIL, email)
                put(TABLE_PERSON_COL_NICKNAME, nickname)
            }
        }

    override fun save(person: Person): Person = person.copy(
        id = parseId(
            contentResolver.insert(
                PERSON_CONTENT_URI,
                personToContentValues(person)
            )!!
        )
    )


    @SuppressLint("Range")
    private fun cursorToPerson(cursor: Cursor?): Person? =
        cursor?.run {
            return@cursorToPerson Person(
                id = parseLong(getString(getColumnIndex(TABLE_PERSON_COL_ID))),
                email = getString(getColumnIndex(TABLE_PERSON_COL_EMAIL)),
                nickname = getString(getColumnIndex(TABLE_PERSON_COL_NICKNAME)),
                firstName = getString(getColumnIndex(TABLE_PERSON_COL_FIRST_NAME)),
                lastName = getString(getColumnIndex(TABLE_PERSON_COL_LAST_NAME))
            )
        }


    override fun findAll(): List<Person> = contentResolver.query(
        PERSON_CONTENT_URI,
        null,
        null,
        null,
        null,
        null
    ).run {
        return if (this == null) emptyList()
        else mutableListOf<Person>().apply {
            if (moveToFirst())
                do cursorToPerson(cursor = this@run)
                    .run { if (this != null) add(element = this) }
                while (moveToNext())
        }
    }


    override fun findOneById(id: Int): Person {
        TODO("Not yet implemented")
    }

    override fun findOneByEmail(email: String): Person {
        TODO("Not yet implemented")
    }

    override fun findAllByNickname(nickname: String): List<Person> {
        TODO("Not yet implemented")
    }

    override fun count(): Long {
        TODO("Not yet implemented")
    }
}