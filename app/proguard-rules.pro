# Nihongo Dictionary Proguard Rules
-keepattributes *Annotation*
-dontwarn okio.**

# Keep Entity and Domain models
-keep class id.nihongodictionary.app.domain.model.** { *; }
-keep class id.nihongodictionary.app.data.local.** { *; }

# Keep Navigation Routes (Kotlinx Serialization for Navigation Compose)
-keep class id.nihongodictionary.app.presentation.navigation.** { *; }
-keepclassmembers class id.nihongodictionary.app.presentation.navigation.** { *; }
