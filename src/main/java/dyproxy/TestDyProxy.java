package dyproxy;

import java.lang.reflect.Proxy;

import org.junit.Test;

public class TestDyProxy {
    @Test
   public void test() {
       TargetAdd add=new TargetAdd();
       Object service1=new Service1Impl();
       ServiceInterceptor interceptor=new ServiceInterceptor(service1, add);
       Service1 newProxyInstance = (Service1)Proxy.newProxyInstance(service1.getClass().getClassLoader(), service1.getClass().getInterfaces(), interceptor);
       newProxyInstance.addData();
    }
}
