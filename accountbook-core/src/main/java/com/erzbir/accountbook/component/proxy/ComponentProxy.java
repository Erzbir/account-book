package com.erzbir.accountbook.component.proxy;

import com.erzbir.accountbook.component.AbstractComponent;
import com.erzbir.accountbook.component.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class ComponentProxy<E extends Component> extends AbstractComponent implements Component {
    private E delegate;

    public ComponentProxy(E delegate) {
        this.delegate = delegate;
    }

    public E getProxy() {
        Class<? extends Component> aClass = delegate.getClass();
        return (E) Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), new CheckHandler());
    }

    @Override
    public void init() {
        delegate.init();
    }

    class CheckHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//            String name = method.getName();
//            if (!name.equals("isInit") && !name.equals("isActive") && !name.equals("init")) {
//                if (!delegate.isInit() || !delegate.isActive()) {
//                    throw new UnsupportedOperationException();
//                }
//            }
            method.setAccessible(true);
            return method.invoke(delegate, args);
        }
    }
}
