package com.appsinventive.satsangserver.repository;

import com.appsinventive.satsangserver.pojo.RootMDB;
import com.appsinventive.satsangserver.pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<RootMDB,Integer> {

}
