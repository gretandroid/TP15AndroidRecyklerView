package education.cccp.mobile

import android.view.LayoutInflater.from
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import education.cccp.mobile.CustomAdapter.CustomViewHolder
import education.cccp.mobile.R.layout.row

class CustomAdapter(private val list: List<String>) :
    Adapter<CustomViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomViewHolder = CustomViewHolder(
        from(parent.context).inflate(
            row,
            parent,
            false
        )
    )

    override fun onBindViewHolder(
        holder: CustomViewHolder,
        position: Int
    ) {
        holder.firstNameTextView.text = list[position]
        holder.lastNameTextView.text = list[position]
        holder.emailTextView.text = list[position]
        holder.avatarImageView.setImageResource(
//            R.drawable.ic_launcher_background
        android.R.d
        )
    }

    override fun getItemCount() = list.size

    class CustomViewHolder(
        itemView: View,
        var avatarImageView: ImageView = itemView.findViewById(R.id.avatarImageId),
        var firstNameTextView: TextView = itemView.findViewById(R.id.firstNameTextViewId),
        var lastNameTextView: TextView = itemView.findViewById(R.id.lastNameTextViewId),
        var emailTextView: TextView = itemView.findViewById(R.id.emailTextViewId),
    ) : RecyclerView.ViewHolder(itemView)

}