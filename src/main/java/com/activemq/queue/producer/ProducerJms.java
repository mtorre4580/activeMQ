package com.activemq.queue.producer;

import javax.jms.JMSException;

/**
 * Producer de la cola
 */
public interface ProducerJms {

	public void sendMessage(String xmlMessage, String infoAdicional)
			throws JMSException;

}