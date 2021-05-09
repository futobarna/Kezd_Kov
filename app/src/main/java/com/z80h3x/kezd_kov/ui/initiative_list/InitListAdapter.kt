package com.z80h3x.kezd_kov.ui.initiative_list

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
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
    private var highlightPosition: Int = 0

    interface Listener {
        fun onCharacterDelete(character: BaseCharacter)
        fun onItemSelected(id: Long)
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

        holder.characterInitiative.text = item.initiative.toString()

        if (position == highlightPosition){
            holder.characterCard.setBackgroundColor(Color.rgb(200, 255, 200))
        } else {
            holder.characterCard.setBackgroundColor(Color.WHITE)
        }

        holder.characterDelete.setOnClickListener {
            listener?.onCharacterDelete(item)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val characterName: TextView = itemView.charListName
        val characterInitiative: TextView = itemView.charListInitiative
        val characterDelete: ImageView = itemView.deleteIcon
        val characterCard: CardView = itemView.charListCard

        var item: BaseCharacter? = null

        init {
            itemView.setOnClickListener {
                item.let {
                    listener?.onItemSelected(it?.id!!)
                }
            }
        }
    }

    fun iterateHighlight(){
        highlightPosition = if (highlightPosition + 1 == itemCount) {
            0
        } else {
            highlightPosition + 1
        }
    }

    fun getHighlightPosition(): Int {
        return highlightPosition
    }

    override fun getItemId(position: Int): Long {
        return getItem(position).id!!
    }

    fun changeHighlightToOpposite() {
        highlightPosition = itemCount - highlightPosition - 1
    }
}