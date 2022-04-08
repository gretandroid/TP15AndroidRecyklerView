package education.cccp.mobile.viewmodel

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import education.cccp.mobile.R
import education.cccp.mobile.R.id.*

class CustomViewHolder(
    itemView: View,
    var avatarImageView: ImageView = itemView.findViewById(avatarImageId),
    var firstNameTextView: TextView = itemView.findViewById(firstNameTextViewId),
    var lastNameTextView: TextView = itemView.findViewById(lastNameTextViewId),
    var emailTextView: TextView = itemView.findViewById(emailTextViewId),
) : RecyclerView.ViewHolder(itemView)