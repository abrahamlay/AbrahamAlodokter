package com.abrahamlay.data.mapper

import com.abrahamlay.data.db.user.UserData
import com.abrahamlay.domain.entity.Entity

/**
 * Created by Abraham Lay on 2019-10-30.
 */

fun Entity.User.map() = UserData.User(
    id = id,
    userName = userName,
    password = password,
    picture = picture,
    gender = gender,
    phone = phone
)