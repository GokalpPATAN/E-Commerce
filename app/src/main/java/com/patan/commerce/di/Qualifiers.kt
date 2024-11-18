package com.patan.commerce.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class TokenQualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class UserIdQualifier
