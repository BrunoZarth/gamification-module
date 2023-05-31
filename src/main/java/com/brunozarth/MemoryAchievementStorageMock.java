package com.brunozarth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MemoryAchievementStorageMock extends MemoryAchievementStorage {

    private HashMap<String, List<Achievement>> userAchievementList;

    public MemoryAchievementStorageMock(){
        this.userAchievementList = new HashMap<>();
    }


}
