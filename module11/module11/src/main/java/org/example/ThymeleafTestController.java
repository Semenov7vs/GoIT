package org.example;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.FileTemplateResolver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/time")
public class ThymeleafTestController extends HttpServlet {
    private TemplateEngine engine;

    @Override
    public void init() throws ServletException {
        engine = new TemplateEngine();

        FileTemplateResolver resolver = new FileTemplateResolver();
        resolver.setPrefix("C:/Users/these/Desktop/GoIt/GoIt/module11/module11/src/main/webapp/WEB-INF/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        resolver.setOrder(engine.getTemplateResolvers().size());
        resolver.setCacheable(false);
        engine.addTemplateResolver(resolver);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String timezone = req.getParameter("timezone");

        if (timezone != null) {
            timezone = URLDecoder.decode(timezone, "UTF-8");
            timezone = timezone.replace(" ", "+");
        }

        String lastTimezone = null;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("lastTimezone".equals(cookie.getName())) {
                    lastTimezone = URLDecoder.decode(cookie.getValue(), "UTF-8");
                    break;
                }
            }
        }

        if (timezone == null && lastTimezone != null) {
            timezone = lastTimezone;
        } else if (timezone == null) {
            timezone = "UTC";
        }
        if (!isValidTimezoneFormat(timezone)) {
            timezone = "UTC";
        }

        Cookie timezoneCookie = new Cookie("lastTimezone", URLEncoder.encode(timezone, "UTF-8"));
        resp.addCookie(timezoneCookie);

        ZoneOffset zoneOffset;
        if (timezone.startsWith("UTC")) {

            int offsetHours = 0;
            if (timezone.length() > 3) {
                offsetHours = Integer.parseInt(timezone.substring(3).replace("+", ""));
            }
            zoneOffset = ZoneOffset.ofHours(offsetHours);
        } else {
            zoneOffset = ZoneOffset.UTC;
        }

        OffsetDateTime currentTime = OffsetDateTime.now(zoneOffset);

        Context simpleContext = new Context(req.getLocale());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedCurrentTime = currentTime.format(formatter);
        simpleContext.setVariable("currentTime", formattedCurrentTime + " " + timezone);

        engine.process("test", simpleContext, resp.getWriter());
        resp.getWriter().close();
    }

    private boolean isValidTimezoneFormat(String timezone) {
        Pattern pattern = Pattern.compile("^UTC[+-]\\d+$");
        Matcher matcher = pattern.matcher(timezone);
        return matcher.matches();
    }
}
