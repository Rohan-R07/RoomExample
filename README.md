# 🗃️ Room Database Demo – Android App

This is a basic Android application demonstrating how to implement and use **Room Database** for local data storage. It's designed to help beginners understand the Room persistence library and how it fits into the MVVM architecture.

## 🎯 Features

- Add, update, delete, and view entries (e.g., user info, notes, or tasks)
- Uses Room for database operations
- Follows MVVM architecture
- Written in Kotlin
- Lifecycle-aware ViewModel support

## 🧠 Concepts Covered

- `@Entity`, `@Dao`, `@Database` annotations
- Room CRUD operations
- Flow 
- ViewModel for data persistence across configuration changes

## 📱 Technologies Used

- Kotlin
- Android Jetpack Room
- ViewModel (Jetpack)
- LiveData / Flow
- Jetpack Compose 


## 🖼️ Screenshots

Below are some screenshots of the app demonstrating Room Database in action:

### 🔸 Add Entry Screen

> This screen allows users to input data (e.g., name and age) and save it to the Room database.

![Screenshot 2025-06-21 212521](https://github.com/user-attachments/assets/98804eea-d7da-4bcb-909a-80762542bb20)


### 🔸 View Entries

> Displays all stored entries retrieved from the Room database.

![Screenshot 2025-06-21 212830](https://github.com/user-attachments/assets/9196df7c-af2d-45e2-baae-2f8cbaf81e32)


### 🔸 Update/Delete Functionality

![Update Delete](https://user-images.githubusercontent.com/yourimageid3.png)  

> Users can update records or press the delete button next to each item 'age' to remove it from the Room database.

![Screenshot 2025-06-21 213231](https://github.com/user-attachments/assets/1802ecfa-d614-4322-9723-470881f98b21)
