package com.oauth2.googleapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oauth2.googleapi.model.Flights;

public interface FlightsRepo extends JpaRepository<Flights, String>
{

}
