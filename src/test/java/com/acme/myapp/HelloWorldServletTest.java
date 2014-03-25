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

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RunWith(MockitoJUnitRunner.class)
public class HelloWorldServletTest {
  @Mock HttpServletRequest request;
  @Mock HttpServletResponse response;
  @Mock PrintWriter writer;

  HelloWorldServlet servlet;

  @Before
  public void beforeEach() throws Exception {
    servlet = new HelloWorldServlet();
  }

  @Test
  public final void itShouldSayHelloWorld() throws Exception {
    // Set up.
    when(response.getWriter()).thenReturn(writer);

    // Execute.
    servlet.doGet(request, response);

    // Verify.
    verify(response).setContentType("text/html");
    verify(writer).print("<!doctype html>");
    verify(writer).print(
        "<html><head><title>Super</title></head><body><h1>Hello World</h1></body></html>");
  }
}
