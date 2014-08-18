package com.jasonstorey.maunbot.model;

public class Instruction {

	private String text;
	private String command;

	public Instruction(String text) {
		this.text = text;
		this.command = parseCommandFromString(text);
	}

	public String getCommand() {
		return command;
	}

	private String parseCommandFromString(String text) {
		return text;
	}
}