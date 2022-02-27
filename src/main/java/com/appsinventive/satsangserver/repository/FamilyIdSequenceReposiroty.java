package com.appsinventive.satsangserver.repository;

import com.appsinventive.satsangserver.pojo.FamilyIDSequence;
import com.appsinventive.satsangserver.pojo.RootMDB;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FamilyIdSequenceReposiroty extends MongoRepository<FamilyIDSequence,Integer> {

}
