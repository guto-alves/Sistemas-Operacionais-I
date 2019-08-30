package processos.ex01.model;

import java.io.BufferedReader;

public abstract class OS {
	private String name;
	private String commandIP;
	private String commandPing;

	public OS() {
	}

	public OS(String name, String commandIP, String commandPing) {
		this.name = name;
		this.commandIP = commandIP;
		this.commandPing = commandPing;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCommandIP() {
		return commandIP;
	}

	public void setCommandIP(String commandIP) {
		this.commandIP = commandIP;
	}

	public String getCommandPing() {
		return commandPing;
	}

	public void setCommandPing(String commandPing) {
		this.commandPing = commandPing;
	}

	public abstract String getIP(BufferedReader buffer);

	public abstract String getPing(BufferedReader buffer);
}
