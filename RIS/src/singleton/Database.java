package singleton;

public class Database {
	private static Database instance = new Database();
	private static Database instanceLazy;
	
	private Database() {
		
	}

	public static Database getInstance() {
		return instance;
	}
	public static Database getInstanceLazy() {
		if(instanceLazy == null) {
			synchronized (Database.class) {
				if(instanceLazy == null) {
					instanceLazy = new Database();
				}
			}
		}
		return instanceLazy;
	}
	
	public void connect() {
		System.out.println("Connected!");
	}
	public void disconnect() {
		System.out.println("Disonnected!");
	}
}
