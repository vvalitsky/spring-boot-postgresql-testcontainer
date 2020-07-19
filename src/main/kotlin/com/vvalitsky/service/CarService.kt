package com.vvalitsky.service

import com.vvalitsky.model.Car

/**
 * Created by Vladislav Valitsky at 19.07.2020
 */

interface CarService {
    fun getCarById(carId: Long): Car
    fun createCar(car: Car): Car
}
