package org.shivvu.musico

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform