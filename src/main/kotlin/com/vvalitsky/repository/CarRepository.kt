package com.vvalitsky.repository

import com.vvalitsky.model.Car
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by Vladislav Valitsky at 19.07.2020
 */

@Repository
interface CarRepository : JpaRepository<Car, Long>
