package com.example.my_7minworkoutapp

object Constants {

    fun defaultExerciseList(): ArrayList<ExerciseModel>{
        val exerciseList = ArrayList<ExerciseModel>()

        val pushUp = ExerciseModel(
            1,
            "Push Up",
            R.drawable.pushup,
            false,
            false
        )
        exerciseList.add(pushUp)

        val pullUp = ExerciseModel(
            2,
            "Pull Up",
            R.drawable.pullup,
            false,
            false
        )
        exerciseList.add(pullUp)

        val benchPress = ExerciseModel(
            3,
            "Bench Press",
            R.drawable.benchpress,
            false,
            false
        )
        exerciseList.add(benchPress)

        val crunches = ExerciseModel(
            4,
            "Crunches",
            R.drawable.crunches,
            false,
            false
        )
        exerciseList.add(crunches)

        return exerciseList
    }
}