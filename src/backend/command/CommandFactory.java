package backend.command;

import java.lang.reflect.Constructor;

import backend.*;

public class CommandFactory {

	private Model model;

	public CommandFactory(Model model) {
		this.model = model;
	}

	public Command getCommand(StringPair stringPair, Command parent)  {
		String comClassName = "backend.command." + stringPair.getProperty();

		try {
			Class<?> comClass = Class.forName(comClassName);
			Constructor<?>[] comConstructors = comClass.getDeclaredConstructors();
			Class<?>[] pType  = comConstructors[0].getParameterTypes();

			if(pType.length == 2) {
				return (Command) comConstructors[0].newInstance(stringPair, parent);
			} else {
				return (Command) comConstructors[0].newInstance(stringPair, parent, model);
			}

		} catch (Exception e) {
		  throw new NullPointerException("Command Not Found: " + comClassName);
		}

	}

}
