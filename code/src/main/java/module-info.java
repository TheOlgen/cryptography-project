module pg.cyber.cyber {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens pg.cyber.cyber to javafx.fxml;
    exports pg.cyber.cyber;
}