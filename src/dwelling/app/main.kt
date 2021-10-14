package dwelling.app

fun main() {
    val squareCabin = SquareCabin(3, 15.0)
    squareCabin.printProperties()
    with (squareCabin) {
        printProperties()
        println("Has room?  -  ${hasRoom()}")
    }
    val roundHut = RoundHut(5, 12.0)
    with (roundHut) {
        printProperties()
        println("Has room?  -  ${hasRoom()}")
        getRoom()
        println("Max Carpet Size  -  ${calculateMaxCarpetSize()}")
    }

    val roundTower = RoundTower(20, 16.5, 5)
    with (roundTower) {
        printProperties()
        println("Has room?  -  ${hasRoom()}")
        getRoom()
        println("Max Carpet Size  -  ${calculateMaxCarpetSize()}")
    }

}