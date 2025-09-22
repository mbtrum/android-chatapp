package com.example.chatapp.data

import com.example.chatapp.model.Message

/**
 * SampleData for Jetpack Compose Tutorial
 */
object SampleData {
    // Sample conversation data
    val conversationSample = listOf(
        Message(
            "Yoda",
            "Test...Test...Test..."
        ),
        Message(
            "Yoda",
            """List of Android versions:
            |Android KitKat (API 19)
            |Android Lollipop (API 21)
            |Android Marshmallow (API 23)
            |Android Nougat (API 24)
            |Android Oreo (API 26)
            |Android Pie (API 28)
            |Android 10 (API 29)
            |Android 11 (API 30)
            |Android 12 (API 31)""".trim()
        ),
        Message(
            "Yoda",
            """I think Kotlin is my favorite programming language.
            |It's so much fun!""".trim()
        ),
        Message(
            "Yoda",
            "Searching for alternatives to XML layouts..."
        ),
        Message(
            "Yoda",
            """Hey, take a look at Jetpack Compose, it's great!
            |It's the Android's modern toolkit for building native UI.
            |It simplifies and accelerates UI development on Android.
            |Less code, powerful tools, and intuitive Kotlin APIs :)""".trim()
        ),
        Message(
            "Yoda",
            "It's available from API 21+ :)"
        ),
        Message(
            "Yoda",
            "Writing Kotlin for UI seems so natural, Compose where have you been all my life?"
        ),
        Message(
            "Yoda",
            "Android Studio next version's name is Arctic Fox"
        ),
        Message(
            "Yoda",
            "Android Studio Arctic Fox tooling for Compose is top notch ^_^"
        ),
        Message(
            "Yoda",
            "I didn't know you can now run the emulator directly from Android Studio"
        ),
        Message(
            "Yoda",
            "Compose Previews are great to check quickly how a composable layout looks like"
        ),
        Message(
            "Yoda",
            "Previews are also interactive after enabling the experimental setting"
        ),
        Message(
            "Yoda",
            "Have you tried writing build.gradle with KTS?"
        ),
    )
}
