package com.vvalitsky.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by Vladislav Valitsky at 19.07.2020
 */

@Entity
data class Car(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column
    var model: String = "",
    @Column
    var power: String = "",
    @Column
    var manufacturer: String = "",
    @Column
    var acceleration: String = ""
)
