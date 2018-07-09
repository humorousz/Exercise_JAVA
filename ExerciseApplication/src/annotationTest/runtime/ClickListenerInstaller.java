package annotationTest.runtime;

import java.lang.reflect.*;

/**
 * @author zhangzhiquan
 * @date 2018/7/9
 */
public class ClickListenerInstaller {
    /**
     * Processes all ClickListenerFor annotations in the given object.
     * @param obj an object whose methods may have ClickListenerFor annotations
     */
    public static void processAnnotations(Object obj){
        try {
            Class<?> cl = obj.getClass();
            for(Method m: cl.getDeclaredMethods()){
                ClickListenerFor c = m.getAnnotation(ClickListenerFor.class);
                if(c != null){
                    Field f = cl.getDeclaredField(c.source());
                    f.setAccessible(true);
                    addListener(f.get(obj),obj,m);
                }
            }
        }catch (ReflectiveOperationException e){
            e.printStackTrace();
        }
    }

    public static void addListener(Object source,Object param,Method m) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        InvocationHandler handler =  (proxy,method,args)->{
            return m.invoke(param);
        };
        Object listener = Proxy.newProxyInstance(source.getClass().getClassLoader(),new Class[]{Button.OnClickListener.class},handler);
        Method onclick = source.getClass().getMethod("setOnClickListener",Button.OnClickListener.class);
        onclick.invoke(source,listener);
    }
}
