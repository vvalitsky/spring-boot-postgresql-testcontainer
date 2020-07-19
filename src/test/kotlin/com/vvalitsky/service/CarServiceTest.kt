package com.vvalitsky.service

import com.vvalitsky.AbstractTest
import com.vvalitsky.model.Car
import org.junit.Assert
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.jdbc.Sql

/**
 * Created by Vladislav Valitsky at 19.07.2020
 */

class CarServiceTest : AbstractTest() {

    @Autowired
    lateinit var carService: CarService

    @Sql(
        scripts = [
            "classpath:db/clean.sql"
        ],
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
    )
    @Test
    fun `Car creation should work well`() {
        val car = carService.createCar(
            Car(
                model = "Hilux",
                power = "10000000",
                manufacturer = "Toyota",
                acceleration = "100000000"
            )
        )
        Assert.assertNotNull(car.id)
    }

    @Sql(
        scripts = [
            "classpath:db/clean.sql",
            "classpath:db/cars_import.sql"
        ],
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
    )
    @Test
    fun `Get car by car id should work well`() {
        carService.getCarById(2L).let {
            Assert.assertEquals("Corolla", it.model)
            Assert.assertEquals("Toyota", it.manufacturer)
            Assert.assertEquals("200", it.power)
            Assert.assertEquals("600", it.acceleration)
        }

        carService.getCarById(1L).let {
            Assert.assertEquals("Hilux", it.model)
            Assert.assertEquals("Toyota", it.manufacturer)
            Assert.assertEquals("100", it.power)
            Assert.assertEquals("500", it.acceleration)
        }

        carService.getCarById(3L).let {
            Assert.assertEquals("Tundra", it.model)
            Assert.assertEquals("Toyota", it.manufacturer)
            Assert.assertEquals("400", it.power)
            Assert.assertEquals("800", it.acceleration)
        }
    }
}
