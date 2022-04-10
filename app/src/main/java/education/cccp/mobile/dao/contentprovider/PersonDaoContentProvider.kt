package education.cccp.mobile.dao.contentprovider

import android.content.ContentResolver
import android.content.ContentUris.parseId
import education.cccp.mobile.dao.IPersonDao
import education.cccp.mobile.dao.contentprovider.PersonContentProvider.Companion.PERSON_CONTENT_URI
import education.cccp.mobile.model.Person
import education.cccp.mobile.model.cursorToPerson
import education.cccp.mobile.model.personToContentValues

class PersonDaoContentProvider(
    private val contentResolver: ContentResolver
) : IPersonDao {

    override fun save(person: Person): Person = person.copy(
        id = parseId(
            contentResolver.insert(
                PERSON_CONTENT_URI,
                personToContentValues(person)
            )!!
        )
    )


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