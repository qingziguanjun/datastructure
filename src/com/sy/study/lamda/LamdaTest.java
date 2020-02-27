package com.sy.study.lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author songyi
 * @date 2020-02-25 11:34
 * @Description:
 */
public class LamdaTest {

    public static void main(String[] args) {
        LamdaTest lamdaTest = new LamdaTest();
        List<Person> roster = new ArrayList<>();
        for(int i = 15; i < 25; i++) {
            Person.Sex sex = Person.Sex.MALE;
            if(i %2 == 0){
                sex = Person.Sex.FEMALE;
            }
            Person person = new Person(i, "test"+i, sex, i+ "@email");
            roster.add(person);
        }
        lamdaTest.processPersons(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.printPerson()
        );
    }

    public static void processPersons(
            List<Person> roster,
            Predicate<Person> tester,
            Consumer<Person> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }
}
