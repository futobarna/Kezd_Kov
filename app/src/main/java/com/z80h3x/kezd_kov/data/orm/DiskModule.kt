package com.z80h3x.kezd_kov.data.orm

import android.content.Context
import androidx.room.Room
import com.z80h3x.kezd_kov.data.orm.daos.CharacterDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DiskModule {

    companion object {
        private const val DB_CHARACTER = "character.db"
    }

    @Provides
    @Singleton
    fun provideCharacterDatabase(context: Context): CharacterDatabase {
        return Room.databaseBuilder(
                context,
                CharacterDatabase::class.java,
                DB_CHARACTER
        )
                .fallbackToDestructiveMigration()
                .build()
    }

    @Provides
    @Singleton
    fun provideCharacterDao(characterDatabase: CharacterDatabase): CharacterDao {
        return characterDatabase.characterDao()
    }
}