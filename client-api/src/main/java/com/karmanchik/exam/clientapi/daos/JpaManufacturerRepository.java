package com.karmanchik.exam.clientapi.daos;

import com.karmanchik.exam.clientapi.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface JpaManufacturerRepository extends JpaRepository<Manufacturer, Integer> {
}
