package xyz.mdou.quickstart.functional;


import java.util.function.*;

class Foo {
}

class Bar {
    Foo foo;

    Bar(Foo foo) {
        this.foo = foo;
    }
}

class IBaz {
    int i;

    IBaz(int i) {
        this.i = i;
    }
}

class LBaz {
    long l;

    LBaz(long l) {
        this.l = l;
    }
}

class DBaz {
    double d;

    DBaz(double d) {
        this.d = d;
    }
}

public class FunctionVariants {
    private static Function<Foo, Bar> f1 = Bar::new;
    private static IntFunction<IBaz> f2 = IBaz::new;
    private static LongFunction<LBaz> f3 = LBaz::new;
    private static DoubleFunction<DBaz> f4 = DBaz::new;

    private static ToIntFunction<IBaz> f5 = ib -> ib.i;
    private static ToLongFunction<LBaz> f6 = lb -> lb.l;
    private static ToDoubleFunction<DBaz> f7 = db -> db.d;

    private static IntToLongFunction f8 = Long::valueOf;
    private static IntToDoubleFunction f9 = Double::valueOf;
    private static LongToIntFunction f10 = l -> (int) l;
    private static LongToDoubleFunction f11 = l -> l;
    private static DoubleToIntFunction f12 = d -> (int) d;
    private static DoubleToLongFunction f13 = d -> (long) d;

    public static void main(String[] args) {
        Bar b = f1.apply(new Foo());

        IBaz ib = f2.apply(1);
        LBaz lb = f3.apply(2);
        DBaz db = f4.apply(3);

        int i = f5.applyAsInt(ib);
        long l = f6.applyAsLong(lb);
        double d = f7.applyAsDouble(db);

        long il = f8.applyAsLong(i);
        double id = f9.applyAsDouble(i);
        int li = f10.applyAsInt(l);
        double ld = f11.applyAsDouble(l);
        int di = f12.applyAsInt(d);
        long dl = f13.applyAsLong(d);
    }
}
