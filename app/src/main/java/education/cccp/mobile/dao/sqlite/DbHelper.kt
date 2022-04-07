package education.cccp.mobile.dao.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteOpenHelper
import education.cccp.mobile.model.Person.Companion.CREATE_TABLE_PERSON
import education.cccp.mobile.model.Person.Companion.TABLE_PERSON

class DbHelper(
    context: Context?,
    name: String?,
    factory: CursorFactory?,
    version: Int
) : SQLiteOpenHelper(
    context,
    name,
    factory,
    version
) {
    companion object {
        const val BASE_CONTENT_URI = "content://"
        const val VERSION = 1
        const val NO_URI_RESOURCE_ID_FOUND_RESULT = -1L
        const val DB_NAME = "cdh.db"
    }

    override fun onCreate(sqLiteDatabase: SQLiteDatabase) =
        sqLiteDatabase.execSQL(CREATE_TABLE_PERSON)

    override fun onUpgrade(
        sqLiteDatabase: SQLiteDatabase,
        previousVersion: Int,
        newVersion: Int
    ) = sqLiteDatabase.run {
        execSQL("DROP TABLE IF EXISTS $TABLE_PERSON")
        onCreate(sqLiteDatabase = this)
    }
}