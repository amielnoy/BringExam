public class Group {
    String groupName;
    String desiredSite;
    int desiredSize;

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setDesiredSite(String desiredSite) {
        this.desiredSite = desiredSite;
    }

    public void setDesiredSize(int desiredSize) {
        this.desiredSize = desiredSize;
    }

    public int getDesiredSize() {
        return desiredSize;
    }

    public Group(String groupName, String desiredSite,int desiredSize){
        this.groupName=groupName;
        this.desiredSite=desiredSite;
        this.desiredSize=desiredSize;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getDesiredSite() {
        return desiredSite;
    }
}
