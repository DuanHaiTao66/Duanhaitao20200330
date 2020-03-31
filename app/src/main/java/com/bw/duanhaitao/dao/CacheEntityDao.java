package com.bw.duanhaitao.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.bw.duanhaitao.CacheEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CACHE_ENTITY".
*/
public class CacheEntityDao extends AbstractDao<CacheEntity, String> {

    public static final String TABLENAME = "CACHE_ENTITY";

    /**
     * Properties of entity CacheEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Url = new Property(0, String.class, "url", true, "URL");
        public final static Property Json = new Property(1, String.class, "json", false, "JSON");
    }


    public CacheEntityDao(DaoConfig config) {
        super(config);
    }
    
    public CacheEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CACHE_ENTITY\" (" + //
                "\"URL\" TEXT PRIMARY KEY NOT NULL ," + // 0: url
                "\"JSON\" TEXT);"); // 1: json
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CACHE_ENTITY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, CacheEntity entity) {
        stmt.clearBindings();
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(1, url);
        }
 
        String json = entity.getJson();
        if (json != null) {
            stmt.bindString(2, json);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, CacheEntity entity) {
        stmt.clearBindings();
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(1, url);
        }
 
        String json = entity.getJson();
        if (json != null) {
            stmt.bindString(2, json);
        }
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public CacheEntity readEntity(Cursor cursor, int offset) {
        CacheEntity entity = new CacheEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // url
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // json
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, CacheEntity entity, int offset) {
        entity.setUrl(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setJson(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    @Override
    protected final String updateKeyAfterInsert(CacheEntity entity, long rowId) {
        return entity.getUrl();
    }
    
    @Override
    public String getKey(CacheEntity entity) {
        if(entity != null) {
            return entity.getUrl();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(CacheEntity entity) {
        return entity.getUrl() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}