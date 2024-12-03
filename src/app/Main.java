package app;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        userRepository.addUser(new User(1, "ExampleName1", "ex@gmail.com"));
        userRepository.addUser(new User(2, "ExampleName2", "ex2@gmail,com"));

        int searchId = 1;
        Optional<User> userById = userRepository.findUserById(searchId);
        userById.ifPresentOrElse(
                user -> System.out.println("User found by ID: " + user),
                () -> System.out.println("No user found with ID: " + searchId)
        );

        String searchEmail = "ex@gmail.com";
        Optional<User> userByEmail = userRepository.findUserByEmail(searchEmail);
        userByEmail.ifPresentOrElse(
                user -> System.out.println("User found by email: " + user),
                () -> System.out.println("No user found with email: " + searchEmail)
        );

        Optional<List<User>> allUsers = userRepository.findAllUsers();
        allUsers.ifPresentOrElse(
                users -> {
                    System.out.println("Number of users: " + users.size());
                    users.forEach(System.out::println);
                },
                () -> System.out.println("No users available.")
        );
    }
}
