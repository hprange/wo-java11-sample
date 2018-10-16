package your.app;

import com.woinject.WOInject;

public class ApplicationRunner {
	public static void main(String[] args) {
		WOInject.init("your.app.Application", args);
	}
}
