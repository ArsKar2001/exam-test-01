package com.karmanchik.exam.javafxapp.controller;

import com.karmanchik.exam.javafxapp.StageInit;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import lombok.Getter;
import lombok.Setter;

public abstract class BaseController implements Controller, Initializable {
    @Setter
    @Getter
    private Node node;

    @Override
    public void show() {
        preShow();
        StageInit.getNavigation().show(this);
        postShow();
    }

    protected abstract void postShow();

    protected abstract void preShow();

    protected static String fxmlDirUrl() {
        return "javafx-app/src/main/resources/fxml/";
    }
}
