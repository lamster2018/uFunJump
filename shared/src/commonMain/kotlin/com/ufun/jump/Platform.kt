package com.ufun.jump

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform