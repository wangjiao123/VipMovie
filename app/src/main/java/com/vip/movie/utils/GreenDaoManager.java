package com.vip.movie.utils;

import com.vip.movie.MyApp;
import com.vip.movie.greendao.User;
import com.vip.movie.greendao.gen.DaoMaster;
import com.vip.movie.greendao.gen.DaoSession;
import com.vip.movie.greendao.gen.UserDao;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by T_baby on 17/12/07.
 */

public class GreenDaoManager {
    private UserDao userdao;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private static volatile GreenDaoManager mInstance = null;

    private GreenDaoManager() {
        if (mInstance == null) {
            DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApp.getContext(), "user.db");
            mDaoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
            mDaoSession = mDaoMaster.newSession();
        }
    }

    public static GreenDaoManager getInstance() {
        if (mInstance == null) {
            synchronized (GreenDaoManager.class) {
                if (mInstance == null) {
                    mInstance = new GreenDaoManager();
                }
            }
        }
        return mInstance;
    }

    public DaoMaster getMaster() {
        return mDaoMaster;
    }

    public DaoSession getSession() {
        return mDaoSession;
    }

    public DaoSession getNewSession() {
        mDaoSession = mDaoMaster.newSession();
        return mDaoSession;
    }

    //获取userdao
    public UserDao getUserDao() {
        userdao = this.getNewSession().getUserDao();
        return userdao;
    }

    //数据库添加方法
    public void insert(int type, String name, String pic, String video) {
 
        this.getUserDao().insert(new User(null,type,name, pic, video));

        this.getUserDao().insert(new User(null, type,name, pic, video));
 
    }
    public void insert(User bean) {
        this.getUserDao().insert(bean);
    }
    //数据库全部删除方法
    public void deleteAll(int type) {
        List<User> list = this.getUserDao().loadAll();
        int b = list.size();
        for (int i = b-1; i >= 0; i--) {
            if (list.get(i).getType() == type) {
                this.getUserDao().delete(list.get(i));
            }
        }
    }
    //数据库单个删除
    public void delete(int id) {
        List<User> list = this.getUserDao().loadAll();
        int b = list.size();
        for (int i = b-1; i >= 0; i--) {
            if (list.get(i).getId() == id) {
                this.getUserDao().delete(list.get(i));
            }
        }
    }
    //数据库查找
    public List<User> loadAll(int type){
        List<User> list = this.getUserDao().loadAll();
        List<User> arr=new ArrayList<>();
        int b = list.size();
       for (int i = b-1; i >= 0; i--) {
            if (list.get(i).getType() == type) {
                arr.add(list.get(i));
            }
        }
        return arr;
    }
 
    //数据库查找是否重复
    public boolean isrepetition(String mediaid,int type){
        List<User> list = this.getUserDao().loadAll();
        int b = list.size();
        for (int i = b-1; i >= 0; i--) {
            if (list.get(i).getVideo().equals(mediaid)&&list.get(i).getType()==type) {
                return true;
            }
        }
        return false;
    }

 
}
