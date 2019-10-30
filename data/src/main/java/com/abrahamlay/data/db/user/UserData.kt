package com.abrahamlay.data.db.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Abraham Lay on 2019-10-30.
 */
sealed class UserData{

    @Entity(tableName = "user_table")
    data class User(@ColumnInfo(name = "id") @PrimaryKey(autoGenerate = false) val id: Long?,
                    @ColumnInfo(name = "username") val userName: String?,
                    @ColumnInfo(name = "password") val password: String?,
                    @ColumnInfo(name = "picture") val picture: String?,
                    @ColumnInfo(name = "gender") val gender:String?,
                    @ColumnInfo(name = "phone") val phone:String?)

}