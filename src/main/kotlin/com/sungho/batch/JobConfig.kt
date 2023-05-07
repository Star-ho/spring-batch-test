package com.sungho.batch

import com.sungho.product.Product
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.JobScope
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.database.JpaPagingItemReader
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManagerFactory


@Configuration
class JobConfig(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory,
    private val entityManagerFactory: EntityManagerFactory
) {

    @Bean
    fun exampleJob(): Job {
        return jobBuilderFactory.get("exampleJob")
            .start(step1())
            .build()
    }

    @Bean
    @JobScope
    fun step1(): Step {
        return stepBuilderFactory.get("step1")
            .chunk<Product, Long>(1)
            .reader(productPagingReader(0))
            .processor(productProcessor())
            .writer { it ->
                println(it)
            }
            .allowStartIfComplete(true)
            .build()
    }

    @Bean
    @StepScope
    fun productPagingReader(@Value("#{jobParameters['test']}") a: Long): JpaPagingItemReader<Product?> {
        return JpaPagingItemReaderBuilder<Product>()
            .queryString("SELECT p FROM Product p where id>=:id")
            .parameterValues(mapOf(Pair("id",a)))
            .entityManagerFactory(entityManagerFactory)
            .name("productPagingReader")
            .pageSize(10)
            .build()
    }

    @Bean
    @StepScope
    fun productProcessor():ItemProcessor<Product,Long>{
        return ItemProcessor {
            it.id
        }
    }
}
