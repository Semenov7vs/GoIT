import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/time")
public class TimeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            String timeZone = request.getParameter("timezone");
            ZoneId zoneId = null;

            if (timeZone == null || timeZone.isEmpty()) {
                zoneId = ZoneId.of("UTC");
            } else if (timeZone.startsWith("UTC")) {
                String offsetStr = timeZone.substring(3).trim();
                int offsetHours = Integer.parseInt(offsetStr);
                zoneId = ZoneId.ofOffset("UTC", ZoneOffset.ofHours(offsetHours));
            } else {
                throw new IllegalArgumentException("Параметр 'timezone' повинен мати формат 'UTC+час'");
            }

            ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss zzz");
            String formattedTime = zonedDateTime.format(formatter);

            String htmlResponse = "<html><body>"
                    + "<h2>Поточний час: " + formattedTime + "</h2>"
                    + "</body></html>";

            out.println(htmlResponse);
        } catch (Exception e) {
            out.println("<html><body><h2>Помилка: " + e.getMessage() + "</h2></body></html>");
            e.printStackTrace(out);
        }
    }
}
