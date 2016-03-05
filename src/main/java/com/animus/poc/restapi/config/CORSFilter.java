package com.animus.poc.restapi.config;

import java.io.IOException;



import javax.servlet.Filter;

import javax.servlet.FilterChain;

import javax.servlet.FilterConfig;

import javax.servlet.ServletException;

import javax.servlet.ServletRequest;

import javax.servlet.ServletResponse;

import javax.servlet.annotation.WebFilter;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

 

/**

* Servlet Filter implementation class CORSFilter

*/

@WebFilter("/*")

public class CORSFilter implements Filter {

 

    /**

     * Default constructor.

     */

    public CORSFilter() {

    }

 

          /**

          * @see Filter#destroy()

          */

          public void destroy() {

          }

 

          /**

          * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)

          */

          public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

 

                   HttpServletResponse response = (HttpServletResponse) res;

        HttpServletRequest request= (HttpServletRequest) req;

       

        response.setHeader("Access-Control-Allow-Origin", "*");

        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");

        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");

        response.setHeader("Access-Control-Expose-Headers", "x-requested-with"); 

                   chain.doFilter(request, response);

          }

 

          /**

          * @see Filter#init(FilterConfig)

          */

          public void init(FilterConfig fConfig) throws ServletException {

          }

 

}

