package education.cccp.mobile

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class TextViewHolder(itemView: View) : ViewHolder(itemView) {
    var textView: TextView = itemView.findViewById(R.id.firstTextId)
}