package com.karmanchik.exam.javafxapp;

import com.karmanchik.exam.javafxapp.JavaFXApp.StageReadyEvent;
import com.karmanchik.exam.javafxapp.controller.MainController;
import com.karmanchik.exam.javafxapp.navigation.Navigation;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StageInit implements ApplicationListener<StageReadyEvent> {
    private final ApplicationContext context;
    private static Navigation navigation;

    private final String title;
    @Value("${javafx.app.logo}")
    private String logoPath;

    public StageInit(ApplicationContext context, @Value("${javafx.app.title}") String title) {
        this.context = context;
        this.title = title;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        Stage stage = event.getStage();
        navigation = new Navigation(stage, context);

        stage.getIcons().add(new Image(logoPath));
        stage.setMinHeight(JavaFXApp.HEIGHT);
        stage.setMinWidth(JavaFXApp.WIDTH);
        stage.setTitle(title);
        stage.show();

        StageInit.getNavigation().loadController(MainController.URL).show();
    }

    public static Navigation getNavigation() {
        return navigation;
    }
}
