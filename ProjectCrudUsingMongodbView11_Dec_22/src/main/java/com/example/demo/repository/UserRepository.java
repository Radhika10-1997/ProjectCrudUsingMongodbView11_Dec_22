package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.yaml.snakeyaml.events.Event.ID;

import com.example.demo.domain.User;

public interface UserRepository extends MongoRepository<User, Integer>{

	void deleteById(int id);

	User findById(int id);

	List<User> findAllById(List<Integer> q);
	
	@Query("{'id':?0 , 'userName' : ?1}")
	User findparameter(int id, String userName);
    //@Query(value = "{'userId':{$in:?0}}")

	@Query("{'id':{$in:?0}}")
	User FindSortedUser(List<Integer> uids, Sort sort);
	
	List<User> findByIdIn(List<Integer> uids, Sort sort);
	
  //  @Query(value="{'id':?0,'userName':{$exist:true}}",delete = true)
    @Query(value="{'id':?0}",delete = true)
	void deleteUserById(int id);

	User findByUserName(String userName);

	User findByIdAndUserName(int id, String userName);
	
	
	@Query(value="{'id':?0,'userName':?1}")
	User findUserByIdAndUserNames(int id, String userName);
	

	@Query("update({_id:ObectId('$1')},{$set:{password:$2},{userName:$3}})")
	List<User> updateUser(int id, String password, String userName);

	
	/*@Aggregation(pipeline = {"{$match:{id:?0}","$sort:{date:1}}","{$limit:1}"})
	List<User> findUserList(int id);
    @Query(value = "{'type': {$exists : false}}, {$set: {'type': 'FILE'}}, {multi: true}")
*/

}
