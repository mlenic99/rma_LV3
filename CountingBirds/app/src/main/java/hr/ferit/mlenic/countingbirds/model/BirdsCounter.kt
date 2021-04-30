package hr.ferit.mlenic.countingbirds.model

class BirdsCounter {

    var numOfBirds: Int = 0

    fun seeRedBird() = numOfBirds++
    fun seeGreenBird() = numOfBirds++
    fun seeBlueBird() = numOfBirds++
    fun seeYellowBird() = numOfBirds++

}