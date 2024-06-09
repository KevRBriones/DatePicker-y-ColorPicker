package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    private DatePicker datePicker;
    private ColorPicker colorPicker;
    private Label resultLabel;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Selector de Fecha y Color");

        // Crear el layout vertical
        VBox vbox = new VBox(15);  // 15 es el espacio entre los elementos
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));

        // DatePicker
        Label dateLabel = new Label("Selecciona una fecha:");
        datePicker = new DatePicker();
        vbox.getChildren().addAll(dateLabel, datePicker);

        // ColorPicker
        Label colorLabel = new Label("Selecciona un color:");
        colorPicker = new ColorPicker();
        vbox.getChildren().addAll(colorLabel, colorPicker);

        // Botón de confirmación
        Button confirmButton = new Button("Confirmar Selección");
        confirmButton.setOnAction(e -> handleConfirmation());
        vbox.getChildren().add(confirmButton);

        // Label para mostrar el resultado
        resultLabel = new Label("Esperando selección...");
        vbox.getChildren().add(resultLabel);

        // Crear la escena
        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleConfirmation() {
        String selectedDate = datePicker.getValue().toString();
        Color selectedColor = colorPicker.getValue();

        // Convertir el color a formato hexadecimal
        String hexColor = String.format("#%02X%02X%02X",
                (int) (selectedColor.getRed() * 255),
                (int) (selectedColor.getGreen() * 255),
                (int) (selectedColor.getBlue() * 255));

        // Mostrar la selección en la consola
        System.out.println("Fecha seleccionada: " + selectedDate);
        System.out.println("Color seleccionado (hex): " + hexColor);

        // Mostrar la selección en la interfaz
        resultLabel.setText("Fecha: " + selectedDate + "\nColor: " + hexColor);
    }

    public static void main(String[] args) {
        launch(args);
    }
}