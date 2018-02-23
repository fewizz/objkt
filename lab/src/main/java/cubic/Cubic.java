package cubic;

import java.util.logging.*;

import org.fusesource.jansi.*;

public class Cubic {
	public static final Formatter DEFAULT_LOGGER_HANDLER_FORMATTER = new Formatter() {
		@Override
		public String format(LogRecord record) {
			return Ansi.ansi().fgGreen().a("[" + record.getLoggerName() + "](" + Thread.currentThread().getName() + "): "+ record.getMessage() + "\n").toString();
		}
	};
	
	public static class AnsiConsoleHandler extends StreamHandler {
		public AnsiConsoleHandler() {
			super(AnsiConsole.wrapSystemOut(System.out), DEFAULT_LOGGER_HANDLER_FORMATTER);
		}
		
		@Override
		public synchronized void publish(LogRecord record) {
			super.publish(record);
			flush();
		}
	}
	
	public static void main(String[] args) {
		//AnsiConsole.systemInstall();
		//AnsiConsole.
		Client.start();
	}
	
	
}
