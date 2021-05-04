package com.z80h3x.kezd_kov.ui.initiative_list

import androidx.recyclerview.widget.DiffUtil
import com.z80h3x.kezd_kov.data.generic.BaseCharacter

object CharacterComparator : DiffUtil.ItemCallback<BaseCharacter>() {
    override fun areItemsTheSame(oldItem: BaseCharacter, newItem: BaseCharacter): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BaseCharacter, newItem: BaseCharacter): Boolean {
        return oldItem == newItem
    }

}