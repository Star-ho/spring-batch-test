package com.sungho.batch

import org.springframework.batch.core.Job
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/batch")
class BatchController(
    private val jobLauncher: JobLauncher,
    private val job: Job
) {
    @PostMapping
    fun runBatch() {
        val param = JobParametersBuilder()
            .addLong("test", 1L)
            .toJobParameters()

        jobLauncher.run(job, param)
    }
}