package com.harsh.expensetracker.di

import android.app.Application
import android.content.Context
import androidx.compose.ui.platform.LocalContext
import androidx.room.Room
import androidx.room.RoomDatabase
import com.harsh.expensetracker.model.TransactionDB
import com.harsh.expensetracker.model.TransactionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTransactionDB(app : Application) : TransactionDB{
        return Room.databaseBuilder(
            app.applicationContext,
            TransactionDB::class.java,
            "Expenses_Database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTransactionRepository(db: TransactionDB) : TransactionRepository{
        return TransactionRepository(db.transactionDAO)
    }


}