package controllers.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.dao.UserDAO;
import model.entity.User;
import services.UserService;

public class UserCreationController{

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextArea resultArea;

    private final UserService userService;

    public UserCreationController() {
        this.userService = new UserService(new UserDAO());
    }

    @FXML
    private void handleCreateUser() {
        User newUser = new User(emailField.getText(), nameField.getText());
        try {
            userService.createUser(newUser);
            showAlert("Sucesso", "Usuário criado com sucesso!", Alert.AlertType.INFORMATION);
            clearFields();
        } catch (IllegalArgumentException e) {
            showAlert("Erro", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleUpdateUser() {
        User user = new User(emailField.getText(), nameField.getText());
        try {
            userService.updateUser(user);
            showAlert("Sucesso", "Usuário atualizado com sucesso!", Alert.AlertType.INFORMATION);
            clearFields();
        } catch (IllegalArgumentException e) {
            showAlert("Erro", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleDeleteUser() {
        User user = new User(emailField.getText(), nameField.getText());
        try {
            userService.deleteUser(user);
            showAlert("Sucesso", "Usuário deletado com sucesso!", Alert.AlertType.INFORMATION);
            clearFields();
        } catch (IllegalArgumentException e) {
            showAlert("Erro", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleFindUser() {
        User user = new User(emailField.getText(), nameField.getText());
        try {
            User foundUser = userService.findUser(user);
            if (foundUser != null) {
                resultArea.setText("Usuário encontrado:\nNome: " + foundUser.getName() +
                        "\nEmail: " + foundUser.getEmail());
            } else {
                resultArea.setText("Usuário não encontrado.");
            }
        } catch (IllegalArgumentException e) {
            showAlert("Erro", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleFindAllUsers() {
        StringBuilder sb = new StringBuilder();
        for (User u : userService.findAllUsers()) {
            sb.append("Nome: ").append(u.getName()).append(" | Email: ").append(u.getEmail()).append("\n");
        }
        resultArea.setText(sb.length() > 0 ? sb.toString() : "Nenhum usuário cadastrado.");
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        nameField.clear();
        emailField.clear();
    }
}
