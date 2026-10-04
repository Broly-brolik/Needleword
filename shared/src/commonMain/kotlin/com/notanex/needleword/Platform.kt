package com.notanex.needleword

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform