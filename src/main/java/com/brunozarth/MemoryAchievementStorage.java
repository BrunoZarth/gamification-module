package com.brunozarth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MemoryAchievementStorage implements AchievementStorage{

    private static final HashMap<String, List<Achievement>> userAchievementList = new HashMap<>();

    @Override
    public void addAchievement(String user, Achievement a) {

        if(getAchievement(user, a.getName()).getName() == "Achievement Not Found"){
            if(!userAchievementList.containsKey(user)){
                List<Achievement> newAchievementList = new ArrayList<>();
                newAchievementList.add(a);
                userAchievementList.put(user, newAchievementList);
            } else{
                userAchievementList.get(user).add(a);
            }
            achievementUpdate(user, a);
            return;
        }

        Achievement userSavedAchievement = getAchievement(user, a.getName());
        if(a instanceof Points){
            ((Points) userSavedAchievement).addPoints(((Points) a).getPoints());
            achievementUpdate(user, userSavedAchievement);
        }

    }

    @Override
    public List<Achievement> getAchievements(String user) {
        if(userAchievementList.containsKey(user)) return userAchievementList.get(user);
        return new ArrayList<>();
    }

    @Override
    public Achievement getAchievement(String user, String achievementName) {
        if(userAchievementList.containsKey(user)){
            for(Achievement achievement : getAchievements(user)){
                if(achievement.getName().equals(achievementName)) return achievement;
            }
        }
        return new Achievement("Achievement Not Found");
    }

    @Override
    public void achievementUpdate(String user, Achievement a) {
        if(a instanceof Points){
            if(a.getName() == "CREATION" && ((Points) a).getPoints() >= 100){
                Badge badge = new Badge("INVENTOR");
                this.addAchievement(user, badge);
            }
            if(a.getName() == "PARTICIPATION" && ((Points) a).getPoints() >= 100){
                Badge badge = new Badge("PART OF THE COMMUNITY");
                this.addAchievement(user, badge);
            }
        }
    }
}
