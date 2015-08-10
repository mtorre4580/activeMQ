package com.activemq.queue.sender;

import javax.jms.JMSException;

import com.activemq.queue.message.MessageRequest;

/**
 * Sender de la cola
 *
 */
public interface SenderService {

	public abstract void sendMessage(MessageRequest message)
			throws JMSException;
}