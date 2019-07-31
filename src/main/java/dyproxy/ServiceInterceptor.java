package dyproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ServiceInterceptor implements InvocationHandler {

    private Object object;
    private TargetAdd targetAdd;

    public ServiceInterceptor(Object object, TargetAdd targetAdd) {
        this.object = object;
        this.targetAdd = targetAdd;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        targetAdd.startDoSomething();
        Object invoke = method.invoke(this.object, args);
        targetAdd.endDoSomething();
        return invoke;
    }

}
