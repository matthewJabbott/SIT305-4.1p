# SIT305-4.1p

An Android application built with Kotlin and Jetpack Compose for the SIT305 course assignment 4.1p.

## Project Overview

This is a modern Android application developed using contemporary Android development practices and technologies. The project demonstrates the implementation of core Android components including data persistence, UI composition, and navigation.

## Technology Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Build System**: Gradle (Kotlin DSL)
- **Database**: Room Database (SQLite)
- **Navigation**: Jetpack Navigation Compose
- **Target SDK**: Android 35 (API Level 35)
- **Minimum SDK**: Android 7.0 (API Level 24)

## Architecture & Dependencies

### Core Android Libraries
- **androidx.core**: Core Android utilities
- **androidx.lifecycle**: Lifecycle management
- **androidx.appcompat**: App Compatibility support
- **Material Design 3**: Latest Material Design components

### Jetpack Libraries
- **Jetpack Compose**: Modern declarative UI framework
- **Compose UI**: Core UI components and layouts
- **Jetpack Navigation**: Fragment and Compose navigation
- **Lifecycle & ViewModel**: Lifecycle-aware component management

### Database
- **Room**: Type-safe database abstraction layer
  - Runtime: 2.6.1
  - Kotlin extensions and compiler support included

### Testing
- **JUnit**: Unit testing framework
- **Espresso**: UI testing framework
- **AndroidJUnit**: Android testing utilities

## Build Configuration

- **Compile SDK**: 35
- **Java Compatibility**: Java 11
- **Kotlin JVM Target**: 11
- **ProGuard**: Enabled for release builds

## Getting Started

### Prerequisites
- Android Studio (latest stable version)
- Java 11 or higher
- Gradle 8.x

### Building the Project

1. Clone the repository:
   ```bash
   git clone https://github.com/matthewJabbott/SIT305-4.1p.git
   cd SIT305-4.1p

    Build the project:
    bash

    ./gradlew build

    Run the application:
    bash

    ./gradlew installDebug

Project Structure
Code

SIT305-4.1p/
├── app/                          # Application module
│   ├── src/
│   │   ├── main/                # Main application code
│   │   │   ├── java/            # Kotlin source files
│   │   │   ├── res/             # Resources (layouts, strings, etc.)
│   │   │   └── AndroidManifest.xml
│   │   └── test/                # Unit tests
│   ├── build.gradle.kts         # App module build configuration
│   └── schemas/                 # Room database schemas
├── gradle/                       # Gradle wrapper
├── build.gradle.kts             # Root build configuration
├── settings.gradle.kts          # Gradle settings
└── README.md                     # This file

Database Schema

Room database schemas are automatically generated and stored in the app/schemas/ directory during build compilation.
Development Notes

    The project uses Kotlin code style set to "official" standards
    AndroidX is enabled for all Compose and modern Android components
    Jetifier is enabled for backward compatibility with legacy dependencies
    Built-in Kotlin support is utilized for the latest language features

Testing

Run tests using:
bash

./gradlew test
./gradlew connectedAndroidTest

License

This project is part of the SIT305 course curriculum.
Author

Matthew Jabbott
