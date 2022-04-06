package education.cccp.mobile.dao.sqlite

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.net.Uri.parse
import education.cccp.mobile.dao.sqlite.DatabaseHelper.Companion.BASE_CONTENT_URI
import education.cccp.mobile.dao.sqlite.DatabaseHelper.Companion.DB_NAME
import education.cccp.mobile.dao.sqlite.DatabaseHelper.Companion.VERSION


class PersonContentProvider : ContentProvider() {
    companion object {
        @JvmStatic
        val PERSON_CONTENT_URI by lazy {
            parse(
                BASE_CONTENT_URI +
                        PersonContentProvider::class.java.name
            )
        }
    }
    lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(): Boolean {
        databaseHelper = DatabaseHelper(
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
        TODO("Not yet implemented")
    }

    override fun getType(uri: Uri): String? {
        TODO("Not yet implemented")
    }

    override fun insert(uri: Uri, contentValues: ContentValues?): Uri? {
        TODO("Not yet implemented")
    }

    override fun delete(
        p0: Uri,
        p1: String?,
        p2: Array<out String>?
    ): Int {
        TODO("Not yet implemented")
    }
/*
  public int update(@NonNull Uri uri,
                      @Nullable ContentValues contentValues,
                      @Nullable String s,
                      @Nullable String[] strings)
 */
    override fun update(
    uri: Uri,
    contentValues: ContentValues?,
    p2: String?,
    p3: Array<out String>?
): Int {
        TODO("Not yet implemented")
    }

}