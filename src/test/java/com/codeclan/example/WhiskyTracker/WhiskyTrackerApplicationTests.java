package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetWhiskiesByYear(){
		List<Whisky> foundWhiskies = whiskyRepository.findByYear(2018);
		assertEquals(2, foundWhiskies.size());
	}

	@Test
	public void canGetDistilleriesByRegion(){
		List<Distillery> foundDistilleries = distilleryRepository.findByRegion("Speyside");
		assertEquals(2, foundDistilleries.size());
	}

	@Test
	public void canGetAllWhiskiesFromADistilleryOfASpecificAge(){
		List<Whisky> foundWhiskies = whiskyRepository.findByDistilleryIdAndAge(1L, 12);
		assertEquals(1, foundWhiskies.size());
	}

	@Test
	public void canGetWhiskiesByYear_TheCustomWay(){
		List<Whisky> foundWhiskies = whiskyRepository.getWhiskiesWithYear(2018);
		assertEquals(2, foundWhiskies.size());
	}

	@Test
	public void canGetDistilleriesByRegion_TheCustomWay(){
		List<Distillery> foundWhiskies = distilleryRepository.getDistilleriesFromRegion("Speyside");
		assertEquals(2, foundWhiskies.size());
	}

	@Test
	public void canGetAllWhiskiesFromADistilleryOfASpecificAge_TheCustomWay() {
		List<Whisky> foundWhiskies = whiskyRepository.getWhiskiesFromADistilleryOfASpecificAge(1L, 12);
		assertEquals(1, foundWhiskies.size());
	}

	@Test
	public void canGetAllWhiskiesFromASpecificRegion__TheCustomWay(){
		List<Whisky> foundWhiskies = whiskyRepository.getWhiskiesFromParticularRegion("Highland");
		assertEquals(2, foundWhiskies.size());
	}

	@Test
	public void canGetAllWhiskiesByRegion(){
		List<Whisky> foundWhiskies = whiskyRepository.findByDistilleryRegion("Highland");
		assertEquals(2, foundWhiskies.size());
	}

	@Test
	public void canGetDistilleriesWithWhiskiesOfAge12__TheCustomWay(){
		List<Distillery> foundDistilleries = distilleryRepository.getDistilleriesWithWhiskiesOfAge(12);
		assertEquals(2, foundDistilleries.size());
	}

	@Test
	public void canGetDistilleriesWithWhiskiesOfAge12(){
		List<Distillery> foundDistilleries = distilleryRepository.findByWhiskiesAge(12);
		assertEquals(2, foundDistilleries.size());
	}

}
