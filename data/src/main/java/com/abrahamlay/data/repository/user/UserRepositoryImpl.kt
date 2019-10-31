package com.abrahamlay.data.repository.user

import com.abrahamlay.data.common.extention.applyIoScheduler
import com.abrahamlay.data.datasource.UsersDatabaseDataSource
import com.abrahamlay.data.repository.BaseRepositoryImpl
import com.abrahamlay.domain.common.ResultState
import com.abrahamlay.domain.entity.Entity
import com.abrahamlay.domain.repository.user.UserRepository
import io.reactivex.Flowable


/**
 * Created by Abraham Lay on 2019-10-30.
 */
class UserRepositoryImpl(private val databaseSource: UsersDatabaseDataSource) :
    BaseRepositoryImpl<Entity.User>(), UserRepository {
    override fun insertUser(user: Entity.User) {

        val list: MutableList<Entity.User> = mutableListOf()
        list.add(user)
        databaseSource.persist(list) {
            ResultState.Success(null)
            println("Insert Data Finished")
        }
    }

    override fun getUser(username: String, password: String): Flowable<ResultState<Entity.User>> {
        val databaseSourceFactory = databaseSource.getUser(username, password)

        return databaseSourceFactory
            .applyIoScheduler()
            .map {
                ResultState.Success(it) as ResultState<Entity.User>
            }.onErrorReturn { e ->
                ResultState.Error(e, null)
            }
    }


}
