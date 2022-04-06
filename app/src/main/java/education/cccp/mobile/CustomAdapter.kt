package education.cccp.mobile

import android.view.LayoutInflater.from
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import education.cccp.mobile.R.layout.row

class CustomAdapter(private val list: List<String>) :
    Adapter<TextViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TextViewHolder = TextViewHolder(
        from(parent.context).inflate(
            row,
            parent,
            false
        )
    )

    override fun onBindViewHolder(
        holder: TextViewHolder,
        position: Int
    ) {
        holder.textView.text = list[position]
    }

    override fun getItemCount() = list.size
}