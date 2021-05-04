package com.z80h3x.kezd_kov.ui.initiative_list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.z80h3x.kezd_kov.R
import com.z80h3x.kezd_kov.data.generic.BaseCharacter
import kotlinx.android.synthetic.main.fragment_character_row.view.*

class InitListAdapter(
    private val context: Context
) :
    ListAdapter<BaseCharacter, InitListAdapter.ViewHolder>(CharacterComparator) {

    var listener: Listener? = null

    interface Listener {
        fun onCharacterDelete(id: Long)
    }

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ) : InitListAdapter.ViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(
                        R.layout.fragment_character_row,
                        parent,
                        false
                )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: InitListAdapter.ViewHolder, position: Int) {
        val item = getItem(position)

        holder.item = item

        holder.characterName.text = item.name

        holder.characterInitative.text = item.initiative.toString()

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val characterName: TextView = itemView.charListName
        val characterInitative: TextView = itemView.charListInitiative
        val characterOptions: ImageView = itemView.moreIcon

        var item: BaseCharacter? = null
    }
}