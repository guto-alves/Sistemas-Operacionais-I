package processos.ex01.model;

public class Adapter {
	private String name;
	private String addres;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	@Override
	public String toString() {
		return String.format("%s%n%s%n%n", getName(), getAddres());
	}
}
