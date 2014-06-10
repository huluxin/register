package com.IsoftStone.core.typeinfo.pets;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Bachelor Wang on 2014/6/10.
 */
public class LiteralPetCreator extends PetCreator {

    public static final List<Class<? extends Pet>> allTypes =
            Collections.unmodifiableList(Arrays.asList(
                    Pet.class, Dog.class, Cat.class, Rodent.class,
                    Mutt.class, Pug.class, EgyptianMau.class, Manx.class,
                    Cymric.class, Rat.class, Mouse.class, Hamster.class));
    // Types for random creation:
    private static final List<Class<? extends Pet>> types =
            allTypes.subList(allTypes.indexOf(Mutt.class),allTypes.size());
    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
    public static void main(String[] args) {
        System.out.println(types.size());
        System.out.println(types);
    }
}
