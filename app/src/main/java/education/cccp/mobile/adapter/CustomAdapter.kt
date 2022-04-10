package education.cccp.mobile.adapter

import android.view.LayoutInflater.from
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import education.cccp.mobile.R.drawable.ic_launcher_background
import education.cccp.mobile.R.layout.row
import education.cccp.mobile.viewmodel.CustomViewHolder

class CustomAdapter(private val list: List<String>) :
    RecyclerView.Adapter<CustomViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomViewHolder = CustomViewHolder(
        itemView = from(parent.context).inflate(
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
        holder.avatarImageView.setImageResource(ic_launcher_background)
    }

    override fun getItemCount() = list.size
}