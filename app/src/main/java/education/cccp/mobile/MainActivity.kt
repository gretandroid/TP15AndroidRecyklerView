package education.cccp.mobile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import education.cccp.mobile.R.id.recyclerViewId
import education.cccp.mobile.R.layout.activity_main
import education.cccp.mobile.adapter.CustomAdapter
import education.cccp.mobile.dao.IPersonDao
import education.cccp.mobile.dao.contentprovider.PersonDaoContentProvider
import education.cccp.mobile.model.metaSyntaxiqueVariables


class MainActivity : AppCompatActivity() {
    @Suppress("unused")
    private val personDao: IPersonDao by lazy {
        PersonDaoContentProvider(
            contentResolver = applicationContext.contentResolver
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        findViewById<RecyclerView>(recyclerViewId).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = CustomAdapter(metaSyntaxiqueVariables)
        }
    }
}