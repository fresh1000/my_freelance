package lab5;

import static org.junit.Assert.*;

import org.junit.Test;
import balloon.Balloon;
/**
 * 
 * Version balloon and balloon4 don't have bugs.
 * In version balloon1 invalid work method isPopped and radius after popped.
 * In version balloon2 invalid work method radius after popped.
 * In version balloon3 invalid work method isPopped, radius after blow 10 and radius after popped.
 *
 */
public class BalloonUnitTests {
	/**
	 * Test blow 5 balloon
	 */
	@Test
	public void testBlow() {
		Balloon balloon = new Balloon(10);
		balloon.blow(7);
		assertEquals(7, balloon.getRadius());
	}
	
	/**
	 * Test pop balloon
	 */
	@Test
	public void testPop() {
		Balloon balloon = new Balloon(10);
		balloon.pop();
		assertEquals(true, balloon.isPopped());
	}
	
	/**
	 * Test deflate balloon
	 */
	@Test
	public void testDeflate() {
		Balloon balloon = new Balloon(10);
		balloon.blow(5);
		balloon.blow(5);
		balloon.deflate();
		assertEquals(0, balloon.getRadius());
	}
	
	/**
	 * Test radius after popped
	 * This test don't work on version: ballon1, balloon2, balloon3
	 */
	@Test
	public void testRadiusAfterPopped() {
		Balloon balloon = new Balloon(10);
		balloon.blow(5);
		balloon.blow(5);
		balloon.blow(5);
		balloon.blow(5);
		assertEquals(0, balloon.getRadius());
	}
	
	/**
	 * Test start popped 
	 */
	@Test
	public void testStartPopped() {
		Balloon balloon = new Balloon(10);
		assertEquals(false, balloon.isPopped());
	}
	
	/**
	 * Test start radius
	 */
	@Test
	public void testStartRadius() {
		Balloon balloon = new Balloon(10);
		assertEquals(0, balloon.getRadius());
	}
	
	/**
	 * Test radius after blow 10
	 * This test don't work on version: balloon3
	 */
	@Test
	public void testRadiusAfterBlow10() {
		Balloon balloon = new Balloon(10);
		balloon.blow(5);
		balloon.blow(5);
		assertEquals(10, balloon.getRadius());
	}
	
	/**
	 * Test popped after blow 10
	 */
	@Test
	public void testPoppedFirst() {
		Balloon balloon = new Balloon(10);
		balloon.blow(5);
		balloon.blow(5);
		assertEquals(false, balloon.isPopped());
	}
	
	/**
	 * Test popped after blow 15
	 * This test don't work on version: ballon1, balloon3
	 */
	@Test
	public void testPoppedSecond() {
		Balloon balloon = new Balloon(10);
		balloon.blow(5);
		balloon.blow(5);
		balloon.blow(5);
		assertEquals(true, balloon.isPopped());
	}

}
