public class Site {
    String siteName;
    int maxSiteCapacity;
    int totalDesiredCapacity;

    public void setTotalDesiredCapacity(int totalDesiredCapacity) {
        this.totalDesiredCapacity = totalDesiredCapacity;
    }

    public int getTotalDesiredCapacity() {
        return totalDesiredCapacity;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteName() {
        return siteName;
    }

    public int getMaxSiteCapacity() {
        return maxSiteCapacity;
    }

    public void setMaxSiteCapacity(int maxSiteCapacity) {
        this.maxSiteCapacity = maxSiteCapacity;
    }

    public Site(String siteName, int maxSiteCapacity){
        this.siteName=siteName;
        this.maxSiteCapacity=maxSiteCapacity;
        this.totalDesiredCapacity=0;
    }
}
