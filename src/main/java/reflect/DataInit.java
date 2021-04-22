package reflect;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataInit {

    public static void init(Map<Method, String> methodsNeedInit, List<String> methodsInvoked) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Map<Method, String> newMethodsNeedInit = new HashMap<>();

        for (Map.Entry<Method, String> entry : methodsNeedInit.entrySet()) {
            Method method = entry.getKey();
            Class<?> c = method.getDeclaringClass();
            String dependMethod = entry.getValue();
            if (StringUtils.isNotEmpty(dependMethod)) {
                if (!methodsInvoked.contains(dependMethod)) {
                    newMethodsNeedInit.put(method, dependMethod);
                } else {
                    method.invoke(c.newInstance());
                    methodsInvoked.add(c.getName() + "." + method.getName() + "()");
                }
            } else {
                method.invoke(c.newInstance());
                methodsInvoked.add(c.getName() + "." + method.getName() + "()");
            }
        }
        if (newMethodsNeedInit.isEmpty()) {
            return;
        }
        DataInit.init(newMethodsNeedInit, methodsInvoked);
    }
}
