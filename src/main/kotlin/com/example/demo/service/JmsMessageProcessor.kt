package com.example.demo.service

import org.apache.camel.Exchange
import org.apache.camel.Processor
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class JmsMessageProcessor : Processor {
    private val log: Logger = LoggerFactory.getLogger(this.javaClass)
    @Throws(Exception::class)
    override fun process(exchange: Exchange) {
        val input = exchange.getIn().getBody(String::class.java)
        val output = "JmsMessageProcessor:$input"
        log.info("JmsMessageProcessor complete: $input")
        exchange.getIn().body = output
    }
}