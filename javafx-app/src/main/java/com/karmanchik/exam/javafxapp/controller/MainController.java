package com.karmanchik.exam.javafxapp.controller;

import com.karmanchik.exam.clientapi.daos.JpaManufacturerRepository;
import com.karmanchik.exam.clientapi.daos.JpaProductRepository;
import com.karmanchik.exam.clientapi.entity.Product;
import com.karmanchik.exam.javafxapp.view.ProductBtnModel;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Log4j2
@Component
public class MainController extends BaseController {
    public static final String URL = fxmlDirUrl() + "main.fxml";

    private final JpaManufacturerRepository manufacturerRep;
    private final JpaProductRepository productRepository;

    public HBox productHBox;

    public MainController(JpaManufacturerRepository manufacturerRep, JpaProductRepository productRepository) {
        this.manufacturerRep = manufacturerRep;
        this.productRepository = productRepository;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        log.info(url);
        loadProduct();
    }

    private void loadProduct() {
        List<Product> products = productRepository.findAll();
        products.forEach(product -> {
            productHBox.getChildren().add(new ProductBtnModel(product).build());
        });
    }

    @Override
    protected void postShow() {

    }

    @Override
    protected void preShow() {

    }
}
