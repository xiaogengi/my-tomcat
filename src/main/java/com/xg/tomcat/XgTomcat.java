package com.xg.tomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: my-tomcat
 * @description: XgTomcat
 * @author: gzk
 * @create: 2020-04-28 11:26
 **/
public class XgTomcat {

    private int port =8080;
    private Map<String, String> urlServletMap = new HashMap<String, String>();

    public XgTomcat() {
    }

    public XgTomcat(int port){
        this.port = port;
    }


    public void start(){
        initServletMapping();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("XgTomcat is start ...");

            while (true) {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                XgRequest xgRequest = new XgRequest(inputStream);
                XgResponse xgResponse = new XgResponse(outputStream);
                dispatch(xgRequest, xgResponse);
                socket.close();
            }
        } catch (Exception e){

        }
    }


    private void initServletMapping(){
        for (XgServletMapping xgServletMapping : XgServletMappingConfig.SERVLET_MAPPING_LIST){
            urlServletMap.put(xgServletMapping.getUrl(), xgServletMapping.getClazz());
        }
    }

    private void dispatch(XgRequest request, XgResponse response){
        String clazz = urlServletMap.get(request.getUrl());
        try {
            Class<XgServlet> xgServletClass = (Class<XgServlet>) Class.forName(clazz);
            try {
                XgServlet xgServlet = xgServletClass.newInstance();
                xgServlet.servlet(request,response);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new XgTomcat().start();
    }





}
