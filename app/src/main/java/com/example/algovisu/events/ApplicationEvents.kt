package com.example.algovisu.events

sealed class ApplicationEvents {
    object slowDown : ApplicationEvents()
    object speedUp : ApplicationEvents()
    object playPause : ApplicationEvents()
    object prev : ApplicationEvents()
    object next : ApplicationEvents()
}
