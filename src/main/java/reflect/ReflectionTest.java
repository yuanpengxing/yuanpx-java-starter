package reflect;

import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReflectionTest {

    @Test
    public void test() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Map<Method, String> methodsNeedInit = new HashMap<>();

        for (String clas : CommonsUtils.getFilesWithSuffixClassUnderClasspath()) {
            try {
                Class clazz = Class.forName(clas);
                for (Method m : clazz.getMethods()) {
                    if (!m.isAnnotationPresent(InitData.class)) {
                        continue;
                    }
                    methodsNeedInit.put(m, m.getAnnotation(InitData.class).dependMethod());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        List<String> methodsInvoked = new ArrayList<>();
        DataInit.init(methodsNeedInit, methodsInvoked);

    }

}
