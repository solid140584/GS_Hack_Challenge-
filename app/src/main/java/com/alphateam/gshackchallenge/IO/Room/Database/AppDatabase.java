package com.alphateam.gshackchallenge.IO.Room.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.alphateam.gshackchallenge.IO.Room.Dao.MedidorDao;
import com.alphateam.gshackchallenge.IO.Room.Entity.Medidor;


/**
 * Created by ISC Jesús Romero Mtz on 23/08/2019
 */
@Database(entities = {Medidor.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;
    public abstract MedidorDao medidorDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "GsHackChallengeDB")
                    // allow queries on the main thread.
                    // Don't do this on a real app! See PersistenceBasicSample for an example.
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}