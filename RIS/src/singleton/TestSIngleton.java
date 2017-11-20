package singleton;

public class TestSIngleton {

	public static void main(String[] args) {
		Database db1 = Database.getInstance();
		System.out.println(db1);
		Database db2 = Database.getInstance();
		System.out.println(db2);

		Database db3 = Database.getInstanceLazy();
		System.out.println(db3);
		Database db4 = Database.getInstanceLazy();
		System.out.println(db4);
	}

}
