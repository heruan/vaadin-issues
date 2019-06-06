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

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;
import com.vaadin.flow.data.provider.AbstractBackEndDataProvider;
import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.data.provider.SortDirection;

public class PeopleProvider extends AbstractBackEndDataProvider<Person, Void> {

    static final Fairy FAIRY = Fairy.create();

    static final List<Person> PEOPLE = Stream.generate(FAIRY::person).limit(100)
            .collect(toList());

    @Override
    protected Stream<Person> fetchFromBackEnd(Query<Person, Void> query) {
        // @formatter:off
        var comparator = query.getSortOrders().stream()
                .map(sortOrder -> {
                    var sorted = sortOrder.getSorted();
                    var direction = sortOrder.getDirection();
                    var c = "first".equals(sorted) ? comparing(Person::getFirstName)
                        : ("last".equals(sorted) ? comparing(Person::getFirstName)
                        : ("email".equals(sorted) ? comparing(Person::getFirstName)
                        : comparing(Person::getFirstName)));
                    return SortDirection.ASCENDING.equals(direction) ? c : c.reversed();
                })
                .reduce(Comparator::thenComparing)
                .orElse(comparing(Person::getFirstName));
        return PEOPLE.stream()
                     .sorted(comparator)
                     .skip(query.getOffset())
                     .limit(query.getLimit());
        // @formatter:on
    }

    @Override
    protected int sizeInBackEnd(Query<Person, Void> query) {
        return PEOPLE.size();
    }

}
