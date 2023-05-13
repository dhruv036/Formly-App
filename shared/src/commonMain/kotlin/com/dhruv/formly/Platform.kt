package com.dhruv.formly

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform