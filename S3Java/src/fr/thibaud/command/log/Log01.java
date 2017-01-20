package fr.thibaud.command.log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log01 {
	public static Logger logger = Logger.getLogger(Log01.class.getName());
	public static void main(String[] args) {
		logger.setLevel(Level.ALL);
		try {
			FileHandler fh = new FileHandler("./log.out", false);
			fh.setLevel(Level.WARNING);
			fh.setFormatter(new SimpleFormatter());
			logger.addHandler(fh);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
