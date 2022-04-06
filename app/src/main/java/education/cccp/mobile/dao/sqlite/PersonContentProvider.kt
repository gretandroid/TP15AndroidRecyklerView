package education.cccp.mobile.dao.sqlite

import android.content.ContentProvider
import android.net.Uri
import android.content.ContentUris.withAppendedId
import android.content.ContentValues
import android.database.Cursor

import android.net.Uri.parse
import education.cccp.mobile.dao.sqlite.DatabaseHelper.Companion.BASE_CONTENT_URI

import java.lang.Long.parseLong


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

    val DatabaseHelper :DatabaseHelper
    override fun onCreate(): Boolean {
        TODO("Not yet implemented")
    }

    override fun query(
        p0: Uri,
        p1: Array<out String>?,
        p2: String?,
        p3: Array<out String>?,
        p4: String?
    ): Cursor? {
        TODO("Not yet implemented")
    }

    override fun getType(p0: Uri): String? {
        TODO("Not yet implemented")
    }

    override fun insert(p0: Uri, p1: ContentValues?): Uri? {
        TODO("Not yet implemented")
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int {
        TODO("Not yet implemented")
    }

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int {
        TODO("Not yet implemented")
    }

}