package com.karmanchik.exam.javafxapp.controller;

import javafx.scene.Node;

public interface Controller {
    Node getNode();
    void setNode(Node node);

    void show();
}
