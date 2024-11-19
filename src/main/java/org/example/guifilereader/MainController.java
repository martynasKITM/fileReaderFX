package org.example.guifilereader;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MainController {
    @FXML
    private TableView<Student> tableView;
    @FXML
    private TableColumn<Student, String> nameColumn;
    @FXML
    private TableColumn<Student, String> classColumn;
    @FXML
    private TableColumn<Student, Double> gradeColumn;
    @FXML
    private Button loadFileButton;

    private final ObservableList<Student> studentData = FXCollections.observableArrayList();

    @FXML
    private void initialize(){
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        classColumn.setCellValueFactory(new PropertyValueFactory<>("studentClass"));
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));

        tableView.setItems(studentData);

        loadFileButton.setOnAction(event -> loadStudentData());
    }

    private void loadStudentData() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open student data file");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("text files", "*.txt"));
        File file = fileChooser.showOpenDialog(tableView.getScene().getWindow());

        if(file != null){
            studentData.clear();
            try(BufferedReader reader = new BufferedReader(new FileReader(file))){
                String line;
                while((line = reader.readLine()) !=null){
                    String[] parts = line.split(",");
                    if(parts.length == 3){
                        String name = parts[0].trim();
                        String studentClass = parts[1].trim();
                        double grade = Double.parseDouble(parts[2].trim());
                        studentData.add(new Student(name, studentClass, grade));
                    }
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }


    }


}
