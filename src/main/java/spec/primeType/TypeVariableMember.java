package spec.primeType;

/**
 * Created by chenweichao on 15-6-17.
 */
public class TypeVariableMember {
    <T extends C & I> void test(T t) {
        t.mI();
        t.mcPlblic();
        t.mcProtected();
        t.mcProtected();
//         t.mcPrivate(); compile-time error
    }
}

class C {
    public void mcPlblic() {
    }

    protected void mcProtected() {
    }

    void mcPackage() {
    }

    private void mcPrivate() {
    }

}

interface I {
    void mI();
}

class CT extends C implements I {
    @Override
    public void mI() {

    }
}
