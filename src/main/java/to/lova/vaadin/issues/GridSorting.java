/*-
 * Copyright 2017-2019 Axians SAIV S.p.A.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
-*/
package to.lova.vaadin.issues;

import com.devskiller.jfairy.producer.person.Person;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridSortOrder;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class GridSorting extends VerticalLayout {

    public GridSorting() {
        Grid<Person> grid = new Grid<>();
        grid.setDataProvider(new PeopleProvider());
        var firstNameColumn = grid.addColumn(Person::getFirstName)
                .setHeader("First Name").setSortProperty("first");
        grid.addColumn(Person::getLastName).setHeader("Last Name")
                .setSortProperty("last");
        grid.addColumn(Person::getEmail).setHeader("E-Mail Address")
                .setSortProperty("email");

        // Not working!
        grid.sort(GridSortOrder.asc(firstNameColumn).build());

        this.add(grid);
    }

}
