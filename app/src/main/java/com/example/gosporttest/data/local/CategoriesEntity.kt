package com.example.gosporttest.data.local

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class CategoryEntity: RealmObject {
    @PrimaryKey
    var idCategory: String = ""
    var strCategory: String? = null
    var strCategoryThumb: String? = null
    var strCategoryDescription: String? = null
}