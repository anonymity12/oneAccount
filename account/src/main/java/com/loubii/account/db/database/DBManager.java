package com.loubii.account.db.database;

import android.database.sqlite.SQLiteException;

import com.loubii.account.util.Logger;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.Collection;
import java.util.List;

/**
 * @Description: 数据库操作管理
 * @date: 2017-01-07 11:32
 * tt 一种wrapper of getAbstractDao()
 */

// TODO: 2019-10-09 MK  是什么意思？
public abstract class DBManager<M, K> implements IDatabase<M, K> {

    @Override
    public boolean insert(@NotNull M m) {
        try {
            getAbstractDao().insert(m);
        } catch (SQLiteException e) {
            Logger.e(e.toString());
            return false;
        }
        return true;
    }

    @Override
    public boolean insertOrReplace(@NotNull M m) {
        try {
            getAbstractDao().insertOrReplace(m);
        } catch (SQLiteException e) {
            Logger.e(e.toString());
            return false;
        }
        return true;
    }

    // TODO: 2019-10-09
    //  tx 是什么意思？
    @Override
    public boolean insertInTx(@NotNull List<M> list) {
        try {
            getAbstractDao().insertInTx(list);
        } catch (SQLiteException e) {
            Logger.e(e.toString());
            return false;
        }
        return true;
    }

    @Override
    public boolean insertOrReplaceInTx(@NotNull List<M> list) {
        try {
            getAbstractDao().insertOrReplaceInTx(list);
        } catch (SQLiteException e) {
            Logger.e(e.toString());
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(@NotNull M m) {
        try {
            getAbstractDao().delete(m);
        } catch (SQLiteException e) {
            Logger.e(e.toString());
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteByKey(@NotNull K key) {
        try {
            getAbstractDao().deleteByKey(key);
        } catch (SQLiteException e) {
            Logger.e(e.toString());
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteInTx(@NotNull List<M> list) {
        try {
            getAbstractDao().deleteInTx(list);
        } catch (SQLiteException e) {
            Logger.e(e.toString());
            return false;
        }
        return true;
    }

    @SafeVarargs
    @Override
    public final boolean deleteByKeyInTx(@NotNull K... key) {
        try {
            getAbstractDao().deleteByKeyInTx(key);
        } catch (SQLiteException e) {
            Logger.e(e.toString());
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteAll() {
        try {
            getAbstractDao().deleteAll();
        } catch (SQLiteException e) {
            Logger.e(e.toString());
            return false;
        }
        return true;
    }

    @Override
    public boolean update(@NotNull M m) {
        try {
            getAbstractDao().update(m);
        } catch (SQLiteException e) {
            Logger.e(e.toString());
            return false;
        }
        return true;
    }

    @SafeVarargs
    @Override
    public final boolean updateInTx(@NotNull M... m) {
        try {
            getAbstractDao().updateInTx(m);
        } catch (SQLiteException e) {
            Logger.e(e.toString());
            return false;
        }
        return true;
    }

    @Override
    public boolean updateInTx(@NotNull List<M> list) {
        try {
            getAbstractDao().updateInTx(list);
        } catch (SQLiteException e) {
            Logger.e(e.toString());
            return false;
        }
        return true;
    }

    @Override
    public M load(@NotNull K key) {
        try {
            return getAbstractDao().load(key);
        } catch (SQLiteException e) {
            Logger.e(e.toString());
            return null;
        }
    }

    @Override
    public List<M> loadAll() {
        return getAbstractDao().loadAll();
    }

    @Override
    public boolean refresh(@NotNull M m) {
        try {
            getAbstractDao().refresh(m);
        } catch (SQLiteException e) {
            Logger.e(e.toString());
            return false;
        }
        return true;
    }

    @Override
    public void runInTx(@NotNull Runnable runnable) {
        try {
            getAbstractDao().getSession().runInTx(runnable);
        } catch (SQLiteException e) {
            Logger.e(e.toString());
        }
    }

    @Override
    public QueryBuilder<M> queryBuilder() {
        return getAbstractDao().queryBuilder();
    }

    @Override
    public List<M> queryRaw(@NotNull String where, @NotNull String... selectionArg) {
        return getAbstractDao().queryRaw(where, selectionArg);
    }

    @Override
    public Query<M> queryRawCreate(@NotNull String where, @NotNull Object... selectionArg) {
        return getAbstractDao().queryRawCreate(where, selectionArg);
    }

    @Override
    public Query<M> queryRawCreateListArgs(@NotNull String where, @NotNull Collection<Object> selectionArg) {
        return getAbstractDao().queryRawCreateListArgs(where, selectionArg);
    }

    @Override
    public abstract AbstractDao<M, K> getAbstractDao();




}
