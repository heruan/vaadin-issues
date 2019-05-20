package to.lova.vaadin.issues;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "other", layout = MainLayout.class)
public class OtherView extends VerticalLayout {

    public OtherView() {
        this.add(new Button("Click me!", event -> Notification.show("Success!")
                .addThemeVariants(NotificationVariant.LUMO_SUCCESS)));
    }

}
