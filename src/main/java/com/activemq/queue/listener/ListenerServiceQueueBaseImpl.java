package com.activemq.queue.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

/**
 * Listener de la cola la implementacion
 *
 */
public abstract class ListenerServiceQueueBaseImpl implements MessageListener {

	private static Logger log = Logger
			.getLogger(ListenerServiceQueueBaseImpl.class);

	public void onMessage(Message message) {
		log.debug("Inicio - onMessage " + message);
		String JMSMessageID = null;
		String JMSCorrelationID = null;
		TextMessage textMessage = null;
		if (message instanceof TextMessage) {
			try {
				JMSMessageID = message.getJMSMessageID();
				log.debug("Procesando JMSMessageID: " + JMSMessageID
						+ " - JMSCorrelationID: " + JMSCorrelationID);
				textMessage = (TextMessage) message;
				log.debug("Se recibió el mensaje: " + textMessage.getText());
				this.receiveMessageFromQueue(textMessage.getJMSMessageID(),
						textMessage.getText(),
						textMessage.getStringProperty("infoAdicional")); //con getStringProperty levanto las propiedades
			} catch (JMSException e) {
				log.error("No se pudo obtener el mensaje, código de error: "
						+ e.getErrorCode(), e);
			}

		}
	}

	protected abstract void receiveMessageFromQueue(String executionId,
			String message, String infoAdicional);

}
