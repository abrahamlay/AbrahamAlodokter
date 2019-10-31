package com.abrahamlay.data.mapper

import com.abrahamlay.data.db.user.UserData
import com.abrahamlay.domain.entity.Entity

/**
 * Created by Abraham Lay on 2019-10-30.
 */

fun UserData.User.map() = Entity.User(
    id = id,
    userName = userName,
    password = password,
    picture = picture,
    gender = gender,
    phone = phone
)