package com.alexis.redux.notifier

interface INotifyResult {
    // https://medium.com/androiddevelopers/livedata-with-snackbar-navigation-and-other-events-the-singleliveevent-case-ac2622673150
    fun consume()
    fun isConsumed(): Boolean
}