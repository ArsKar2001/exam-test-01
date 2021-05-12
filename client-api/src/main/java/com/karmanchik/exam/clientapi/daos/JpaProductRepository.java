package com.karmanchik.exam.clientapi.daos;

import com.karmanchik.exam.clientapi.entity.Manufacturer;
import com.karmanchik.exam.clientapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface JpaProductRepository extends JpaRepository<Product, Integer> {
}
