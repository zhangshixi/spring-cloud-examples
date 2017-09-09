package spring.cloud.example.zuul.filter;

import com.netflix.zuul.ZuulFilter;

/**
 * Created 2017-09-09 21:21:20
 *
 * @author Michael.Zhang
 */
public abstract class PreZuulFilter extends ZuulFilter {

    /**
     * 返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     * pre：可以在请求被路由之前调用
     * routing：在路由请求时候被调用
     * post：在routing和error过滤器之后被调用
     * error：处理请求时发生错误时被调用
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 返回一个boolean类型来判断该过滤器是否要执行，通过此函数可实现过滤器的开关。
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

}
