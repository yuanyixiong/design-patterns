package 动态代理_注解增强;


import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DyNaProxy
 * @Author： yuanyixiong
 * @Date： 2019/12/26 下午9:14
 * @Description： TODO
 * @Version： 1.0
 */
public class DynaProxy implements InvocationHandler {

    public Object bind(Class targetClass) {
        return Proxy.newProxyInstance(targetClass.getClassLoader(), new Class[]{targetClass}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Annotation[] annotations = method.getAnnotations();
        if (null == annotations) {
            return null;
        }
        for (Annotation annotation : annotations) {

            if (annotation instanceof Get) {
                return handleGetRequest((Get) annotation, method, args);
            } else if (annotation instanceof Post) {
                return handlePostRequest((Post) annotation, method, args);
            } else if (annotation instanceof Put) {
                return handlePutRequest((Put) annotation, method, args);
            } else if (annotation instanceof Delete) {
                return handleDeleteRequest((Delete) annotation, method, args);
            } else {
                System.out.println("未知请求类型");
            }

        }


        return null;
    }


    private Map<String, Object> requestParams(Method method, Object[] params) {

        Map<String, Object> requestParams = new HashMap<>();
        if (null == params || params.length <= 0) {
            return requestParams;
        }

        for (int i = 0; i < params.length; i++) {
            Query query = method.getParameters()[i].getAnnotation(Query.class);
            if (null == query) {
                continue;
            }
            requestParams.put(query.value(), params[i]);
        }

        return requestParams;
    }

    private Class responseResult(Method method) {
        return null;
    }

    private String handleGetRequest(Get get, Method method, Object[] params) {

        //注解参数识别,组装
        StringBuilder url = new StringBuilder(get.value());
        Map<String, Object> requestParams = requestParams(method, params);
        if (!requestParams.isEmpty()) {

            if (url.lastIndexOf("?") == -1) {
                url.append("?");
            }

            requestParams.forEach((k, v) -> {
                url.append(k).append("=").append(v).append("&");
            });

            url.delete(url.length() - 1, url.length());
        }

        //请求http
        System.out.println(url);

        //处理http响应
        responseResult(method);

        return "get";
    }

    private String handlePostRequest(Post post, Method method, Object[] params) {

        StringBuilder url = new StringBuilder(post.value());
        Map<String, Object> requestParams = requestParams(method, params);

        //请求http
        System.out.println(url);

        //处理http响应
        responseResult(method);

        return "post";
    }

    private String handlePutRequest(Put put, Method method, Object[] params) {

        StringBuilder url = new StringBuilder(put.value());
        Map<String, Object> requestParams = requestParams(method, params);

        //请求http
        System.out.println(url);

        //处理http响应
        responseResult(method);

        return "put";
    }

    private String handleDeleteRequest(Delete delete, Method method, Object[] params) {

        StringBuilder url = new StringBuilder(delete.value());
        Map<String, Object> requestParams = requestParams(method, params);

        //请求http
        System.out.println(url);

        //处理http响应
        responseResult(method);

        return "delete";
    }
}
