import java.io.IOException;
import java.io.PrintWriter;
import java.time.DateTimeException;
import java.time.ZoneId;
import java.time.ZoneOffset;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/time")
public class TimezoneValidateFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String timeZone = httpRequest.getParameter("timezone");

        if (timeZone != null && !timeZone.isEmpty()) {
            if (timeZone.startsWith("UTC")) {
                String offsetStr = timeZone.substring(3).trim();
                try {
                    int offsetHours = Integer.parseInt(offsetStr);
                    ZoneId.ofOffset("UTC", ZoneOffset.ofHours(offsetHours));
                } catch (DateTimeException e) {
                    httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    PrintWriter out = httpResponse.getWriter();
                    out.println("<html><body><h2>Invalid timezone</h2></body></html>");
                    return;
                }
            } else {
                httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                PrintWriter out = httpResponse.getWriter();
                out.println("<html><body><h2>Invalid timezone</h2></body></html>");
                return;
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}