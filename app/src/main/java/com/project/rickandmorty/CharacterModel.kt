package com.project.rickandmorty

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

 data class CharacterModel(
     @SerializedName("name")
     @Expose
     val name:String
 )
data class CharacterResult(
    @SerializedName("results")
    @Expose
    val results: MutableList<CharacterModel>
)