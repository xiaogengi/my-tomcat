package com.xg.tomcat;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: my-tomcat
 * @description:
 * @author: gzk
 * @create: 2020-04-28 11:09
 **/
public class XgServletMappingConfig {

    public static List<XgServletMapping> SERVLET_MAPPING_LIST = new ArrayList<XgServletMapping>();

    static {
           SERVLET_MAPPING_LIST.add(new XgServletMapping("findUser", "/user", "com.xg.tomcat.FindUserServlet"));
           SERVLET_MAPPING_LIST.add(new XgServletMapping("helloWord", "/helloWord", "com.xg.tomcat.HelloWordServlet"));
    }

}
