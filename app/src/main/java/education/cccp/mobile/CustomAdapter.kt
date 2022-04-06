package education.cccp.mobile

import android.view.LayoutInflater.from
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import education.cccp.mobile.R.drawable.ic_launcher_background
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
        holder.avatarImageView.setImageResource(ic_launcher_background)
    }

    override fun getItemCount() = list.size
}