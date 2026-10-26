package edu.ucb.pablostify.scheduler

expect class LogScheduler(context: Any?) {
    fun schedulePeriodicalUpload()
}