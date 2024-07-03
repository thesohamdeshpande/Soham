import java.util.Objects;

class A implements Cloneable {
	int id;
	String name;

	@Override
	public String toString() {
		return "A [id=" + id + ", name=" + name + "]";
	}

	public A(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		A other = (A) obj;
		return id == other.id && Objects.equals(name, other.name);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("Deleted");
	}
}

public class Main1 {
	public static void main(String[] args) throws CloneNotSupportedException {
		A a1 = new A(1, "Tom");
		System.out.println(a1);
		A a2 = new A(1, "Tom");
		System.out.println(a2);
		A a3 = new A(2, "Rom");
		System.out.println(a3);
		a3=null;
		System.gc();
		System.out.println(a2.equals(a1));
		A a4 = new A(4, "Jom");
		System.out.println(a4);
		A a5 = (A) a4.clone();
	}
}
