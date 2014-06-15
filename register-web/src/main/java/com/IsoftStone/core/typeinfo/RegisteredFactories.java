package com.IsoftStone.core.typeinfo;

import com.IsoftStone.core.typeinfo.factory.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 工厂方法设计模式
 * Created by Bachelor Wang on 2014/6/12.
 */
class Part{
    public String toString(){
        return getClass().getSimpleName();
    }
    static List<Factory<? extends Part>> partFactories = new ArrayList<Factory<? extends Part>>();
    static {
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new CabinAirFilter.Factory());
        partFactories.add(new OilFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new PowerSteeringBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());
    }
    private static Random rand = new Random(47);
    public static Part createRandom(){
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).crate();
    }
}

class Filter extends Part {}

class FuelFilter extends Filter{
    public static class Factory implements com.IsoftStone.core.typeinfo.factory.Factory<FuelFilter>{
        @Override
        public FuelFilter crate() {
            return new FuelFilter();
        }
    }
}

class AirFilter extends Filter {
    public static class Factory
            implements com.IsoftStone.core.typeinfo.factory.Factory<AirFilter> {
        @Override
        public AirFilter crate() {
            return new AirFilter();
        }
    }
}

class CabinAirFilter extends Filter {
    public static class Factory
            implements com.IsoftStone.core.typeinfo.factory.Factory<CabinAirFilter> {

        @Override
        public CabinAirFilter crate() {
            return new CabinAirFilter();
        }
    }
}

class OilFilter extends Filter {
    public static class Factory
            implements com.IsoftStone.core.typeinfo.factory.Factory<OilFilter> {
        @Override
        public OilFilter crate() {
            return new OilFilter();
        }
    }
}

class Belt extends Part {}

class FanBelt extends Belt {
    public static class Factory
            implements com.IsoftStone.core.typeinfo.factory.Factory<FanBelt> {
        @Override
        public FanBelt crate() {
            return new FanBelt();
        }
    }
}

class GeneratorBelt extends Belt {
    public static class Factory
            implements com.IsoftStone.core.typeinfo.factory.Factory<GeneratorBelt> {
        @Override
        public GeneratorBelt crate() {
            return new GeneratorBelt();
        }
    }
}

class PowerSteeringBelt extends Belt {
    public static class Factory
            implements com.IsoftStone.core.typeinfo.factory.Factory<PowerSteeringBelt> {
        @Override
        public PowerSteeringBelt crate() {
            return new PowerSteeringBelt();
        }
    }
}

public class RegisteredFactories {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++)
            System.out.println(Part.createRandom());
    }
}
