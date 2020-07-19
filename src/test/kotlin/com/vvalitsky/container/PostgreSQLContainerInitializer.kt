package com.vvalitsky.container

import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.core.io.ClassPathResource
import org.springframework.jdbc.datasource.init.ScriptUtils
import org.testcontainers.containers.PostgreSQLContainer
import java.sql.DriverManager

/**
 * Created by Vladislav Valitsky at 19.07.2020
 */

class PostgreSQLContainerInitializer : ApplicationContextInitializer<ConfigurableApplicationContext> {

    override fun initialize(configurableApplicationContext: ConfigurableApplicationContext) {
        PostgreSQLContainer<Nothing>("postgres:latest")
            .apply {
                start()
                TestPropertyValues
                    .of("spring.datasource.url=$jdbcUrl")
                    .and("spring.datasource.username=$username")
                    .and("spring.datasource.password=$password")
                    .and("spring.datasource.driver-class-name=org.postgresql.Driver")
                    .applyTo(configurableApplicationContext.environment)
                val conn = DriverManager.getConnection(jdbcUrl, username, password)
                ScriptUtils.executeSqlScript(conn, ClassPathResource("db/init/init.sql"))
            }
    }
}
