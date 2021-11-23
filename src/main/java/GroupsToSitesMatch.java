import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

//pyCharm
//interpeter python 3 or greater
//requests
public class GroupsToSitesMatch {
    private HashMap<String, String> Groups;
    private HashMap<String, Integer> Sites;

    LinkedList<Site> getTheSitesGroupsDesire(LinkedList<Group> listOfGroups) {
        LinkedList<Site> mySitesList = new LinkedList<Site>();
        HashSet<String> MyHashSet = new HashSet<String>();
        for (Group currGroup : listOfGroups) {
            MyHashSet.add(currGroup.getDesiredSite());
        }


        for (String mySiteName : MyHashSet) {
            mySitesList.add(new Site(mySiteName, 0));
        }
        return mySitesList;
    }

    public void setSites(HashMap<String, Integer> sites) {
        Sites = sites;
    }

    public void setGroups(HashMap<String, String> groups) {
        this.Groups = groups;
    }

    LinkedList<Site> getAllDesiredSitesThatCanCloseDeal(LinkedList<Group> listOfGroups) {
        LinkedList<Site> mySitesList = getTheSitesGroupsDesire(listOfGroups);
        LinkedList<Site> myClosedDealSitesList = new LinkedList<Site>();
        int siteIndex, tempSiteCapcity = 0;
        for (siteIndex = 0; siteIndex < mySitesList.size(); ++siteIndex) {
            for (Group currGroup : listOfGroups) {
                if (currGroup.getDesiredSite().equals(mySitesList.get(siteIndex).getSiteName())) {
                    tempSiteCapcity = currGroup.getDesiredSize() +
                            mySitesList.get(siteIndex).getTotalDesiredCapacity();
                    mySitesList.get(siteIndex).setTotalDesiredCapacity(tempSiteCapcity);
                    mySitesList.get(siteIndex).setMaxSiteCapacity(Sites.get(currGroup.getDesiredSite()));
                }
            }
        }
        for (Site currSite : mySitesList) {
            float threshold = (float) ((currSite.getMaxSiteCapacity() * 90) / 100);
            if (currSite.getTotalDesiredCapacity() >= threshold
                    && currSite.getTotalDesiredCapacity() <= currSite.getMaxSiteCapacity())
                myClosedDealSitesList.add(currSite);

        }
        return myClosedDealSitesList;
    }

    public void getMaxSizeGroupForEachSiteWhichMadeDeal(LinkedList<Group> listOfGroups) {
        LinkedList<Site> myClosedDealSitesList = getAllDesiredSitesThatCanCloseDeal(listOfGroups);
        int siteIndex;
        int currGroupSize = 0;
        int maxGroupSizePerSite = 0;

        for (siteIndex = 0; siteIndex < myClosedDealSitesList.size(); ++siteIndex) {
            for (String siteName : Groups.keySet()) {
                if (siteName.contains(myClosedDealSitesList.get(siteIndex).getSiteName())) {
                    currGroupSize = Integer.parseInt(Groups.get(siteName).split(",")[1]);
                    if (currGroupSize > maxGroupSizePerSite)
                        maxGroupSizePerSite = currGroupSize;
                }
            }
            System.out.println("For Site=" + myClosedDealSitesList.get(siteIndex).getSiteName()
                    + ", max group size=" + maxGroupSizePerSite);
        }
    }


    public HashMap<String, Integer> getSites() {
        return Sites;
    }

    public static void main(String[] args) {
        LinkedList<Group> myGroups = new LinkedList<>();
        ArrayList<Group> myArrayListGroups=new ArrayList<>();

        Group myGroup1 = new Group("g1", "haifa", 10);
        Group myGroup2 = new Group("g2", "haifa", 10);
        Group myGroup3 = new Group("g3", "TelAviv", 20);
        Group myGroup4 = new Group("g4", "TelAviv", 5);
        Group myGroup5 = new Group("g5", "K.ATA", 50);
        Group myGroup6 = new Group("g6", "K.ATA", 46);
        Group myGroup7 = new Group("g7", "Jerusalem", 10);
        Group myGroup8 = new Group("g8", "Jerusalem", 8);
        myGroups.add(myGroup1);
        myArrayListGroups.add(myGroup1);
        myGroups.add(myGroup2);
        myArrayListGroups.add(myGroup2);
        myGroups.add(myGroup3);
        myArrayListGroups.add(myGroup3);
        myGroups.add(myGroup4);
        myArrayListGroups.add(myGroup4);
        myGroups.add(myGroup5);
        myArrayListGroups.add(myGroup5);
        myGroups.add(myGroup6);
        myArrayListGroups.add(myGroup6);
        myGroups.add(myGroup7);
        myArrayListGroups.add(myGroup7);
        myGroups.add(myGroup8);
        myArrayListGroups.add(myGroup8);

        HashMap<String, String> myGroupsHashMap = new HashMap<>();
        myGroupsHashMap.put("haifa1", "g1,10");
        myGroupsHashMap.put("haifa2", "g2,10");
        myGroupsHashMap.put("TelAviv1", "g3,20");
        myGroupsHashMap.put("TelAviv2", "g4,5");
        myGroupsHashMap.put("K.ATA1", "g5,50");
        myGroupsHashMap.put("K.ATA2", "g6,46");
        myGroupsHashMap.put("Jerusalem1", "g7,10");
        myGroupsHashMap.put("Jerusalem2", "g8,8");
        GroupsToSitesMatch myGroupsToSitesMatch = new GroupsToSitesMatch();
        //a answer
        myGroupsToSitesMatch.setGroups(myGroupsHashMap);
                LinkedList<Site> myDesiredSitesList = myGroupsToSitesMatch.getTheSitesGroupsDesire(myGroups);
        for (Site mySite : myDesiredSitesList)
            System.out.println(mySite.siteName);


        HashMap<String, Integer> myDesiredSitesListToCloseDealHashMap = new HashMap<String, Integer>();
        myDesiredSitesListToCloseDealHashMap.put("haifa", 20);
        myDesiredSitesListToCloseDealHashMap.put("TelAviv", 30);
        myDesiredSitesListToCloseDealHashMap.put("Jerusalem", 20);
        myDesiredSitesListToCloseDealHashMap.put("K.ATA", 20);
        myGroupsToSitesMatch.setSites(myDesiredSitesListToCloseDealHashMap);

        //b answer
        LinkedList<Site> myDesiredSitesWhoCanCloseDealList = myGroupsToSitesMatch.getAllDesiredSitesThatCanCloseDeal(myGroups);
        System.out.println("Sites that can close a deal:");
        for (Site currSite : myDesiredSitesWhoCanCloseDealList)
            System.out.println(currSite.siteName);
        //c answer
        myGroupsToSitesMatch.getMaxSizeGroupForEachSiteWhichMadeDeal(myGroups);
        //d answer
        HashMap<String, String> groupToSiteHashmap = (HashMap<String, String>) myArrayListGroups.stream().collect(toMap(Group::getDesiredSite,Group::getGroupName));

    }

}


