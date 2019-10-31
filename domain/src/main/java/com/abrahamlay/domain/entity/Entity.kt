package com.abrahamlay.domain.entity

/**
 * Created by Abraham Lay on 2019-10-30.
 */

sealed class Entity {
    data class User(
        val id: Long?,
        val userName: String?,
        val password: String?,
        val picture: String?,
        val gender: String?,
        val phone: String?
    ) : Entity()
}