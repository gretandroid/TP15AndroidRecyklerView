package education.cccp.mobile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import education.cccp.mobile.R.id.recyclerViewId
import education.cccp.mobile.R.layout.activity_main

class MainActivity : AppCompatActivity() {
    private val dataList = listOf<String>(
        "foo", "bar", "baz", "qux",
        "quux", "corge", "grault", "garply",
        "waldo", "fred", "plugh", "xyzzy", "thud"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        findViewById<RecyclerView>(recyclerViewId).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = CustomAdapter(dataList)
        }
    }
}