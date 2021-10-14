package dwelling.app

import kotlin.math.PI
import kotlin.math.sqrt

abstract class Dwelling(private var residents: Int) {
    // The abstract class "Dwelling" contains properties that are true for all dwellings
    abstract val buildingMaterial: String
    abstract val capacity: Int

    // This abstract function would be used to calculate floor area in other subclasses
    abstract fun floorArea(): Double

    // Determine if there is room for another resident
    fun hasRoom(): Boolean {
        return residents < capacity
    }

    // This function allows a new resident to get a room if there are any vacant rooms
    fun getRoom() {
        if (capacity > residents) {
            residents++
            println("You got a room")
        } else {
            println("Sorry, there are no rooms left")
        }
    }
}

// This subclass "SquareCabin" inherits properties from the "Dwelling" super class
class SquareCabin(residents: Int, private val length: Double) : Dwelling(residents) {
    override val buildingMaterial = "Wood"
    override val capacity = 8

    // Calculate the floor area of a square cabin
    override fun floorArea(): Double {
        return length * length
    }

    // This function displays the properties of the SquareCabin subclass
    fun printProperties() {
        println(
            "\nSquare Cabin\n--------------" +
                    "\nBuilding Material: $buildingMaterial" +
                    "\nCapacity: $capacity residents" +
                    "\nFloor Area: ${floorArea()}"
        )
    }
}

/** Create another subclass "RoundHut". override Dwelling properties and make the class
 * open for another subclass to be created from it
 */
open class RoundHut(residents: Int, val radius: Double) : Dwelling(residents) {
    override val buildingMaterial = "Straw"
    override val capacity = 5

    // calculate the floor area of a round hut
    override fun floorArea(): Double {
        return PI * radius * radius
    }

    /** This function calculates carpet size required to fit a rectangular carpetinto a
     * round dwelling. This is declared in RoundHut and can be used in RoundTower as well.
     */
    fun calculateMaxCarpetSize(): Double {
        val diameter = 2 * radius
        return sqrt(diameter * diameter / 2)
    }

    // This function displays the properties of the RoundHut subclass
    open fun printProperties() {
        println(
            "\nRound Hut\n--------------" +
                    "\nBuilding Material: $buildingMaterial" +
                    "\nCapacity: $capacity residents" +
                    "\nFloor Area: ${floorArea()}"
        )
    }
}

/** This is a subclass of RoundHut. Note that the round tower shares the same radius
 * with the round hut */
class RoundTower(
    residents: Int,
    radius: Double,
    private val floors: Int) : RoundHut(residents, radius) {

    override val buildingMaterial = "Stone"
    override val capacity = 50

    override fun floorArea(): Double {
        // Use the super keyword to inherit the "PI * radius * radius" from RoundHut
        return super.floorArea() * floors
    }

    // This function displays the properties of the RoundHut subclass
    override fun printProperties() {
        println(
            "\nRound Tower\n--------------" +
                    "\nBuilding Material: $buildingMaterial" +
                    "\nCapacity: $capacity residents" +
                    "\nFloors: $floors" +
                    "\nFloor Area: ${floorArea()}"
        )
    }
}