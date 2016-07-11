package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Vector;

import objects.Board;
import sm.SM;

public class Server {

	private Vector<SClient> clients;
	private Vector<Board> games;
	
	private int numClients = 0;
	
	private HashMap<Integer, Vector<SClient>> serverHashMap;
	
	private final ServerSocket SERVER_SOCKET;
	
	private Long gameCounter;
	
	public Server(int port) throws IOException {
		this.SERVER_SOCKET = new ServerSocket(port);
		this.games = new Vector<Board>();
		this.serverHashMap = new HashMap<Integer, Vector<SClient>>();
		this.clients = new Vector<SClient>();
		this.gameCounter = 0l;
	}
	
	public Board getBoard(int boardIndex) {
		if ( boardIndex < 0 || boardIndex >= this.games.size() ) 
			throw new IndexOutOfBoundsException();
		return this.games.get(boardIndex);
	}
	
	public void deleteClient(SClient c) {
		synchronized (this.clients) {
			synchronized (this.games) {
				synchronized (this.serverHashMap) {
					this.serverHashMap.get(this.clients.indexOf(c)).remove(c); 
					this.clients.remove(c);
				}
			}
		}
	}
	
	public void deleteClient(long id) {
		synchronized (this.clients) {
			synchronized (this.games) {
				synchronized (this.serverHashMap) {
					SClient c = null;
					for ( SClient s : this.clients )
						if ( s.getPlayerID() == id )
							c = s;
					this.serverHashMap.get(this.clients.indexOf(c)).remove(c); 
					this.clients.remove(c);
				}
			}
		}
	}
	
	public boolean userIDExists(long id) {
		return SM.checkUserWithID(this.clients, id);
	}
	
	public long generateUserID() {
		long ID = 0l;
		do {
			ID = new java.util.Random(System.currentTimeMillis()).nextLong();
		} while ( userIDExists(ID) );
		return ID;
	}
	
	/**
	 * Run the server, listening for client connections and handling them. Never
	 * returns unless an exception is thrown
	 * 
	 * @throws IOException
	 *             if the main server socket is broken (IOExceptions from
	 *             individual clients do *not* terminate serve())
	 */
	public void serve() throws IOException {
		while (true) {
			// block until a client connects
			final Socket socket = SERVER_SOCKET.accept();

			// Once accepted make a thread for client
			// handle the client
			Thread t = new Thread(new Runnable() {
				public void run() {
					long newUserID = -1l;
					synchronized (clients) {
						newUserID = generateUserID();
					}
					try {
						handleConnection(socket, newUserID);
					} catch (IOException e) {
						e.printStackTrace();
						deleteClient(newUserID);
					}
					finally {
						try {
							socket.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			});
			t.start();
		}
	}
	
	private void handleConnection(Socket socket, long id) throws IOException {
		
	}
}
