package com.IsoftStone.core;

import com.IsoftStone.core.net.mindview.util.TypeCounter;
import com.IsoftStone.core.typeinfo.pets.Pet;
import com.IsoftStone.core.typeinfo.pets.Pets;

import static com.IsoftStone.core.net.mindview.util.Print.print;
import static com.IsoftStone.core.net.mindview.util.Print.printnb;

/**
 * Created by Bachelor Wang on 2014/6/11.
 */
public class PetCount4 {
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Pet.class);
        for (Pet pet : Pets.createArray(20)){
            printnb(pet.getClass().getSimpleName() + " ");
            counter.count(pet);
        }
        print();
        print(counter);
    }
}
