package com.activemq.queue.listener;

/**
 * Listener de la cola
 *
 */
public interface ListenerService {

	/**
	 * Editarlo a su gusto, yo envio un parametro mas para pasarle una info
	 * adicional..
	 * 
	 * @param executionId
	 * @param message
	 * @param infoAdicional
	 */
	public void receiveMessageFromQueue(String executionId, String message,
			String infoAdicional);
}
