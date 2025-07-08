**Keybind Launcher**

A desktop keybind manager that listens for global keyboard shortcuts using JNativeHook and manages keybind configurations using Spring Boot backend with REST APIs. The backend uses Spring Data JPA with an in-memory H2 database for storing keybinds.

**Features:**

-Global Key Listening: Uses JNativeHook to capture global keyboard shortcuts on the desktop.

-Spring Boot Backend: RESTful API server managing keybinds.

-Persistence: Keybinds stored in an H2 in-memory database using Spring Data JPA.

-Dynamic Keybind Management: Create, update, delete keybinds via REST endpoints.

-Automatic Keybind Registration: Loads and registers all keybinds on app startup.



**Technologies Used:**

-JNativeHook for global key listening

-Spring Boot (Spring Web, Spring Data JPA)

-H2 in-memory database

-REST API for keybind management
