package com.activemq.queue.producer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class ProducerJmsQueueImpl implements ProducerJms{
	
	@Autowired	
	protected JmsTemplate queueJmsTemplate;
	
	private String destinationName;
	
	@Value("${cola.nombre}")
	private String colaNombre;
	
	public void sendMessage(String xmlMessage, String infoAdicional) throws JMSException {
		this.setDestinationName(colaNombre);
		RequestSendMessageCreator messageCreator = new RequestSendMessageCreator();
		messageCreator.setMessage(xmlMessage,infoAdicional);
		this.queueJmsTemplate.send(destinationName, messageCreator);
	}
	
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}	

	private class RequestSendMessageCreator implements MessageCreator {
		private String message;
		private String infoAdicional;
		private javax.jms.TextMessage textMessage;

		public void setMessage(String message,
				String infoAdicional) {
			this.message = message;
			this.infoAdicional = infoAdicional;
		}

		@SuppressWarnings("unused")
		public String getMessageId() throws JMSException {
			return textMessage.getJMSMessageID();
		}

		public void setTextMessage(TextMessage textMessage, String infoAdicional)
				throws JMSException {
			this.textMessage = textMessage;
			this.textMessage.setStringProperty("infoAdicional", infoAdicional);
			//si quiero agregar mas parametros los seteo con setProperty...
			//se levantan los datos en el reciver con getProperty...
		}

		public javax.jms.TextMessage getTextMessage() throws JMSException {
			return textMessage;
		}

		public Message createMessage(javax.jms.Session session)
				throws JMSException {
			setTextMessage(session.createTextMessage(message),
					this.infoAdicional);
			return getTextMessage();
		}
	}

}
