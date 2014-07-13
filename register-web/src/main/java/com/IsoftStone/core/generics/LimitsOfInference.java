package com.IsoftStone.core.generics;

import com.IsoftStone.core.net.mindview.util.New;
import com.IsoftStone.core.typeinfo.Person;
import com.IsoftStone.core.typeinfo.pets.Pet;

import java.util.List;
import java.util.Map;

/**
 * Created by Ivan Wang on 2014/7/13.
 */
public class LimitsOfInference {
    static void f(Map<Person,List<? extends Pet>> petPeople){}
    public static void main(String[] args) {
        //f(New.map()); // Does not compile
    }
}
