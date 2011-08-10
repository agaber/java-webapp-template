//  Copyright 2011 Nobody Inc.
//  
//  This program is free software: you can redistribute it and/or modify
//  it under the terms of the GNU General Public License as published by
//  the Free Software Foundation, either version 3 of the License, or
//  (at your option) any later version.
//  
//  This program is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU General Public License for more details.
//  
//  You should have received a copy of the GNU General Public License
//  along with this program.  If not, see <http://www.gnu.org/licenses/>.

package com.acme.myapp;

import static org.easymock.EasyMock.*;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

public class HelloWorldServletTest {

  @Test
  public final void itShouldSayHelloWorld() throws Exception {
    HttpServletRequest request = createMock(HttpServletRequest.class);
    HttpServletResponse response = createMock(HttpServletResponse.class);
    PrintWriter writer = createMock(PrintWriter.class);
    
    response.setContentType("text/html");
    expect(response.getWriter()).andReturn(writer);
    writer.print("<!doctype html>");
    writer.print("<html><head><title>Super</title></head><body><h1>Hello World</h1></body></html>");
    replay(request, response, writer);
    
    HelloWorldServlet servlet = new HelloWorldServlet();
    servlet.doGet(request, response);

    verify(request, response, writer);
  }
}
