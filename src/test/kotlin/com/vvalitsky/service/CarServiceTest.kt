package com.vvalitsky.service

import com.vvalitsky.AbstractTest
import com.vvalitsky.model.Car
import org.junit.Assert
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by Vladislav Valitsky at 19.07.2020
 */

class CarServiceTest : AbstractTest() {

    @Autowired
    lateinit var carService: CarService

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
}
