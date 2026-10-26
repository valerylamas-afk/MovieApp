package edu.ucb.pablostify.di

import edu.ucb.pablostify.database.getDatabaseBuilder
import edu.ucb.pablostify.database.getRoomDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

actual val platformModule = module {

    single {
        getRoomDatabase(
            getDatabaseBuilder(androidContext())
        )
    }
}