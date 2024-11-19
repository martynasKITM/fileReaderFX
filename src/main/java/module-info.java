module org.example.guifilereader {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.guifilereader to javafx.fxml;
    exports org.example.guifilereader;
}