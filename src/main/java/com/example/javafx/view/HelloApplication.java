package com.example.javafx.view;

import com.example.javafx.DAO.DAOManager;
import com.example.javafx.DAO.DAOUsuarioSQL;
import com.example.javafx.controller.HelloController;
import com.example.javafx.models.Usuario;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        DAOManager dao = DAOManager.getSingletonInstance();
        VBox root = new VBox();
        Scene scene = new Scene(root, 620, 1005);



        // Cargar la imagen (desde el mismo paquete del proyecto o una ruta externa)
        Image imagen = new Image("https://imgs.search.brave.com/UVsVrDxEUtBg1JBKQ__0nHVLNKCCEcxfF297D_bF9SU/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9taXBj/LmNvbS5jby93cC1j/b250ZW50L3VwbG9h/ZHMvMjAyMy8wMi9M/b2dvX01pUGNfQ29t/cHV0YWRvcmVzLnBu/Zw"); // también puede ser una URL o "file:"

        // Crear un ImageView para mostrar la imagen
        ImageView imageView = new ImageView(imagen);

        // Ajustar tamaño si lo necesitas (opcional)
        imageView.setFitWidth(300);
        imageView.setPreserveRatio(true);

        // Crear el contenedor y escena
//        StackPane root1 = new StackPane(imageView);
//        Scene scene1 = new Scene(root1, 400, 400);
        HBox img = new HBox();
        img.setMaxSize(500, 500);
        img.setStyle("-fx-alignment: center;");
        img.getChildren().addAll(imageView);




        Label relojLabel = new Label();
        relojLabel.setStyle("-fx-font-size: 36px; -fx-text-fill: navy;");

        // Formato para mostrar fecha y hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern
                ("\ndd/MM/yyyy \n  HH:mm:ss");

        // Timeline que actualiza cada segundo
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0), e -> {
                    LocalDateTime ahora = LocalDateTime.now();
                    relojLabel.setText(formatter.format(ahora));
                }),
                new KeyFrame(Duration.seconds(1)) // Repite cada segundo
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        VBox reloj = new VBox();
        reloj.setStyle("-fx-alignment: center;");
        reloj.getChildren().addAll(relojLabel);



        Label label = new Label("\n\n\n\n\nIntroduce tu código (4 dígitos):\n");
        label.setStyle("-fx-font-size: 24px; -fx-text-fill: navy;");
        TextField textField = new TextField();
        textField.setMaxWidth(325);
        textField.setMinHeight(30);
        Button num1 = new Button("1");
        num1.setMinWidth(66);
        num1.setStyle("-fx-font-size: 24px; -fx-text-fill: navy;");
        num1.setOnAction(e -> {
            introduceNumKeypad("1", textField);
        });
        Button num2 = new Button("2");
        num2.setStyle("-fx-font-size: 24px; -fx-text-fill: navy;");
        num2.setMinWidth(66);
        num2.setOnAction(e -> {
            introduceNumKeypad("2", textField);
        });

        Button num3 = new Button("3");
        num3.setStyle("-fx-font-size: 24px; -fx-text-fill: navy;");
        num3.setMinWidth(66);
        num3.setOnAction(e -> {
            introduceNumKeypad("3", textField);
        });
        Button num4 = new Button("4");
        num4.setStyle("-fx-font-size: 24px; -fx-text-fill: navy;");
        num4.setMinWidth(66);
        num4.setOnAction(e -> {
            introduceNumKeypad("4", textField);
        });
        Button num5 = new Button("5");
        num5.setStyle("-fx-font-size: 24px; -fx-text-fill: navy;");
        num5.setMinWidth(66);
        num5.setOnAction(e -> {
            introduceNumKeypad("5", textField);
        });
        Button num6 = new Button("6");
        num6.setStyle("-fx-font-size: 24px; -fx-text-fill: navy;");
        num6.setMinWidth(66);
        num6.setOnAction(e -> {
            introduceNumKeypad("6", textField);
        });
        Button num7 = new Button("7");
        num7.setStyle("-fx-font-size: 24px; -fx-text-fill: navy;");
        num7.setMinWidth(66);
        num7.setOnAction(e -> {
            introduceNumKeypad("7", textField);
        });
        Button num8 = new Button("8");
        num8.setStyle("-fx-font-size: 24px; -fx-text-fill: navy;");
        num8.setMinWidth(66);
        num8.setOnAction(e -> {
            introduceNumKeypad("8", textField);
        });
        Button num9 = new Button("9");
        num9.setStyle("-fx-font-size: 24px; -fx-text-fill: navy;");
        num9.setMinWidth(66);
        num9.setOnAction(e -> {
            introduceNumKeypad("9", textField);
        });
        Button num0 = new Button("0");
        num0.setStyle("-fx-font-size: 24px; -fx-text-fill: navy;");
        num0.setMinWidth(66);
        num0.setOnAction(e -> {
            introduceNumKeypad("0", textField);
        });
        Button delete = new Button("←");
        delete.setStyle("-fx-font-size: 24px; -fx-text-fill: navy;");
        delete.setMinWidth(66);
        delete.setOnAction(e -> {
            borraNumKeypad(textField);
        });

        Button enter = new Button("↵");
        enter.setStyle("-fx-font-size: 24px; -fx-text-fill: navy;");
        enter.setMinWidth(66);


        Label message = new Label();
        message.setStyle("-fx-font-size: 24px; -fx-text-fill: navy; -fx-text-fill: #000000;");



        HBox l1 = new HBox(5);
        l1.setStyle("-fx-alignment: center;");
        l1.getChildren().addAll(num1, num2, num3);
        HBox l2 = new HBox(5);
        l2.setStyle("-fx-alignment: center;");
        l2.getChildren().addAll(num4, num5, num6);
        HBox l3 = new HBox(5);
        l3.setStyle("-fx-alignment: center;");
        l3.getChildren().addAll(num7, num8, num9);
        HBox l4 = new HBox(5);
        l4.setStyle("-fx-alignment: center;");
        l4.getChildren().addAll(enter, num0, delete);
        VBox numPad = new VBox();
        numPad.setStyle(" -fx-border-color: gray; -fx-border-width: 2px; -fx-border-radius: 5; -fx-padding: 10; -fx-background-color: lightgray;");
        numPad.setMaxWidth(204);
        numPad.getChildren().addAll(l1, l2, l3, l4);


        enter.setOnAction(actionEvent -> {
            String pin = textField.getText();
            if (!existePin(pin, dao)) {
                message.setStyle("-fx-font-size: 24px; -fx-text-fill: navy; -fx-text-fill: #FF0000;");
                message.setText("\nCódigo incorrecto");
            }else{
                if (!UsuarioEsAdmin(pin, dao)){
                    if (UsuarioTrabajando(pin, dao)) {
                        message.setText("\nFichaje de salida");
                    }
                    else message.setText("\nFichaje de entrada");
                } else{
                    ListaTrabajadores(dao, stage, scene);
                }
            }
            textField.setText("");
        });

        root.setStyle("-fx-alignment: center;");
        root.setSpacing(5);
        root.setMaxWidth(50);
        root.getChildren().addAll(img, label,textField,numPad, message, reloj);

        stage.setScene(scene);
        stage.setTitle("Sistema de control de fichaje");
        stage.show();

    }

    private void ListaTrabajadores(DAOManager dao, Stage stage, Scene scene) {

        // Cargar la imagen (desde el mismo paquete del proyecto o una ruta externa)
        Image imagen = new Image("https://imgs.search.brave.com/UVsVrDxEUtBg1JBKQ__0nHVLNKCCEcxfF297D_bF9SU/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9taXBj/LmNvbS5jby93cC1j/b250ZW50L3VwbG9h/ZHMvMjAyMy8wMi9M/b2dvX01pUGNfQ29t/cHV0YWRvcmVzLnBu/Zw"); // también puede ser una URL o "file:"

        // Crear un ImageView para mostrar la imagen
        ImageView imageView = new ImageView(imagen);

        // Ajustar tamaño si lo necesitas (opcional)
        imageView.setFitWidth(300);
        imageView.setPreserveRatio(true);

        // Crear el contenedor y escena
//        StackPane root1 = new StackPane(imageView);
//        Scene scene1 = new Scene(root1, 400, 400);
        HBox img = new HBox();
        img.setMaxSize(500, 500);
        img.setStyle("-fx-alignment: center;");
        img.getChildren().addAll(imageView);




        Label relojLabel = new Label();
        relojLabel.setStyle("-fx-font-size: 36px; -fx-text-fill: navy;");

        // Formato para mostrar fecha y hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern
                ("\ndd/MM/yyyy \n  HH:mm:ss");

        // Timeline que actualiza cada segundo
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0), e -> {
                    LocalDateTime ahora = LocalDateTime.now();
                    relojLabel.setText(formatter.format(ahora));
                }),
                new KeyFrame(Duration.seconds(1)) // Repite cada segundo
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        VBox reloj = new VBox();
        reloj.setStyle("-fx-alignment: center;");
        reloj.getChildren().addAll(relojLabel);

        Label lista = new Label();
        lista.setText("\n\n\n" + HelloController.ListaAdmin(dao) + "\n\n\n");

        Button goBack = new Button("←");
        goBack.setStyle("-fx-font-size: 24px; -fx-text-fill: navy;");
        goBack.setMinWidth(66);
        goBack.setOnAction(e -> {
            stage.setScene(scene);
            stage.setTitle("Sistema de control de fichaje - Administrador -");
            stage.show();
        });

        VBox root = new VBox();
        root.setStyle("-fx-alignment: center; -fx-font-size: 24px; -fx-text-fill: navy; -fx-text-fill: #000000;");
        root.setSpacing(5);
        root.setMaxWidth(50);
        root.getChildren().addAll(img, lista, reloj, goBack);
        Scene scene1 = new Scene(root, 620, 1005);
        stage.setScene(scene1);
        stage.setTitle("Sistema de control de fichaje - Administrador -");
        stage.show();
    }


    private boolean UsuarioEsAdmin(String pin, DAOManager dao) {
        return HelloController.UsuarioEsAdmin(pin, dao);
    }

    private void borraNumKeypad(TextField textField) {
        String textoActual = textField.getText();
        textField.setText(textoActual.substring(0,textoActual.length() - 1));
    }

    private void introduceNumKeypad(String nuevoNum, TextField textField) {
            String textoActual = textField.getText();
            textField.setText(textoActual + nuevoNum);
    }

    private boolean UsuarioTrabajando(String pin, DAOManager dao) {
        boolean trabajando = HelloController.devuelveTrabajando(pin, dao);
        cambiaTurno(dao, pin, trabajando);
        return trabajando;
    }

    private void cambiaTurno(DAOManager dao, String pin, boolean trabajando) {
        HelloController.cambioTurno(dao, pin, trabajando);
    }


    private boolean existePin(String pin, DAOManager dao) {
        return HelloController.existePin(pin, dao);
    }

    @Override
    public void init() throws Exception {
        System.out.println("init() method: " + Thread.currentThread().getName());
    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop() method: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        launch(args);
    }
}