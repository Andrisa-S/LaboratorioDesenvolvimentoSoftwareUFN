package com.javafx1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Label lblNome;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtSobrenome;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onMostrarNome() {
        String nome = txtNome.getText();
        String sobrenome = txtSobrenome.getText();
        lblNome.setText(nome + " " + sobrenome);
    }
}