package com.karmanchik.exam.javafxapp.view;

import com.karmanchik.exam.clientapi.entity.Product;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import lombok.Getter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ProductBtnModel extends Button {
    @Getter
    private final Product product;

    public ProductBtnModel(Product product) {
        this.product = product;
    }

    public ProductBtnModel build() {
        try {
            Label lbTitle = new Label(product.getTitle());
            lbTitle.setWrapText(true);
            Label lbCost = new Label(product.getCost().toString());
            lbCost.setWrapText(true);
            ImageView imageView = new ImageView(new Image(new FileInputStream("/img/" + product.getMainImagePath())));
            imageView.setFitHeight(400);
            imageView.setFitWidth(300);

            VBox box = new VBox(
                    imageView,
                    lbTitle,
                    lbCost);
            VBox.setMargin(box, new Insets(5));
            box.setAlignment(Pos.CENTER);
            this.setMaxHeight(200);
            this.setMaxWidth(200);
            this.setGraphic(
                    box
            );
            return this;
        } catch (FileNotFoundException e) {
            new Alert(AlertType.ERROR, e.getMessage(), ButtonType.OK).showAndWait();
            throw new RuntimeException(e);
        }
    }
}
