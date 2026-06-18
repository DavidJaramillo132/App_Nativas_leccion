package com.david.leccion.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.david.leccion.R
//Imports for save information in detail screen
//import android.os.Parcelable
//import kotlinx.parcelize.Parcelize

//@Parcelize
data class Catalogo(
    @DrawableRes val imageResourceId: Int,
    @StringRes val  cardName: Int,
    @StringRes val name: Int,
    val price: Double,
    @StringRes val descripcion: Int
)

val ColeccionesCatalogo = listOf(
    Catalogo(R.drawable.book, R.string.book_card,R.string.book, 12.00, R.string.book_description),
    Catalogo(R.drawable.car, R.string.car_card,R.string.car, 200.00, R.string.car_description),
    Catalogo(R.drawable.controller, R.string.controller_card,R.string.controller, 70.00, R.string.controller_description),
    Catalogo(R.drawable.home, R.string.home_card, R.string.home,1000.00, R.string.controller_description),
    Catalogo(R.drawable.camping, R.string.camping_card,R.string.camping, 50.00, R.string.camping_description),
    Catalogo(R.drawable.hotel, R.string.hotel_card,R.string.hotel, 60.00, R.string.hotel_description),
    Catalogo(R.drawable.museum, R.string.museum_card,R.string.museum, 20.00, R.string.museum_description),
    Catalogo(R.drawable.toy, R.string.toy_card, R.string.toy,20.00, R.string.toy_description),
)
