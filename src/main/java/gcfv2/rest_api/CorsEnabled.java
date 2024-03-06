package gcfv2.rest_api;import com.google.cloud.functions.HttpFunction;import com.google.cloud.functions.HttpRequest;import com.google.cloud.functions.HttpResponse;import java.io.BufferedWriter;import java.io.IOException;import java.net.HttpURLConnection;public class CorsEnabled implements HttpFunction {  @Override  public void service(HttpRequest request, HttpResponse response)      throws IOException {    response.appendHeader("Access-Control-Allow-Origin", "*");    if ("OPTIONS".equals(request.getMethod())) {      response.appendHeader("Access-Control-Allow-Methods", "GET");      response.appendHeader("Access-Control-Allow-Headers", "Content-Type");      response.appendHeader("Access-Control-Max-Age", "3600");      response.setStatusCode(HttpURLConnection.HTTP_NO_CONTENT);      return;    }    // Handle the main request.    BufferedWriter writer = response.getWriter();    writer.write("CORS headers set successfully!");  }}