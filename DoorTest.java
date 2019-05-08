

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DoorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DoorTest
{
    private Room room1;
    private Room room2;
    private Door door1;

    /**
     * Default constructor for test class DoorTest
     */
    public DoorTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        room1 = new Room("roomA");
        room2 = new Room("RoomB");
        door1 = new Door(room1, room2);
        door1.getRoomFromTheOtherSideOf(room1);
        door1.getRoomFromTheOtherSideOf(room2);
        door1.open();
        door1.close();
        door1.isClosed();
        door1.isOpen();
        door1.open();
        door1.isClosed();
        Door.makeDoor(room1, room2, "room1", "room2");
        Door.makeDoor(room1, room2, "north", "south");
        Door.makeDoor(room1, room2, "west", "east");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
