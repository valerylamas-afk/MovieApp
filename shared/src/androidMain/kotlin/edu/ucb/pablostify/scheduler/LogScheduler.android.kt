package edu.ucb.pablostify.scheduler

import android.content.Context
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

actual class LogScheduler actual constructor(
    context: Any?
) {
    private val androidContext = context as? Context
        ?: throw IllegalArgumentException("Context must be an Android Context")

    actual fun schedulePeriodicalUpload() {
        val logRequest = PeriodicWorkRequest.Builder(
            LogUploadWorker::class.java,
            15L,
            TimeUnit.MINUTES
        )
            .setConstraints(
                Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .build()
            )
            .build()

        WorkManager
            .getInstance(androidContext.applicationContext)
            .enqueueUniquePeriodicWork(
                "logUploadWork",
                ExistingPeriodicWorkPolicy.KEEP,
                logRequest
            )
    }
}