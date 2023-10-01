abstract class Vehicle() {
    abstract val name: String
    abstract val velocity: Int
    abstract val fuelType: Fuel

    fun passport() {
        println("${name}, ${velocity}, ${fuelType}")
    }

    abstract fun move(): String
}

enum class Fuel() {
    GAS() {
        override fun toString(): String {
            return "Gas"
        }
          },
    DIESEL() {
        override fun toString(): String {
            return "Diesel"
        }
             },
    KEROSENE() {
        override fun toString(): String {
            return "Kerosene"
        }
    }
}

sealed class Car(name: String, velocity: Int, fuelType: Fuel): Vehicle() {
    override val name: String = name
    override val velocity: Int = velocity
    override val fuelType: Fuel = fuelType

    override fun move(): String {
        return "$name car is moving at $velocity km/h using $fuelType fuel."
    }
}

sealed class Airplane(name: String, velocity: Int, fuelType: Fuel): Vehicle() {
    override val name: String = name
    override val velocity: Int = velocity
    override val fuelType: Fuel = fuelType

    override fun move(): String {
        return "$name airplane is moving at $velocity km/h using $fuelType fuel."
    }
}

class CommercialAirplane(name: String, velocity: Int, fuelType: Fuel) : Airplane(name, velocity, fuelType) {
    override fun move(): String {
        return "$name (Commercial Airplane) is flying at $velocity km/h using $fuelType fuel."
    }
}

class PrivateJet(name: String, velocity: Int, fuelType: Fuel) : Airplane(name, velocity, fuelType) {
    override fun move(): String {
        return "$name (Private Jet) is flying at $velocity km/h using $fuelType fuel."
    }
}

class CargoPlane(name: String, velocity: Int, fuelType: Fuel) : Airplane(name, velocity, fuelType) {
    override fun move(): String {
        return "$name (Cargo Plane) is transporting goods at $velocity km/h using $fuelType fuel."
    }
}

class Sedan(name: String, velocity: Int, fuelType: Fuel) : Car(name, velocity, fuelType) {
    override fun move(): String {
        return "$name (Sedan) is moving at $velocity km/h using $fuelType fuel."
    }
}

class SUV(name: String, velocity: Int, fuelType: Fuel) : Car(name, velocity, fuelType) {
    override fun move(): String {
        return "$name (SUV) is moving at $velocity km/h using $fuelType fuel."
    }
}

class SportsCar(name: String, velocity: Int, fuelType: Fuel) : Car(name, velocity, fuelType) {
    override fun move(): String {
        return "$name (Sports Car) is racing at $velocity km/h using $fuelType fuel."
    }
}

fun main() {
    while (true) {
        println("Select an option:")
        println("1. Create a Car")
        println("2. Create an Airplane")
        println("3. Exit")

        val choice = readLine()?.toIntOrNull()

        when (choice) {
            1 -> {
                createAndOperateCar()
            }
            2 -> {
                createAndOperateAirplane()
            }
            3 -> {
                return
            }
            else -> {
                println("Invalid choice. Please select a valid option.")
            }
        }
    }
}

fun createAndOperateCar() {
    println("Select car type:")
    println("1. Sedan")
    println("2. SUV")
    println("3. Sports Car")

    val carTypeChoice = readLine()?.toIntOrNull()

    val carType: Vehicle = when (carTypeChoice) {
        1 -> createSedan()
        2 -> createSUV()
        3 -> createSportsCar()
        else -> {
            println("Invalid car type. Defaulting to Sedan.")
            createSedan()
        }
    }

    carType.passport()
    println(carType.move())
}

fun createSedan(): Vehicle {
    println("Enter car name:")
    val name = readLine() ?: ""

    println("Enter car velocity (km/h):")
    val velocity = readLine()?.toIntOrNull() ?: 0

    println("Select fuel type:")
    println("1. Gas")
    println("2. Diesel")
    println("3. Kerosene")

    val fuelChoice = readLine()?.toIntOrNull()
    val fuelType = when (fuelChoice) {
        1 -> Fuel.GAS
        2 -> Fuel.DIESEL
        3 -> Fuel.KEROSENE
        else -> Fuel.GAS
    }

    return Sedan(name, velocity, fuelType)
}

fun createSUV(): Vehicle {
    println("Enter car name:")
    val name = readLine() ?: ""

    println("Enter car velocity (km/h):")
    val velocity = readLine()?.toIntOrNull() ?: 0

    println("Select fuel type:")
    println("1. Gas")
    println("2. Diesel")
    println("3. Kerosene")

    val fuelChoice = readLine()?.toIntOrNull()
    val fuelType = when (fuelChoice) {
        1 -> Fuel.GAS
        2 -> Fuel.DIESEL
        3 -> Fuel.KEROSENE
        else -> Fuel.GAS
    }

    return SUV(name, velocity, fuelType)
}

fun createSportsCar(): Vehicle {
    println("Enter car name:")
    val name = readLine() ?: ""

    println("Enter car velocity (km/h):")
    val velocity = readLine()?.toIntOrNull() ?: 0

    println("Select fuel type:")
    println("1. Gas")
    println("2. Diesel")
    println("3. Kerosene")

    val fuelChoice = readLine()?.toIntOrNull()
    val fuelType = when (fuelChoice) {
        1 -> Fuel.GAS
        2 -> Fuel.DIESEL
        3 -> Fuel.KEROSENE
        else -> Fuel.GAS
    }

    return SportsCar(name, velocity, fuelType)
}

fun createAndOperateAirplane() {
    println("Select airplane type:")
    println("1. Commercial Airplane")
    println("2. Private Jet")
    println("3. Cargo Plane")

    val airplaneTypeChoice = readLine()?.toIntOrNull()

    val airplaneType: Vehicle = when (airplaneTypeChoice) {
        1 -> createCommercialAirplane()
        2 -> createPrivateJet()
        3 -> createCargoPlane()
        else -> {
            println("Invalid airplane type. Defaulting to Commercial Airplane.")
            createCommercialAirplane()
        }
    }

    airplaneType.passport()
    println(airplaneType.move())
}

fun createCommercialAirplane(): Vehicle {
    println("Enter car name:")
    val name = readLine() ?: ""

    println("Enter car velocity (km/h):")
    val velocity = readLine()?.toIntOrNull() ?: 0

    println("Select fuel type:")
    println("1. Gas")
    println("2. Diesel")
    println("3. Kerosene")

    val fuelChoice = readLine()?.toIntOrNull()
    val fuelType = when (fuelChoice) {
        1 -> Fuel.GAS
        2 -> Fuel.DIESEL
        3 -> Fuel.KEROSENE
        else -> Fuel.KEROSENE
    }

    return CommercialAirplane(name, velocity, fuelType)
}

fun createPrivateJet(): Vehicle {
    println("Enter car name:")
    val name = readLine() ?: ""

    println("Enter car velocity (km/h):")
    val velocity = readLine()?.toIntOrNull() ?: 0

    println("Select fuel type:")
    println("1. Gas")
    println("2. Diesel")
    println("3. Kerosene")

    val fuelChoice = readLine()?.toIntOrNull()
    val fuelType = when (fuelChoice) {
        1 -> Fuel.GAS
        2 -> Fuel.DIESEL
        3 -> Fuel.KEROSENE
        else -> Fuel.KEROSENE
    }

    return PrivateJet(name, velocity, fuelType)
}

fun createCargoPlane(): Vehicle {
    println("Enter car name:")
    val name = readLine() ?: ""

    println("Enter car velocity (km/h):")
    val velocity = readLine()?.toIntOrNull() ?: 0

    println("Select fuel type:")
    println("1. Gas")
    println("2. Diesel")
    println("3. Kerosene")

    val fuelChoice = readLine()?.toIntOrNull()
    val fuelType = when (fuelChoice) {
        1 -> Fuel.GAS
        2 -> Fuel.DIESEL
        3 -> Fuel.KEROSENE
        else -> Fuel.KEROSENE
    }

    return CargoPlane(name, velocity, fuelType)
}
