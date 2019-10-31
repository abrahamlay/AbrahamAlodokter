package com.abrahamlay.abrahamalodokter.di

import com.abrahamlay.data.repository.user.UserRepositoryImpl
import com.abrahamlay.domain.repository.user.UserRepository
import com.abrahamlay.domain.usecase.user.GetUserUseCase
import com.abrahamlay.domain.usecase.user.GetUserUseCaseImpl
import com.abrahamlay.domain.usecase.user.InsertUserUseCase
import com.abrahamlay.domain.usecase.user.InsertUserUseCaseImpl
import ir.hosseinabbasi.presentation.common.transformer.AsyncSTransformer
import org.koin.dsl.module

/**
 * Created by Abraham Lay on 2019-10-30.
 */

val useCaseModule = module {
    factory<UserRepository> { UserRepositoryImpl(get()) }
    factory<GetUserUseCase> { GetUserUseCaseImpl(AsyncSTransformer(),get()) }
    factory<InsertUserUseCase> { InsertUserUseCaseImpl(AsyncSTransformer(),get()) }
}