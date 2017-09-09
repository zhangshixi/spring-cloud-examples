package spring.cloud.example.zuul.filter.pre;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spring.cloud.example.zuul.filter.PreZuulFilter;

/**
 * Created 2016-11-20 13:38:49
 *
 * @author Michael.Zhang
 */
public class AccessFilter extends PreZuulFilter {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 通过返回的int值来定义过滤器的执行顺序。
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        logger.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

        String accessToken = request.getParameter("accessToken");
        if (accessToken == null || accessToken.isEmpty()) {
            logger.warn("access token is empty!");

            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }

        logger.info("access token is ok!");

        return null;
    }

}
