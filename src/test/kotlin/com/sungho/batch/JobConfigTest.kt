package com.sungho.batch

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.core.spec.style.FunSpec
import org.springframework.batch.core.Job
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime

@SpringBootTest
class JobConfigTest(
    private val jobLauncher: JobLauncher,
    private val job: Job
) : DescribeSpec() {
    init {
        describe("batch Test"){
            it("batch test") {
                val param = JobParametersBuilder()
                    .addLong("test", 5L)
                    .addString("test2", LocalDateTime.now().toString())
                    .toJobParameters()

                jobLauncher.run(job, param)
            }
            it가("batch test2") {
                val param = JobParametersBuilder()
                    .addLong("test", 3L)
                    .addString("test2", LocalDateTime.now().toString())
                    .toJobParameters()

                jobLauncher.run(job, param)
            }
        }
    }

}

