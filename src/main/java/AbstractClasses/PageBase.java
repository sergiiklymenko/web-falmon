package AbstractClasses;

import Helpers.DriverHelper;


public abstract class PageBase {
    protected String url = null;
    protected String domain = null;
    public DriverHelper dh;

    public PageBase (){
        domain = getDomain();
        url = domain;
    }

    public String getDomain()
    {
        return domain;
    }

    protected void getUrl()
    {
        System.out.println("Attempting navigate to " + url);
        dh.getURL(url);
    }



}
