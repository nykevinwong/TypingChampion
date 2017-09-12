package Server.Listeners;

import java.util.HashMap;
import com.esotericsoftware.kryonet.Connection;
import Client.Requests.JoinRequest;
import Server.Enities.ServerPlayer;
import Server.Responses.JoinResponse;

import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

public class JoinListener extends Listener {
	
	private Server server;
	private HashMap<Integer, ServerPlayer> players;
	
	public JoinListener(HashMap<Integer, ServerPlayer> players, Server server) {
		this.players = players;
		this.server = server;
	}

	@Override
	public void received(Connection connection, Object object) {
		
		if(object instanceof JoinRequest){
			
			JoinRequest r = (JoinRequest)object;
			
			if(players.size() < 2){
				addPlayer(connection, r.name);
				server.sendToAllTCP(new JoinResponse(r.name, true));
			}else{
				server.sendToAllTCP(new JoinResponse(r.name, false));
			}
		}
		
	}
	
	private void addPlayer(Connection connection, String name) {
		players.put(connection.getID(), new ServerPlayer(name, connection));
	}
	
}
