package com.felipecpdev.proceduresspringexamples.repository;

import com.felipecpdev.proceduresspringexamples.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    /*
     *  Map a Stored Procedure Name Directly
     *  Asignar un nombre de procedimiento almacenado directamente
     * */
    @Procedure
    int GET_TOTAL_CARS_BY_MODEL(String model);

    /*
     * define a different method name
     * definir un nombre de método diferente
     * */
    @Procedure("GET_TOTAL_CARS_BY_MODEL")
    int getTotalCarsByModel(String model);

    /*
     * use the procedureName attribute to map the stored procedure name
     * utilizar el atributo procedureName para asignar el nombre del procedimiento almacenado
     * */
    @Procedure(procedureName = "GET_TOTAL_CARS_BY_MODEL")
    int getTotalCarsByModelProcedureName(String model);

    /*
     * we can use the value attribute to map the stored procedure name
     * se puede utilizar el atributo value para asignar el nombre del procedimiento almacenado
     * */
    @Procedure(value = "GET_TOTAL_CARS_BY_MODEL")
    int getTotalCarsByModelValue(String model);

    /*
     * podemos hacer referencia a la definición en la entidad (@NamedStoredProcedureQuery)
     * */
    @Procedure(name = "Car.getTotalCardsbyModelEntity")
    int getTotalCarsByModelEntity(@Param("model_in") String model);

    /*
     * También podemos llamar a una función
     * */
    @Query(value = "select * from find_cars_after_year(:year_in);", nativeQuery = true)
    List<Object[]> findCarsAfterYear(@Param("year_in") Integer year_in);
}
