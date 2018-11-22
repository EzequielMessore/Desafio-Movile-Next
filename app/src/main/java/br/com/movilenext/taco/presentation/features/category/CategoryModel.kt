package br.com.movilenext.taco.presentation.features.category

import android.os.Parcelable
import br.com.movilenext.taco.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoryModel(val id: Int, val name: String) : Parcelable {

    fun getImage(): Int =
        when (id) {
            1 -> R.drawable.img_cere
            2 -> R.drawable.img_vegetables
            3 -> R.drawable.img_fruits
            4 -> R.drawable.img_oil
            5 -> R.drawable.img_fish
            6 -> R.drawable.img_beef
            7 -> R.drawable.img_milk
            8 -> R.drawable.img_drink
            9 -> R.drawable.img_eggs
            else -> R.mipmap.ic_launcher
        }
}