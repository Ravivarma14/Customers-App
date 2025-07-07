# Customers-App
An Jetpack Compose App

# Customer Android App

This project is a simple yet modern Android application that allows users to add customer information locally using Jetpack Compose UI and Room database. The app showcases best practices like MVVM architecture, Hilt for dependency injection, and StateFlow for reactive UI updates.

---

## Brief Description of My Approach

The app follows the **MVVM architecture** with clean separation of concerns between UI, ViewModel, Repository, and Room DAO.

- The **UI layer** is built using **Jetpack Compose**, and data is observed using **StateFlow** and `collectAsState()`.
- A **floating action button** is positioned at the bottom center of the customer list screen. On tapping, it opens a **modal bottom sheet form** to add a new customer.
- Input validation is performed before submission using a simple `Validator` utility class.
- The **Room database** is used to persist customer data locally.
- **Hilt** is used for dependency injection of the repository into the ViewModel.
- **Blue** is used as the primary color theme for branding consistency.

---

## Assumptions or Trade-offs Made

- The app stores all customer data **locally only**, assuming there is no backend API or cloud sync requirement.
- Email and phone number are validated with basic patterns, assuming that complex formatting (like country code) is not mandatory.
- The database schema is simple, with no support for updates or deletes (for simplicity).
- Compose is chosen over XML for modern UI development even though it might be newer for some teams.
- Only one screen (customer list) is included for simplicity; further features like editing or search could be added later.

---

## Steps to Build and Run the App

### Prerequisites

- Gradle **8.7**
- Android Gradle Plugin **8.4.0 or later**
- Minimum SDK: **24**
- Kotlin **1.9.0**

### 🛠 Build Steps

1. Clone the project:
   ```bash
   git clone https://github.com/yourusername/customer-manager-app.git
2. Open the project in Android Studio.

3. Sync Gradle and build the project.

4. Run the app on an emulator or physical device.



