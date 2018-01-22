package com.mars.android20180117_1.data;

import android.content.Context;

/**
 * Created by Student on 2018/1/18.
 */

public class studentDAOFactory {
    //建構式
    public static studentDAO getDAOInstance(Context context, DBType dbType)
    {
        switch (dbType)
        {
            case MEMORY:
                return new studentscoreDAO();
            case FILE:
                return new studentFileDAO(context);
            case DB:
                return new StudentDAODBImpl(context);
        }
        return null;
    }
}
