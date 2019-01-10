package AbstractClasses;

import Helpers.DriverHelper;


public abstract class PageBase {
    protected String url = null;


    public DriverHelper dh;

    protected void getUrl()
    {
        System.out.println("Attempting navigate to " + url);
        dh.getUrl(url);
    }


}
