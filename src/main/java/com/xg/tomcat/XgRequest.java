package com.xg.tomcat;

import java.io.IOException;
import java.io.InputStream;

public class XgRequest {

    private String url;
    private String method;

    public XgRequest(InputStream inputStream) throws IOException {
        String httpRequest = "";
        byte[] httpRequestByte = new byte[1024];
        int length = 0;
        if((length = inputStream.read(httpRequestByte)) > 0){
            httpRequest = new String(httpRequestByte, 0, length);
        }
        String httpHead = httpRequest.split("\n")[0];
        //url = httpHead.split("\\s")[1];
        //method = httpHead.split("\\s")[0];
        String[] httpHeadArray = httpHead.split("\\s");
        url = httpHeadArray[1];
        method = httpHeadArray[0];
        System.err.println("XgRequest -> XgRequest : " + this);
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
