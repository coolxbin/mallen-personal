/*package com.huangzb.test.comet.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.cometd.bayeux.Channel;
import org.cometd.bayeux.Message;
import org.cometd.bayeux.client.ClientSession;
import org.cometd.bayeux.client.ClientSessionChannel;
import org.cometd.bayeux.client.ClientSessionChannel.MessageListener;
import org.cometd.client.BayeuxClient;
import org.cometd.client.transport.ClientTransport;
import org.cometd.client.transport.LongPollingTransport;
import org.eclipse.jetty.client.HttpClient;

public class HelloClient {
	private static BayeuxClient client;

	public void init() throws Exception {
		HttpClient httpClient = new HttpClient();
		httpClient.start();

		Map<String, Object> options = new HashMap<String, Object>();
		ClientTransport transport = new LongPollingTransport(options,
				httpClient);

		client = new BayeuxClient("http://localhost:8081/mallen-comet/cometd",
				transport);

		client.getChannel(Channel.META_HANDSHAKE).addListener(
				new ClientSessionChannel.MessageListener() {
					public void onMessage(ClientSessionChannel channel,
							Message message) {
						if (message.isSuccessful()) {
							System.out.println("握手成功");
							client.getChannel("/hello").subscribe(
									new MessageListener() {

										public void onMessage(
												ClientSessionChannel channel,
												Message msg) {
											System.out.println(msg.getData());
										}
									});
						}
					}
				});

		client.handshake();
	}

	public void disconnect() {
		client.disconnect();
		client.waitFor(1000, BayeuxClient.State.DISCONNECTED);
	}

	public static void main(String[] args) throws Exception {
		HelloClient hc = new HelloClient();
		hc.init();

		System.out.println("回车，终止程序运行");
		BufferedReader console = new BufferedReader(new InputStreamReader(
				System.in));
		console.readLine();
		hc.disconnect();
		System.out.println("程序终止");
	}
}
*/