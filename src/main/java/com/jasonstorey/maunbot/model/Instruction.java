package com.jasonstorey.maunbot.model;

import java.util.regex.Matcher;

public class Instruction {

	private Command command;
	private String arguments;

	public Instruction(String instructionText) {
		command = parseCommandFromString(instructionText);
		if(command != null) {
			arguments = parseArgumentsFromString(instructionText, command);
		}
	}

	public Command getCommand() {
		return command;
	}

	public String getArguments() {
		return arguments;
	}

	private Command parseCommandFromString(String text) {
		String lowercaseText = text.toLowerCase();

		for (Command command : Command.values()) {
			if(lowercaseText.contains(command.getText())) {
				return command;
			}
		}

		return null;
	}

	private String parseArgumentsFromString(String text, Command command) {
		Matcher m = command.getArgumentsPattern().matcher(text);
		if (m.find()) {
			return m.group(1);
		}
		return null;
	}
}