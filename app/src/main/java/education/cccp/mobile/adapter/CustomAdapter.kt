package education.cccp.mobile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import education.cccp.mobile.viewmodel.CustomViewHolder
import education.cccp.mobile.R

class CustomAdapter(private val list: List<String>) :
    RecyclerView.Adapter<CustomViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomViewHolder = CustomViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.row,
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
        holder.avatarImageView.setImageResource(R.drawable.ic_launcher_background)
    }

    override fun getItemCount() = list.size
}