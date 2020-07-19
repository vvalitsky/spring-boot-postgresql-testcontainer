package com.vvalitsky

import com.vvalitsky.container.PostgreSQLContainerInitializer
import org.junit.runner.RunWith
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner

/**
 * Created by Vladislav Valitsky at 19.07.2020
 */

@RunWith(SpringRunner::class)
@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureMockMvc
@ContextConfiguration(
    initializers = [
        PostgreSQLContainerInitializer::class
    ]
)
abstract class AbstractTest
