package com.activemq.queue.sender;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;

import com.activemq.queue.message.MessageRequest;
import com.activemq.queue.producer.ProducerJms;
import com.activemq.queue.producer.State;

public class SenderServiceImpl implements SenderService {

	@Autowired
	private ProducerJms producerJms;

	public void sendMessage(MessageRequest message) throws JMSException {
		producerJms.sendMessage(message.getMessage(),
				message.getInfoAdicional());
		message.setEstado(State.ENVIADO);
	}

}
