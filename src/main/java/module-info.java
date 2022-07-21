module directo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires itext;


    opens directo to javafx.fxml;
    opens domain to javafx.base;
    exports directo;
}