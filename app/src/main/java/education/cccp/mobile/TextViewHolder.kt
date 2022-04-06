package education.cccp.mobile

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import education.cccp.mobile.R.id.firstTextId

class TextViewHolder(
    itemView: View,
    var textView: TextView = itemView.findViewById(firstTextId)
) : ViewHolder(itemView)