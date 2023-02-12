package com.example.demo.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.*

@Component("jmstransformer")
class JmsTransformerBean {
    private val log: Logger = LoggerFactory.getLogger(this.javaClass)
    fun doTransform(input: String): String {
        log.info("doTransform $input")
        return input.uppercase(Locale.getDefault())
    }
}