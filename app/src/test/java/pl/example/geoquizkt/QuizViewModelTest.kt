package pl.example.geoquizkt

import androidx.lifecycle.SavedStateHandle
import org.junit.Test

import org.junit.Assert.*

class QuizViewModelTest {

    @Test
    fun providesExpectedQuestionText() {
        val savedStateHandle = SavedStateHandle(mapOf(CURRENT_INDEX_KEY to 4))
        val quizViewModel = QuizViewModel(savedStateHandle)

        assertEquals(R.string.question5_text, quizViewModel.currentQuestionText)

        quizViewModel.moveToNext()

        assertEquals(R.string.question1_text, quizViewModel.currentQuestionText)
    }
}