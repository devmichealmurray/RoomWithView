package com.devmmurray.roomwithview.data.repository

import androidx.lifecycle.LiveData
import com.devmmurray.roomwithview.data.db.WordDAO
import com.devmmurray.roomwithview.data.model.Word

class WordRepository(private val wordDao: WordDAO) {
    val allWords: LiveData<List<Word>> =
        wordDao.getAlphabetizedWords()

    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}