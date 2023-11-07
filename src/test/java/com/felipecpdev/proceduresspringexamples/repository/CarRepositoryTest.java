package com.felipecpdev.proceduresspringexamples.repository;

import com.felipecpdev.proceduresspringexamples.entity.CarDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;


@SpringBootTest
class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Test
    @Transactional
    void testCallProcedure() {
        int totalCarsModel = carRepository.GET_TOTAL_CARS_BY_MODEL("Toyota");
        System.out.println(totalCarsModel);
    }

    @Test
    void testCallFunction() {
        List<Object[]> carsAfterYear = carRepository.findCarsAfterYear(2023);

        List<CarDTO> carDTOList = carsAfterYear
                .stream().map(CarDTO::new)
                .collect(Collectors.toList());

        carDTOList.forEach(carDTO ->
                System.out.println(carDTO.getModel().concat(" " + carDTO.getYear())));
    }


}