module es.localhost.javacomponent {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires org.apache.httpcomponents.httpcore;
    requires org.apache.httpcomponents.httpclient;

    opens es.localhost.javacomponent to javafx.fxml;
    exports es.localhost.javacomponent;
}