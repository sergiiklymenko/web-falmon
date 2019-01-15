package AbstractClasses;

import Helpers.DriverHelper;
import Helpers.Session;


public abstract class PageBase {
    protected String url = null;
    protected String domain = null;
    public DriverHelper dh;


    public PageBase (){
        domain = Session.getDomain().toLowerCase();
        url = domain;
        dh = new DriverHelper();
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
