package com.IsoftStone.core.typeinfo.pets;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bachelor Wang on 2014/6/7.
 */
public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();
    private static String[] typeNames = {
            "com.IsoftStone.core.typeinfo.pets.Mutt",
            "com.IsoftStone.core.typeinfo.pets.Pug",
            "com.IsoftStone.core.typeinfo.pets.EgyptianMau",
            "com.IsoftStone.core.typeinfo.pets.Manx",
            "com.IsoftStone.core.typeinfo.pets.Cymric",
            "com.IsoftStone.core.typeinfo.pets.Rat",
            "com.IsoftStone.core.typeinfo.pets.Mouse",
            "com.IsoftStone.core.typeinfo.pets.Hamster"
    };

    private static void loader(){
        for (String name : typeNames)
            try {
                types.add((Class<? extends Pet>)Class.forName(name));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
    }

    static {
        loader();
    }
    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
