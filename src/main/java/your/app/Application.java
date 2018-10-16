package your.app;

import com.google.inject.Module;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import com.webobjects.appserver.WOSession;
import com.webobjects.foundation.NSLog;
import com.woinject.InjectableApplication;

import er.extensions.foundation.ERXPatcher;
import your.app.components.Main;

public class Application extends InjectableApplication {
	@Inject
	@Named("AppVersion")
	public String version;

	public Application() {
		super();
		NSLog.out.appendln("Welcome to " + name() + " !");
		/* ** put your initialization code in here ** */

		System.out.println("App version: " + version);
	}

	/**
	 * Determines the WOSession class to instantiate.
	 * 
	 * @see com.webobjects.appserver.WOApplication#_sessionClass()
	 */
	@Override
	protected Class<? extends WOSession> _sessionClass() {
		return Session.class;
	}

	/**
	 * Install patches including ensuring that Main is correctly resolved at
	 * runtime.
	 * 
	 * @see er.extensions.appserver.ERXApplication#installPatches()
	 */
	@Override
	public void installPatches() {
		super.installPatches();
		ERXPatcher.setClassForName(Main.class, "Main");
	}

	@Override
	protected Module[] modules() {
		return new Module[] { new AbstractModule() {
			@Override
			protected void configure() {
				bind(String.class).annotatedWith(Names.named("AppVersion")).toInstance("1.0.0");
			}
		} };
	}
}
