package education.cccp.mobile.viewmodel

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import education.cccp.mobile.R

class CustomViewHolder(
    itemView: View,
    var avatarImageView: ImageView = itemView.findViewById(R.id.avatarImageId),
    var firstNameTextView: TextView = itemView.findViewById(R.id.firstNameTextViewId),
    var lastNameTextView: TextView = itemView.findViewById(R.id.lastNameTextViewId),
    var emailTextView: TextView = itemView.findViewById(R.id.emailTextViewId),
) : RecyclerView.ViewHolder(itemView)