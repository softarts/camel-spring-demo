package com.example.demo.routes

import com.example.demo.service.JmsMessageProcessor
import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component

@Component
class JMSRouteBuilder : RouteBuilder() {
    @Throws(Exception::class)
    override fun configure() {
        log.info("configure JMSRouteBuilder")
        from("jmsComponent:queue:DEV.QUEUE.1")
            .process { exchange -> println(exchange.getIn().body) }
            .to("jmsComponent:queue:DEV.QUEUE.2")

//        from("jmsComponent:queue:DEV.QUEUE.1")
//            .process { exchange -> println(exchange.getIn().body) }
//            .process(JmsMessageProcessor())
//            .transform()
//            .method("jmstransformer", "doTransform")
//            .to("jmsComponent:queue:DEV.QUEUE.2")
    }
}