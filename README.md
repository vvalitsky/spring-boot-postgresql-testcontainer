# spring-boot-postgresql-testcontainer

###### Official documentation about Spring -> https://spring.io
###### Official documentation about Testcontainers -> https://www.testcontainers.org

##### For run just type in your terminal this command
```

./gradlew clean --refresh-dependencies test

```

The major thing is the running of the container for testing. 
In this app we are using the Postgresql. 
So we need to override initial application yml properties just by doing this thing:
```kotlin
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
                ScriptUtils.executeSqlScript(conn, ClassPathResource("init/init.sql"))
            }
    }
}

```

This is the initializer class, which should be used in integration  tests, so we have one:

```kotlin
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

```

For controlling database changes, in this example, was used the Liquibase
###### Official documentation about Liquibase -> https://www.liquibase.org
