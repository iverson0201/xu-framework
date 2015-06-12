package servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xu on 2015/6/8.
 */
public class DataContext {

    private static ThreadLocal<DataContext> dataContextContainer = new ThreadLocal<DataContext>();

    private HttpServletRequest request;
    private HttpServletResponse response;

    public static void init(HttpServletRequest request,HttpServletResponse response){
        DataContext dataContext = new DataContext();
        dataContext.request = request;
        dataContext.response = response;
        dataContextContainer.set(dataContext);
    }

    public static void destroy(){
        dataContextContainer.remove();
    }

    public static HttpServletRequest getRequest(){
        return dataContextContainer.get().request;
    }

    public static HttpServletResponse getResponse(){
        return dataContextContainer.get().response;
    }

    public static HttpSession getSession(){
        return getRequest().getSession();
    }

    public static ServletContext getServletContex(){
        return getRequest().getServletContext();
    }

    public static class Request{

        public static void put(String key,Object value){
            getRequest().setAttribute(key,value);
        }

        public static <T> T get(String key){
            return (T) getRequest().getAttribute(key);
        }

        public static void remove(String key){
            getRequest().removeAttribute(key);
        }

        public static Map<String,Object> getAll(){
            Map<String,Object> map = new HashMap<String, Object>();
            Enumeration<String> names = getRequest().getAttributeNames();
            while (names.hasMoreElements()){
                String name = names.nextElement();
                map.put(name,getRequest().getAttribute(name));
            }
            return map;
        }

    }



    public static class Session{

    }

    public static class Context{

    }

    public static class Cookie{

    }


    /**
    private static HttpSession getSession() {
        return DispatcherServlet.getSession();
    }
    **/
}
