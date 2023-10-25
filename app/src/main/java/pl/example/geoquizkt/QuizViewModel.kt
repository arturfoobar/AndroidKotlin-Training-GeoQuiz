package pl.example.geoquizkt

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.createSavedStateHandle

private val TAG = "QuizViewModel"

const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"
const val IS_CHEATER_KEY = "IS_CHEATER_KEY"

class QuizViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    init {
        //Log.d(TAG, "Instancja QuizViewModel utworzona")
    }

    // Metoda wykonywana przy czyszczeniu VievModel
    override fun onCleared() {
        super.onCleared()
        //Log.d(TAG, "Instancja QuizViewModel zniszczona")
    }

    private var currentIndex: Int
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)

    private val questionBank = listOf(
        Question(R.string.question1_text, false),
        Question(R.string.question2_text, true),
        Question(R.string.question3_text, false),
        Question(R.string.question4_text, false),
        Question(R.string.question5_text, true)
    )

    val currentQuestionAnswer : Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText : Int
        get() = questionBank[currentIndex].textResId

    var isCheater: Boolean
        get() = savedStateHandle.get(IS_CHEATER_KEY) ?: false
        set(value) = savedStateHandle.set(IS_CHEATER_KEY, value)

    fun moveToNext () {
        currentIndex = (currentIndex + 1) % questionBank.size
    }
}