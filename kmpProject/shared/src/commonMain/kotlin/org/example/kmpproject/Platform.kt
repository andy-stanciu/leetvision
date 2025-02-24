package org.example.kmpproject

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform