package your.app.components;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

public class Main extends WOComponent {
	private static final long serialVersionUID = 1L;
	
	@Inject
    @Named("AppVersion")
    public String version;

	public Main(WOContext context) {
		super(context);
	}
}
