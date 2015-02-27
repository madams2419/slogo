package backend;

import StringPair;

import java.util.AbstractMap.SimpleEntry;
import java.util.Enumeration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Pattern;

import backend.command.*;

public class SLogoParser {
	
	private CommandFactory comFactory;
	private List<Entry<String, Pattern>> patterns;
	private String language;
	
	public SLogoParser(CommandFactory comFactory, String language) {
		this.comFactory = comFactory;
		this.language = language;
		genPatternList();
	}
	
	public SLogoParser(CommandFactory comFactory) {
		this(comFactory, "English");
	}
	
	public void genPatternList() {
		patterns = new ArrayList<>();
		patterns.addAll(makePatterns("resources/languages/" + language));
		patterns.addAll(makePatterns("resources/languages/Syntax"));
	}
	
	public void changeLanguage(String newLanguage) {
		language = newLanguage;
		genPatternList();
	}
	
	public ArrayList<Command> parseProgram(String prog) {

		ArrayList<StringPair> spList = genPropertyList(prog.split("\\p{Space}"), patterns);

		Command targetNode = null;
		ArrayList<Command> parseTreeList = new ArrayList<>();

		for(StringPair sp : spList) {
			if (targetNode == null) {
				targetNode = comFactory.getCommand(sp);

			} else {
				Command newNode = comFactory.getCommand(sp);
				targetNode.setParam(newNode);

				if (newNode.needsParams()) {
					targetNode = newNode;
				}

				// find first incomplete node. if no incomplete node is found, add root node to treelist and create new target node
				while (!targetNode.needsParams()) {
					if (targetNode.hasParent()) {
						targetNode = targetNode.getParent();
					} else { // target node is root
						parseTreeList.add(targetNode);
						targetNode = null;
					}
				}
			}
		}
		
		return parseTreeList;
	}
	
	private boolean match (String input, Pattern regex) {
		// THIS IS THE KEY LINE
		return regex.matcher(input).matches();
		// basic strings can match also, but not using a Pattern
		// return input.matches(regex);
	}
	
	private List<Entry<String, Pattern>> makePatterns (String syntax) {
		ResourceBundle resources = ResourceBundle.getBundle(syntax);
		List<Entry<String, Pattern>> patterns = new ArrayList<>();
		Enumeration<String> iter = resources.getKeys();
		while (iter.hasMoreElements()) {
			String key = iter.nextElement();
			String regex = resources.getString(key);
			patterns.add(new SimpleEntry<String, Pattern>(key,
					// THIS IS THE KEY LINE
					Pattern.compile(regex, Pattern.CASE_INSENSITIVE)));
		}
		return patterns;
	}
	
	private ArrayList<StringPair> genPropertyList(String[] tests, List<Entry<String, Pattern>> patterns) {
		ArrayList<StringPair> propList = new ArrayList<>();
		for (String s : tests) {
			boolean matched = false;
			if (s.trim().length() > 0) {
				for (Entry<String, Pattern> p : patterns) {
					if (match(s, p.getValue())) {
						System.out.println(String.format("%s matches %s", s, p.getKey()));
						propList.add(new StringPair(p.getKey(), s));
						matched = true;
						//break;
					}
				}
				if (! matched) {
					System.out.println(String.format("%s not matched", s));
				}
			}
		}
		System.out.println();
		return propList;
	}
}
