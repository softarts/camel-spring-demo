package com.example.demo

import jakarta.jms.ConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jms.connection.JmsTransactionManager
import org.apache.camel.component.jms.JmsComponent


@Configuration
class JmsConfig {
    @Bean
    fun jmsTransactionManager(connectionFactory: ConnectionFactory?): JmsTransactionManager {
        val jmsTransactionManager = JmsTransactionManager()
        jmsTransactionManager.connectionFactory = connectionFactory
        return jmsTransactionManager
    }

    @Bean
    fun jmsComponent(
        connectionFactory: ConnectionFactory?,
        jmsTransactionManager: JmsTransactionManager?
    ): JmsComponent {
        return JmsComponent.jmsComponentTransacted(connectionFactory, jmsTransactionManager)
    }
}