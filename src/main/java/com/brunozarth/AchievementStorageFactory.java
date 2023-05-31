package com.brunozarth;

public class AchievementStorageFactory {


    private static AchievementStorage achievementStorage;

    static AchievementStorage getAchievementStorage() {
        if(AchievementStorageFactory.achievementStorage == null) achievementStorage = new NullAchievementStorage();
        return achievementStorage;
    }

    static void setAchievementStorage(AchievementStorage a){
        achievementStorage = a;
    }

}
