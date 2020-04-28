package com.xg.tomcat;

import java.io.IOException;

/**
 * @program: my-tomcat
 * @description:
 * @author: gzk
 * @create: 2020-04-28 10:58
 **/
public abstract class XgServlet {

    public abstract void doGet(XgRequest request, XgResponse response);

    public abstract void doPost(XgRequest request, XgResponse response);

    public void servlet(XgRequest request, XgResponse response) throws IOException {
        if(request.getMethod().equalsIgnoreCase("POST")){
            doPost(request,response);
        }else if(request.getMethod().equalsIgnoreCase("GET")){
            doGet(request, response);
        }else{
            response.write("请求不合法！");
        }
    }

}
