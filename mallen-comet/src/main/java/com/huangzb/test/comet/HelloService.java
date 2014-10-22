package com.huangzb.test.comet;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.cometd.annotation.Listener;
import org.cometd.annotation.Service;
import org.cometd.annotation.Session;
import org.cometd.bayeux.server.BayeuxServer;
import org.cometd.bayeux.server.LocalSession;
import org.cometd.bayeux.server.ServerChannel;
import org.cometd.bayeux.server.ServerMessage;
import org.cometd.bayeux.server.ServerSession;

@Named
@Singleton
@Service("helloService")
public class HelloService {
	@Inject
	private BayeuxServer bayeux;
	@Session
	private ServerSession serverSession;
	@Session
	private LocalSession localSession;

	@PostConstruct
	public void init() {
	}

	@Listener("/service/hello")
	public void processHello(ServerSession remote, ServerMessage.Mutable message) {
		Map<String, Object> input = message.getDataAsMap();
		String name = (String) input.get("name");

		Map<String, Object> output = new HashMap<String, Object>();
		output.put("greeting", "你好, " + name);
//		remote.deliver(serverSession, "/hello", output, null);
		ServerChannel serverChannel = bayeux.getChannel("/hello");
		serverChannel.publish(localSession, output);
	}
}
