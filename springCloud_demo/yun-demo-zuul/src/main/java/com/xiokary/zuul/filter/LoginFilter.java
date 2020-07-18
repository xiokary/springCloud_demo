package com.xiokary.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
@Component
public class LoginFilter extends ZuulFilter {
    /**
     * 过滤器的选择 类型有pre、route、post、error
     * @return 返回值是上方4个中其中一种
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 执行顺序，返回值越小优先级越高
     * @return
     */
    @Override
    public int filterOrder() {
        return 20;
    }

    /**
     * 是否执行该过滤器
     * true:执行run方法
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 编写过滤器业务逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //初始化context上下文对象
        RequestContext context = RequestContext.getCurrentContext();
        //获取request对象
        HttpServletRequest request = context.getRequest();

        //获取参数
        String token = request.getParameter("token");
        //处理参数
        if(token.isBlank()){
            //拦截，不转发请求
            context.setSendZuulResponse(false);
            //设置响应状态码，401-身份未认证
            context.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            //设置响应提示
            context.setResponseBody("request error!");
        }
        //返回器为null，就代表过滤器什么都不做
        return null;
    }
}
