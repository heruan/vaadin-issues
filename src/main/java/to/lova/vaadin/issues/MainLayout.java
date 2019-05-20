package to.lova.vaadin.issues;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;

@PWA(name = "Vaadin Issues", shortName = "Issues")
public class MainLayout extends AppLayout {

    public MainLayout() {
        this.addToNavbar(new RouterLink("Home", Home.class));
        this.addToNavbar(new RouterLink("Other", OtherView.class));
    }

}
