package com.macikgoz.utilities;

import com.macikgoz.pages.android.apiDemos.nativeapp.ApiDemos;
import com.macikgoz.pages.android.generalStore.nativeapp.GeneralStore;
import com.macikgoz.pages.android.google.browser.Google;

public class Projects {

    public static Projects getProjects()
    {
        return new Projects();
    }
    public static ApiDemos apiDemos()
    {
        return new ApiDemos();
    }
    public static GeneralStore generalStore()
    {
        return  new GeneralStore();
    }
    public static Google google()
    {
        return new Google();
    }

}
