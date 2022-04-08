package education.cccp.mobile.dao.sqlite

import android.content.ContentProvider
import android.content.ContentUris.withAppendedId
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.net.Uri.parse
import education.cccp.mobile.dao.sqlite.DbHelper.Companion.BASE_CONTENT_URI
import education.cccp.mobile.dao.sqlite.DbHelper.Companion.DB_NAME
import education.cccp.mobile.dao.sqlite.DbHelper.Companion.NO_URI_RESOURCE_ID_FOUND_RESULT
import education.cccp.mobile.dao.sqlite.DbHelper.Companion.VERSION
import education.cccp.mobile.model.Person.Companion.TABLE_PERSON
import education.cccp.mobile.model.Person.Companion.TABLE_PERSON_COL_ID


class PersonContentProvider : ContentProvider() {
    companion object {
        @JvmStatic
        val PERSON_CONTENT_URI: Uri by lazy {
            parse(
                BASE_CONTENT_URI +
                        PersonContentProvider::class.java.name
            )
        }
        lateinit var dbHelper: DbHelper
    }

    override fun onCreate(): Boolean {
        dbHelper = DbHelper(
            context = context,
            name = DB_NAME,
            factory = null,
            version = VERSION
        )
        return true
    }

    override fun query(
        uri: Uri,
        columns: Array<out String>?,
        selection: String?,
        arguments: Array<out String>?,
        sort: String?
    ): Cursor? {
        dbHelper.readableDatabase.apply {
            getId(uri).apply {
                return query(
                    TABLE_PERSON,
                    columns,
                    if (this < 0) selection else "$TABLE_PERSON_COL_ID = $this",
                    arguments,
                    null,
                    null,
                    sort
                )
            }
        }
    }

    override fun getType(uri: Uri): String? = null

    override fun insert(
        uri: Uri,
        contentValues: ContentValues?
    ): Uri? {
        dbHelper.writableDatabase.use {
            it.insertOrThrow(
                TABLE_PERSON,
                null,
                contentValues
            ).run {
                return if (this == -1L)
                    throw RuntimeException("Failed insertion")
                else withAppendedId(uri, this)
            }
        }
    }

    override fun delete(
        uri: Uri,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int = dbHelper.writableDatabase.run {
        delete(TABLE_PERSON, selection, selectionArgs).apply {
            return if (this == -1)
                throw RuntimeException("Failed Update")
            else this
        }
    }

    override fun update(
        uri: Uri,
        contentValues: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int =dbHelper.writableDatabase.run {
        update(TABLE_PERSON, contentValues, selection,selectionArgs).apply {
            return if (this == -1)
                throw RuntimeException("Failed Update")
            else this
        }
    }
    private fun getId(uri: Uri): Long =
        uri.lastPathSegment
            ?.toLong() ?: NO_URI_RESOURCE_ID_FOUND_RESULT
}