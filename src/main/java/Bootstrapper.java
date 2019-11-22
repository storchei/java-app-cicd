
public class Bootstrapper {

    public static void main(String[] args) {
        System.out.println("sun.net.InetAddressCachePolicy.get() = {}" + sun.net.InetAddressCachePolicy.get());

        System.out.println("System.getProperty(\"networkaddress.cache.ttl\") = {}" + System.getProperty("networkaddress.cache.ttl"));
        System.out.println("java.security.Security.getProperty(\"networkaddress.cache.ttl\") = {}" + java.security.Security.getProperty("networkaddress.cache.ttl"));

        System.out.println("System.getProperty(\"sun.net.inetaddr.ttl\") = {}" + System.getProperty("sun.net.inetaddr.ttl"));
        System.out.println("java.security.Security.getProperty(\"sun.net.inetaddr.ttl\") = {}" + java.security.Security.getProperty("sun.net.inetaddr.ttl"));

        System.out.println("System.getProperty(\"networkaddress.cache.negative.ttl\") = {}" + System.getProperty("networkaddress.cache.negative.ttl"));
        System.out.println("java.security.Security.getProperty(\"networkaddress.cache.negative.ttl\") = {}" + java.security.Security.getProperty("networkaddress.cache.negative.ttl"));
    }
}