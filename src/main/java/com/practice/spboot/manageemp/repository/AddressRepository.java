package com.practice.spboot.manageemp.repository;

import com.practice.spboot.manageemp.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {
}
