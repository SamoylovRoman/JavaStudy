import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class RunTests {

    public static void run(Class c) {
        Method[] methods = c.getMethods();
        List<Method> arrayOfMethods = new ArrayList<Method>();
        Method flagBefore = null;
        Method flagAfter = null;

        for (Method met : methods) {

            if (met.isAnnotationPresent(BeforeSuite.class)) {
                if (flagBefore != null) {
                    throw new RuntimeException("Before methods contain more than one time");
                }
                flagBefore = met;
            }
            if (met.isAnnotationPresent(AfterSuite.class)) {
                if (flagAfter != null) {
                    throw new RuntimeException("After methods contain more than one time");
                }
                flagAfter = met;
            }

            if (met.isAnnotationPresent(Test.class)) {
                arrayOfMethods.add(met);
            }

        }
        if (flagBefore == null) {
            throw new RuntimeException("Before method is not existed");
        }
        if (flagAfter == null) {
            throw new RuntimeException("After method is not existed");
        }

        Collections.sort(arrayOfMethods, new Comparator<Method>() {
            public int compare(Method o1, Method o2) {
//                return o1.getAnnotation(Test.class).priority() - o2.getAnnotation(Test.class).priority();
                return o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority();
            }
        });

        try {
            flagBefore.invoke(null);
            for (Method met : arrayOfMethods) {
                met.invoke(null);
            }
            flagAfter.invoke(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}


