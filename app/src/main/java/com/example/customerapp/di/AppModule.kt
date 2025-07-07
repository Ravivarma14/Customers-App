package com.example.customerapp.di

import android.content.Context
import androidx.room.Room
import com.example.customerapp.data.db.CustomerDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideCustomerDao(db: CustomerDB)  = db.customerDao()

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) : CustomerDB =
        Room.databaseBuilder(context, CustomerDB::class.java, "customer_db").build()
}