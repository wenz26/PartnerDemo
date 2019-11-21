package com.cwz.springboot.myparnet.service;

import com.cwz.springboot.myparnet.entity.Zan;

import java.util.List;

public interface ZanService {
    boolean findUser(String username);

    int addUser(Zan zan);

    int deleteUser(String username);

    int getCount(Zan zan);

    List<Zan> getZan();
}
