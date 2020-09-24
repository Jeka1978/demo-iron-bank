package com.ebay.demoironbank.controllers;

import com.ebay.demoironbank.services.BankService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

/**
 * @author Evgeny Borisov
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class BodyFixingFilter implements Filter {


    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String body = servletRequest.getReader().lines().collect(Collectors.joining());
        MyRequest myRequest = new MyRequest((HttpServletRequest) servletRequest, body);
        filterChain.doFilter(myRequest,servletResponse);
    }

    class MyRequest extends HttpServletRequestWrapper{

        private final String body;

        public MyRequest(HttpServletRequest request, String body) {
            super(request);
            this.body = body;
        }

        @Override
        public ServletInputStream getInputStream() throws IOException {
            byte[] bytes;
            if (body.contains("ebayProductName")) {
                EbayProductUSD productUSD = objectMapper.readValue(body, EbayProductUSD.class);
                EbayProductNIS productNIS = EbayProductNIS.builder().cost(productUSD.getPrice() * 3.5).ebayProductName(productUSD.getEbayProductName()).build();
                String newBody = objectMapper.writeValueAsString(productNIS);
                bytes = newBody.getBytes(StandardCharsets.UTF_8);
            }else {
                bytes = body.getBytes(StandardCharsets.UTF_8);
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);

            return new ServletInputStream() {
                @Override
                public boolean isFinished() {
                    return byteArrayInputStream.available()==0;
                }

                @Override
                public boolean isReady() {
                    return true;
                }

                @Override
                public void setReadListener(ReadListener readListener) {

                }

                @Override
                public int read() throws IOException {
                    return byteArrayInputStream.read();
                }
            };

        }
    }
}








