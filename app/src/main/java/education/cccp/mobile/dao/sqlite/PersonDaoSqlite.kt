package education.cccp.mobile.dao.sqlite

import android.annotation.SuppressLint
import android.content.ContentUris.parseId
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.util.Log
import android.widget.Toast
import education.cccp.mobile.dao.IPersonDao
import education.cccp.mobile.dao.sqlite.PersonContentProvider.Companion.PERSON_CONTENT_URI
import education.cccp.mobile.model.Person
import education.cccp.mobile.model.Person.Companion.TABLE_PERSON_COL_EMAIL
import education.cccp.mobile.model.Person.Companion.TABLE_PERSON_COL_FIRST_NAME
import education.cccp.mobile.model.Person.Companion.TABLE_PERSON_COL_ID
import education.cccp.mobile.model.Person.Companion.TABLE_PERSON_COL_LAST_NAME
import education.cccp.mobile.model.Person.Companion.TABLE_PERSON_COL_NICKNAME
import java.lang.Long.parseLong

class PersonDaoSqlite(
    private val context: Context
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
            context.contentResolver.insert(
                PERSON_CONTENT_URI,
                personToContentValues(person)
            )!!
        )
    )


    @SuppressLint("Range")
    private fun cursorToPerson(cursor: Cursor?): Person? {
        return if (cursor == null) null
        else Person(
            id = parseLong(cursor.getString(cursor.getColumnIndex(TABLE_PERSON_COL_ID))),
            email = cursor.getString(cursor.getColumnIndex(TABLE_PERSON_COL_EMAIL)),
            nickname = cursor.getString(cursor.getColumnIndex(TABLE_PERSON_COL_NICKNAME)),
            firstName = cursor.getString(cursor.getColumnIndex(TABLE_PERSON_COL_FIRST_NAME)),
            lastName = cursor.getString(cursor.getColumnIndex(TABLE_PERSON_COL_LAST_NAME))
        )
    }

    @SuppressLint("Range")
    override fun findAll(): List<Person> {
        context.contentResolver.query(
            PERSON_CONTENT_URI,
            null,
            null,
            null,
            null,
            null
        ).run {
            if (this == null) return emptyList()
            else {
                return mutableListOf<Person>().apply {
                    if (moveToFirst()) {
                        do cursorToPerson(this@run).run {
                            if (this != null) add(this)
                        }
                        while (moveToNext())
                    }
                }
            }
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