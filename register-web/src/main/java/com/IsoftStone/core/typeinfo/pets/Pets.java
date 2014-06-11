package com.IsoftStone.core.typeinfo.pets;

import java.util.ArrayList;

/**
 * Created by Bachelor Wang on 2014/6/11.
 */
public class Pets {
    public static final PetCreator creator =
            new LiteralPetCreator();

    public static Pet randomPet() {
        return creator.randomPet();
    }

  public static Pet[] createArray(int size){
      return creator.createArray(size);
  }
    public static ArrayList<Pet> arrayList(int size){
        return creator.arrayList(size);
    }
}
