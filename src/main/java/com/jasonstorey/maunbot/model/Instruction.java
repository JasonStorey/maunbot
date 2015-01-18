package com.jasonstorey.maunbot.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		String command = text;

		if(text.toLowerCase().contains("say")) {
			return extractSpeakString(text);
		}
		return command;
	}

	private String extractSpeakString(String text) {
		Pattern p = Pattern.compile("\"([^\"]*)\"");
		Matcher m = p.matcher(text);
		if (m.find()) {
			return m.group(1);
		}
		return "";
	}
}