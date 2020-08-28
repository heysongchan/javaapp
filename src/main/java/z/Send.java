package z;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {
	private final static String QUEUE_NAME = "hello";
	static String host = "10.1.30.9";
	static String user = "dx";
	static String pwd = "dx@123";
	static int port = 5672;

	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(host);
		factory.setPort(port);
		factory.setUsername(user);
		factory.setPassword(pwd);

		// try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
		// channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		// String message = "Hello World!";
		// channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		//
		// System.out.println(" [x] Sent '" + message + "'");
		// }

		Connection connection = null;
		Channel channel = null;
		// try {
		connection = factory.newConnection();
		channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		String message = "Hello World!";
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		System.out.println(" [x] Sent '" + message + "'");
		if (connection != null) connection.close();

	}

}
