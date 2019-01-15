package AbstractClasses;

import Helpers.DriverHelper;
import Helpers.Session;


public abstract class PageBase {
    protected String url = null;
    protected String domain = null;
    public DriverHelper dh = new DriverHelper();;


    public PageBase (){
        domain = Session.getDomain().toLowerCase();
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
