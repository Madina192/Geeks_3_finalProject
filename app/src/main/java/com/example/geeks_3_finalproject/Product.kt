package com.example.geeks_3_finalproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
class Product (val name : String,
               val image : Int,
               val discount : Boolean,
               val rate: Double,
               val parts : Int,
               val place : String,
               val category : String,
               val delivery : String,
               val minPrice : String,
               val time : String,
               val distance : String
               ) : Parcelable