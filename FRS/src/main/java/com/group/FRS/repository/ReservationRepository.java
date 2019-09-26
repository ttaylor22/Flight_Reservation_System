package com.group.FRS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.group.FRS.model.Reservation;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	@Query(value="select * from Reservation where user_profile_id = :userProfileId limit 1", nativeQuery=true)
	Reservation findAllReservations(@Param("userProfileId") Long id);
	
}

