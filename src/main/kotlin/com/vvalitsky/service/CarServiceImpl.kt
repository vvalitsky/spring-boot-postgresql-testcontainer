package com.vvalitsky.service

import com.vvalitsky.model.Car
import com.vvalitsky.repository.CarRepository
import org.springframework.stereotype.Service

/**
 * Created by Vladislav Valitsky at 19.07.2020
 */

@Service
class CarServiceImpl(
    private val carRepository: CarRepository
) : CarService {

    override fun getCarById(carId: Long): Car {
        return carRepository.getOne(carId)
    }

    override fun createCar(car: Car): Car {
        return carRepository.save(car)
    }
}
