package to.lova.vaadin.issues;

import com.devskiller.jfairy.producer.person.Person;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.router.Route;

@Route(value = "grid", layout = MainLayout.class)
public class GridView extends Grid<Person> {

    public GridView() {
        this.addColumn(Person::getFullName);
    }

}
