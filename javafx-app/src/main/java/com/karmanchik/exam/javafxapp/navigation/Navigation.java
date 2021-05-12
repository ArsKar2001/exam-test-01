package com.karmanchik.exam.javafxapp.navigation;

import com.karmanchik.exam.javafxapp.controller.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.FileUrlResource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class Navigation {
    private final Scene scene;
    private final ApplicationContext context;
    private final List<Controller> controllers = new ArrayList<>();


    public Navigation(Stage stage, ApplicationContext context) {
        this.context = context;
        scene = new Scene(new Pane());
        stage.setScene(scene);
    }

    public Controller loadController(String url) {
        try {
            FXMLLoader loader = new FXMLLoader(new FileUrlResource(url).getURL());
            loader.setControllerFactory(context::getBean);
            Node node = loader.load();
            Controller controller = loader.getController();
            controller.setNode(node);
            return controller;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).showAndWait();
            throw new RuntimeException(e);
        }
    }

    public void goBack() {
        if (controllers.size() > 1) {
            Controller controller = controllers.get(controllers.size() - 1);
            controllers.remove(controller);
            scene.setRoot((Parent) controllers.get(controllers.size() - 1).getNode());
        }
    }

    public void show(Controller controller) {
        scene.setRoot((Parent) controller.getNode());
        controllers.add(controller);
    }

    public void clear() {
        while (controllers.size() > 1) {
            controllers.remove(0);
        }
    }
}
