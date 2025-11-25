package io.hivebit.companion.android.viewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.hivebit.companion.android.R
import io.hivebit.companion.android.onboarding.HivebitInstance
import timber.log.Timber

class InstanceViewHolder(v: View, val onClick: (HivebitInstance) -> Unit) :
    RecyclerView.ViewHolder(v),
    View.OnClickListener {

    private val name: TextView = v.findViewById(R.id.txt_name)
    var server: HivebitInstance? = null
        set(value) {
            name.text = value?.name
            field = value
        }

    init {
        v.setOnClickListener {
            server?.let { onClick(it) }
        }
    }

    override fun onClick(v: View) {
        Timber.tag("ServerListAdapter").d("Clicked")
    }
}
