package z;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Recv {
	private final static String QUEUE_NAME = "hello";
	static String host = "10.1.30.9";
	static String user = "dx";
	static String pwd = "dx@123";
	static int port = 5672;

	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(host);
		factory.setPort(port);
		factory.setUsername(user);
		factory.setPassword(pwd);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), "UTF-8");
			System.out.println(" [x] Received '" + message + "'");
			channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
		};
		channel.basicConsume(QUEUE_NAME, false, deliverCallback, consumerTag -> {});

	}
}
