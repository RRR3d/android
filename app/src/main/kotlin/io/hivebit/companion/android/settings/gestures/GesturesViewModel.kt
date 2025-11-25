package io.hivebit.companion.android.settings.gestures

import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.hivebit.companion.android.common.data.prefs.PrefsRepository
import io.hivebit.companion.android.common.util.GestureAction
import io.hivebit.companion.android.common.util.HAGesture
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class GesturesViewModel @Inject constructor(private val prefsRepository: PrefsRepository) : ViewModel() {

    val gestureActions = mutableStateMapOf<HAGesture, GestureAction>()

    init {
        viewModelScope.launch {
            HAGesture.entries.forEach {
                gestureActions[it] = prefsRepository.getGestureAction(it)
            }
        }
    }

    fun setGestureAction(gesture: HAGesture, action: GestureAction) {
        viewModelScope.launch {
            prefsRepository.setGestureAction(gesture, action)
            gestureActions[gesture] = action
        }
    }
}
