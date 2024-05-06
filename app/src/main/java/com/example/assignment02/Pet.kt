package com.example.assignment02

class Pet {
    var hunger: Int = 0
    var cleanliness: Int = 50
    var happy: Int = 50

    fun feed() {
        hunger += 10
        if (hunger > 100) hunger = 100
    }

    fun clean() {
        cleanliness += 5
        if (cleanliness > 100) cleanliness = 100
    }

    fun play() {
        happy += 2
        if (happy > 100) happy = 100
    }

    fun decreaseHunger() {
        hunger -= 5
        if (hunger < 0) hunger = 0
    }

    fun decreaseCleanliness() {
        cleanliness -= 10
        if (cleanliness < 0) cleanliness = 0
    }

    fun decreaseHappy() {
        happy -= 5
        if (happy < 0) happy = 0
    }

}