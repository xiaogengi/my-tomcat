package com.xg.tomcat;

import java.io.IOException;

/**
 * @program: my-tomcat
 * @description:
 * @author: gzk
 * @create: 2020-04-28 11:05
 **/
public class FindUserServlet extends XgServlet {
    @Override
    public void doGet(XgRequest request, XgResponse response) {
        try {
            response.write("get user ....");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(XgRequest request, XgResponse response) {
        try {
            response.write("post user ....");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
