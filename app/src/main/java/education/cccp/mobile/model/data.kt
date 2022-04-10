package education.cccp.mobile.model

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.Cursor
import education.cccp.mobile.dao.IPersonDao
import education.cccp.mobile.model.Person.Companion.TABLE_PERSON_COL_FIRST_NAME
import education.cccp.mobile.model.Person.Companion.TABLE_PERSON_COL_ID
import education.cccp.mobile.model.Person.Companion.TABLE_PERSON_COL_LAST_NAME
import java.lang.Long.parseLong

@Suppress("unused")
val metaSyntaxiqueVariables: List<String>
    get() = listOf(
        "foo",
        "bar",
        "baz",
        "qux",
        "quux",
        "corge",
        "grault",
        "garply",
        "waldo",
        "fred",
        "plugh",
        "xyzzy",
        "thud"
    )

val metaSyntaxiquePeoples: List<Map<String, String>>
    get() = listOf(
        mapOf(pair = "Ashok" to "Kumar"),
        mapOf(pair = "Baby" to "Doe"),
        mapOf(pair = "Brett" to "Boe"),
        mapOf(pair = "Carla" to "Coe"),
        mapOf(pair = "Donna" to "Doe"),
        mapOf(pair = "Frank" to "Foe"),
        mapOf(pair = "Grace" to "Goe"),
        mapOf(pair = "Harry" to "Hoe"),
        mapOf(pair = "Jackie" to "Joe"),
        mapOf(pair = "Jane" to "Doe"),
        mapOf(pair = "Jane" to "Poe"),
        mapOf(pair = "Jane" to "Roe"),
        mapOf(pair = "Joe" to "Bloggs"),
        mapOf(pair = "Joe" to "Public"),
        mapOf(pair = "John" to "Doe"),
        mapOf(pair = "John" to "Noakes"),
        mapOf(pair = "John" to "Nokes"),
        mapOf(pair = "John" to "Public"),
        mapOf(pair = "John" to "Smith"),
        mapOf(pair = "John" to "Stiles"),
        mapOf(pair = "Juan" to "Doe"),
        mapOf(pair = "Karren" to "Koe"),
        mapOf(pair = "Larry" to "Loe"),
        mapOf(pair = "Mark" to "Moe"),
        mapOf(pair = "Marta" to "Moe"),
        mapOf(pair = "Mary" to "Major"),
        mapOf(pair = "Norma" to "Noe"),
        mapOf(pair = "Paula" to "Poe"),
        mapOf(pair = "Quintin" to "Qoe"),
        mapOf(pair = "Ralph" to "Roe"),
        mapOf(pair = "Richard" to "Miles"),
        mapOf(pair = "Robert" to "Roe"),
        mapOf(pair = "Sammy" to "Soe"),
        mapOf(pair = "Tommy" to "Toe"),
        mapOf(pair = "Vince" to "Voe"),
        mapOf(pair = "William" to "Woe"),
        mapOf(pair = "Xerxes" to "Xoe"),
        mapOf(pair = "Yvonne" to "Yoe"),
        mapOf(pair = "Zachery" to "Zoe")
    )

@Suppress("unused")
val generatedPersons: List<Person>
    get() = metaSyntaxiquePeoples.map {
        Person(
            id = null,
            firstName = it.keys.first(),
            lastName = it.values.first(),
            email = "${it.keys.first().lowercase()}.${it.values.first().lowercase()}@acme.com",
            nickname = "${it.keys.first().lowercase()}.${it.values.first().lowercase()}"
        )
    }

fun personToContentValues(person: Person): ContentValues =
    ContentValues().apply {
        person.apply {
            if (id != null) put(TABLE_PERSON_COL_ID, id)
            if (firstName != null) put(TABLE_PERSON_COL_FIRST_NAME, firstName)
            if (lastName != null) put(TABLE_PERSON_COL_LAST_NAME, lastName)
            put(Person.TABLE_PERSON_COL_EMAIL, email)
            put(Person.TABLE_PERSON_COL_NICKNAME, nickname)
        }
    }

@SuppressLint("Range")
fun cursorToPerson(cursor: Cursor?): Person? =
    cursor?.run {
        return@cursorToPerson Person(
            id = parseLong(getString(getColumnIndex(TABLE_PERSON_COL_ID))),
            email = getString(getColumnIndex(Person.TABLE_PERSON_COL_EMAIL)),
            nickname = getString(getColumnIndex(Person.TABLE_PERSON_COL_NICKNAME)),
            firstName = getString(getColumnIndex(TABLE_PERSON_COL_FIRST_NAME)),
            lastName = getString(getColumnIndex(TABLE_PERSON_COL_LAST_NAME))
        )
    }

fun populateDataBase(personDao: IPersonDao): List<Person> = generatedPersons.map(personDao::save)

//val generatedPersonsContentValues: List<ContentValues>
//    get() = generatedPersons.map {
//        personToContentValues(it)
//    }

