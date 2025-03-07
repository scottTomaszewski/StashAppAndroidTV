package com.github.damontecres.stashapp.playback

import androidx.media3.ui.PlayerView

/**
 * Since a [PlayerView] can only have one [PlayerView.ControllerVisibilityListener], this class allows for multiple by maintaining a list of them
 */
class ControllerVisibilityListenerList : PlayerView.ControllerVisibilityListener {
    private val listeners = mutableListOf<PlayerView.ControllerVisibilityListener>()

    fun addListener(listener: PlayerView.ControllerVisibilityListener) {
        listeners.add(listener)
    }

    fun removeListener(listener: PlayerView.ControllerVisibilityListener) {
        listeners.remove(listener)
    }

    fun clearListeners() {
        listeners.clear()
    }

    override fun onVisibilityChanged(visibility: Int) {
        listeners.forEach { it.onVisibilityChanged(visibility) }
    }
}
