package com.study.spring.store;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IStoreDao {

	@Select("select * from store order by id desc")
	List<StoreDto> findAll();

	@Select("select * from Menu order by id desc")
	List<MenuDto> findMenuAll();

	@Select("select * from store where id=#{id}")
	StoreDto storeview(Long id);

	@Select("select * from menu where id=#{id}")
	MenuDto menuview(Long id);

	@Select("insert into store(name,addr) values(#{name},#{addr})")
	void createStore(StoreDto request);

}
