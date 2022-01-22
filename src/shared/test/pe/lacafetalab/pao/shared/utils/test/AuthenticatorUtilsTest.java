package pe.lacafetalab.pao.shared.utils.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Part;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import pe.lacafetalab.pao.shared.utils.AuthenticatorUtils;

@RunWith(MockitoJUnitRunner.class)
@TestMethodOrder(OrderAnnotation.class)
public class AuthenticatorUtilsTest {

	@Test
	@Order(1)
	public void test01_getToken() {
		String token = "abcd1234";
		String getToken = AuthenticatorUtils.findToken(String.format("Bearer %s", token));
		assertEquals(token, getToken);
	}

	@Test
	@Order(2)
	public void test01_getTokenFromRequest() {
		String token = "abcd1234";
		HttpServletRequest request = getRequest(String.format("Bearer %s", token));
		String getToken = AuthenticatorUtils.findToken(request);
		assertEquals(token, getToken);
	}

	private HttpServletRequest getRequest(String header) {
		return new HttpServletRequest() {

			@Override
			public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
				return null;
			}

			@Override
			public AsyncContext startAsync() throws IllegalStateException {
				return null;
			}

			@Override
			public void setCharacterEncoding(String env) throws UnsupportedEncodingException {
			}

			@Override
			public void setAttribute(String name, Object o) {
			}

			@Override
			public void removeAttribute(String name) {
			}

			@Override
			public boolean isSecure() {
				return false;
			}

			@Override
			public boolean isAsyncSupported() {
				return false;
			}

			@Override
			public boolean isAsyncStarted() {
				return false;
			}

			@Override
			public ServletContext getServletContext() {
				return null;
			}

			@Override
			public int getServerPort() {
				return 0;
			}

			@Override
			public String getServerName() {
				return null;
			}

			@Override
			public String getScheme() {
				return null;
			}

			@Override
			public RequestDispatcher getRequestDispatcher(String path) {
				return null;
			}

			@Override
			public int getRemotePort() {
				return 0;
			}

			@Override
			public String getRemoteHost() {
				return null;
			}

			@Override
			public String getRemoteAddr() {
				return null;
			}

			@Override
			public String getRealPath(String path) {
				return null;
			}

			@Override
			public BufferedReader getReader() throws IOException {
				return null;
			}

			@Override
			public String getProtocol() {
				return null;
			}

			@Override
			public String[] getParameterValues(String name) {
				return null;
			}

			@Override
			public Enumeration<String> getParameterNames() {
				return null;
			}

			@Override
			public Map<String, String[]> getParameterMap() {
				return null;
			}

			@Override
			public String getParameter(String name) {
				return null;
			}

			@Override
			public Enumeration<Locale> getLocales() {
				return null;
			}

			@Override
			public Locale getLocale() {
				return null;
			}

			@Override
			public int getLocalPort() {
				return 0;
			}

			@Override
			public String getLocalName() {
				return null;
			}

			@Override
			public String getLocalAddr() {
				return null;
			}

			@Override
			public ServletInputStream getInputStream() throws IOException {
				return null;
			}

			@Override
			public DispatcherType getDispatcherType() {
				return null;
			}

			@Override
			public String getContentType() {
				return null;
			}

			@Override
			public long getContentLengthLong() {
				return 0;
			}

			@Override
			public int getContentLength() {
				return 0;
			}

			@Override
			public String getCharacterEncoding() {
				return null;
			}

			@Override
			public Enumeration<String> getAttributeNames() {
				return null;
			}

			@Override
			public Object getAttribute(String name) {
				return null;
			}

			@Override
			public AsyncContext getAsyncContext() {
				return null;
			}

			@Override
			public <T extends HttpUpgradeHandler> T upgrade(Class<T> httpUpgradeHandlerClass) throws IOException, ServletException {
				return null;
			}

			@Override
			public void logout() throws ServletException {
			}

			@Override
			public void login(String username, String password) throws ServletException {

			}

			@Override
			public boolean isUserInRole(String role) {
				return false;
			}

			@Override
			public boolean isRequestedSessionIdValid() {
				return false;
			}

			@Override
			public boolean isRequestedSessionIdFromUrl() {
				return false;
			}

			@Override
			public boolean isRequestedSessionIdFromURL() {
				return false;
			}

			@Override
			public boolean isRequestedSessionIdFromCookie() {
				return false;
			}

			@Override
			public Principal getUserPrincipal() {
				return null;
			}

			@Override
			public HttpSession getSession(boolean create) {
				return null;
			}

			@Override
			public HttpSession getSession() {
				return null;
			}

			@Override
			public String getServletPath() {
				return null;
			}

			@Override
			public String getRequestedSessionId() {
				return null;
			}

			@Override
			public StringBuffer getRequestURL() {
				return null;
			}

			@Override
			public String getRequestURI() {
				return null;
			}

			@Override
			public String getRemoteUser() {
				return null;
			}

			@Override
			public String getQueryString() {
				return null;
			}

			@Override
			public String getPathTranslated() {
				return null;
			}

			@Override
			public String getPathInfo() {
				return null;
			}

			@Override
			public Collection<Part> getParts() throws IOException, ServletException {
				return null;
			}

			@Override
			public Part getPart(String name) throws IOException, ServletException {
				return null;
			}

			@Override
			public String getMethod() {
				return null;
			}

			@Override
			public int getIntHeader(String name) {
				return 0;
			}

			@Override
			public Enumeration<String> getHeaders(String name) {
				return null;
			}

			@Override
			public Enumeration<String> getHeaderNames() {
				return null;
			}

			@Override
			public String getHeader(String name) {
				return header;
			}

			@Override
			public long getDateHeader(String name) {
				return 0;
			}

			@Override
			public Cookie[] getCookies() {
				return null;
			}

			@Override
			public String getContextPath() {
				return null;
			}

			@Override
			public String getAuthType() {
				return null;
			}

			@Override
			public String changeSessionId() {
				return null;
			}

			@Override
			public boolean authenticate(HttpServletResponse response) throws IOException, ServletException {
				return false;
			}
		};
	}
}