package Helpers;

public class Session {
    private static String domain = null;

    public Session(String domain){
        setDomain(domain);

    }
    private void setDomain(String domain)
    {
        this.domain = domain;
    }
    public static String getDomain()
    {
        return domain;
    }
}
