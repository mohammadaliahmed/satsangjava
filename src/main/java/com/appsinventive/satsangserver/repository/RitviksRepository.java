package com.appsinventive.satsangserver.repository;

import com.appsinventive.satsangserver.pojo.RitvikMDB;
import com.appsinventive.satsangserver.pojo.RootMDB;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RitviksRepository extends MongoRepository<RitvikMDB,Integer> {

}
