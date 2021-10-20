package com.example.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class Affirmation(
    // The [@] are annotations for additional info
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int) {

}