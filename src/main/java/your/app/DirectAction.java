package your.app;

import your.app.components.Main;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WORequest;
import er.extensions.appserver.ERXDirectAction;

public class DirectAction extends ERXDirectAction {
	public DirectAction(WORequest request) {
		super(request);
	}

	public WOActionResults defaultAction() {
		return pageWithName(Main.class.getName());
	}
}
