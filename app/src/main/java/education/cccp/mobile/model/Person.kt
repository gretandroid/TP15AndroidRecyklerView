package education.cccp.mobile.model

import java.io.Serializable

data class Person(
    val id: Long?,
    val firstName: String?,
    val lastName: String?,
    val email: String,
    val nickname: String,
) : Serializable {
    companion object {
        private const val serialVersionUID = 1L
        const val TABLE_PERSON = "table_person"
        const val TABLE_PERSON_COL_ID = "id"
        const val TABLE_PERSON_COL_FIRST_NAME = "first_name"
        const val TABLE_PERSON_COL_LAST_NAME = "last_name"
        const val TABLE_PERSON_COL_EMAIL = "email"
        const val TABLE_PERSON_COL_NICKNAME = "nickname"

        const val CREATE_TABLE_PERSON =
            """CREATE TABLE $TABLE_PERSON 
                |($TABLE_PERSON_COL_ID INTEGER PRIMARY KEY AUTOINCREMENT, 
                |$TABLE_PERSON_COL_FIRST_NAME TEXT NOT NULL, 
                |$TABLE_PERSON_COL_LAST_NAME TEXT NOT NULL
                |$TABLE_PERSON_COL_NICKNAME TEXT NOT NULL,
                |$TABLE_PERSON_COL_EMAIL TEXT NOT NULL
                |);"""
    }
}