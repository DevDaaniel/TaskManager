# TaskManager
## Architecture Overview:

> The SignController is a component within a JavaFX-based application designed to manage user sign-in and registration functionalities for a task management system. This component is part of the graphical user interface (GUI) and is responsible for handling user interactions and navigation between different scenes.

## Usage:

    Sign-In: The SignController provides a mechanism for users to log in to the application. When the "Log In" button is clicked, the logInAction method is triggered. This method loads the login scene (FXML) and presents it to the user. The user can enter their credentials, such as a username and password, to authenticate.

    Registration: Similarly, the SignController allows users to register a new account by clicking the "Register" button. The registerAction method is invoked, loading the registration scene. Users can then provide their desired username and password to create a new account.

    Navigation: Both the sign-in and registration scenes are loaded by instantiating new Scene objects and setting them in the application's Stage. This navigation between scenes is facilitated by the Stage in JavaFX.

    User Feedback: If there are issues with the sign-in or registration process, error handling can be incorporated within the methods to provide feedback to the user, such as displaying error messages.

> The SignController encapsulates these user authentication and registration processes, ensuring a smooth and intuitive user experience in the task management application.
