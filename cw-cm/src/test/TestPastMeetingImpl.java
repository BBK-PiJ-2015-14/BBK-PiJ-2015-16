package test;

import org.junit.Before;
import org.junit.Test;
import spec.Contact;
import spec.PastMeeting;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests the PastMeetingImpl implementation of the PastMeeting interface
 */

public class TestPastMeetingImpl {

    PastMeeting testMeeting;
    Set<Contact> attendees;

    @Before
    public void createTestMeeting() {
        attendees = new HashSet<Contact>();
        attendees.add(new ContactImpl(1, "Bob", "A bloke."));
        attendees.add(new ContactImpl(2, "Fred", "Another bloke."));

        Calendar date = new GregorianCalendar(1985, 03, 13);

        testMeeting = new PastMeetingImpl(1, date, attendees, "");
    }

    @Test
    public void testID() {
        assertEquals(1, testMeeting.getId());
    }

    @Test
    public void testDate() {
        assertEquals(new GregorianCalendar(1985, 03, 13), testMeeting.getDate());
    }

    @Test
    public void testContacts() {
        assertEquals(attendees, testMeeting.getContacts());
    }

    @Test
    public void testGetNotesNoNotes() {
        assertEquals("", testMeeting.getNotes());
    }

    @Test
    public void testGetNotes() {
        Calendar date = new GregorianCalendar(1985, 03, 13);
        PastMeeting past = new PastMeetingImpl(1, date, attendees, "Some notes");
        assertEquals("Some notes", past.getNotes());
    }

    @Test
    public void testEqualsSameNoNotes() {
        Set<Contact> attendees2 = new HashSet<Contact>();
        attendees2.add(new ContactImpl(1, "Bob", "A bloke."));
        attendees2.add(new ContactImpl(2, "Fred", "Another bloke."));

        Calendar date2 = new GregorianCalendar(1985, 03, 13);

        PastMeeting meeting2 = new PastMeetingImpl(1, date2, attendees2, "");

        assertTrue(meeting2.equals(testMeeting));
    }

    @Test
    public void testEqualsSameNotesSame() {
        Calendar date1 = new GregorianCalendar(1985, 03, 13);
        Set<Contact> attendees1 = new HashSet<Contact>();
        attendees1.add(new ContactImpl(1, "Bob", "A bloke."));
        attendees1.add(new ContactImpl(2, "Fred", "Another bloke."));

        PastMeeting meeting1 = new PastMeetingImpl(1, date1, attendees1, "Notes");

        Set<Contact> attendees2 = new HashSet<Contact>();
        attendees2.add(new ContactImpl(1, "Bob", "A bloke."));
        attendees2.add(new ContactImpl(2, "Fred", "Another bloke."));

        Calendar date2 = new GregorianCalendar(1985, 03, 13);

        PastMeeting meeting2 = new PastMeetingImpl(1, date2, attendees2, "Notes");

        assertTrue(meeting2.equals(meeting1));
    }

    @Test
    public void testEqualsNotesDifferent() {
        Calendar date1 = new GregorianCalendar(1985, 03, 13);
        Set<Contact> attendees1 = new HashSet<Contact>();
        attendees1.add(new ContactImpl(1, "Bob", "A bloke."));
        attendees1.add(new ContactImpl(2, "Fred", "Another bloke."));
        PastMeeting meeting1 = new PastMeetingImpl(1, date1, attendees1, "Notes 1");

        Set<Contact> attendees2 = new HashSet<Contact>();
        attendees2.add(new ContactImpl(1, "Bob", "A bloke."));
        attendees2.add(new ContactImpl(2, "Fred", "Another bloke."));

        Calendar date2 = new GregorianCalendar(1985, 03, 13);

        PastMeeting meeting2 = new PastMeetingImpl(1, date2, attendees2, "Notes 2");

        assertFalse(meeting2.equals(meeting1));
    }

    @Test
    public void testEqualsDateDifferent() {
        Set<Contact> attendees2 = new HashSet<Contact>();
        attendees2.add(new ContactImpl(1, "Bob", "A bloke."));
        attendees2.add(new ContactImpl(2, "Fred", "Another bloke."));

        Calendar date2 = new GregorianCalendar(1985, 04, 13);

        PastMeeting meeting2 = new PastMeetingImpl(1, date2, attendees2, "");

        assertFalse(meeting2.equals(testMeeting));
    }

    @Test
    public void testEqualsAttendeesDifferent() {
        Set<Contact> attendees2 = new HashSet<Contact>();
        attendees2.add(new ContactImpl(1, "Bob", "A bloke."));
        attendees2.add(new ContactImpl(2, "Freeda", "Another bloke."));

        Calendar date2 = new GregorianCalendar(1985, 03, 13);

        PastMeeting meeting2 = new PastMeetingImpl(1, date2, attendees2, "");

        assertFalse(meeting2.equals(testMeeting));
    }

    @Test
    public void testEqualsIdsDifferent() {
        Set<Contact> attendees2 = new HashSet<Contact>();
        attendees2.add(new ContactImpl(1, "Bob", "A bloke."));
        attendees2.add(new ContactImpl(2, "Fred", "Another bloke."));

        Calendar date2 = new GregorianCalendar(1985, 03, 13);

        PastMeeting meeting2 = new PastMeetingImpl(2, date2, attendees2, "");

        assertFalse(meeting2.equals(testMeeting));
    }

    @Test
    public void testEqualsDifferentObject() {
        assertFalse(testMeeting.equals("An object"));
    }

    @Test
    public void testConstructorMeetingAndNotes() {
        Set<Contact> attendees2 = new HashSet<Contact>();
        attendees2.add(new ContactImpl(1, "Bob", "A bloke."));
        attendees2.add(new ContactImpl(2, "Fred", "Another bloke."));

        Calendar date2 = new GregorianCalendar(1985, 03, 13);

        PastMeeting past = new PastMeetingImpl(1, date2, attendees, "Notes.");
        PastMeeting past2 = new PastMeetingImpl(testMeeting, "Notes.");
        assertTrue(past2.equals(past));
    }

    @Test
    public void testConstructorSeparateNotesNull() {
        Calendar date2 = new GregorianCalendar(1985, 03, 13);

        PastMeeting past = new PastMeetingImpl(1, date2, attendees, null);
        assertEquals("", past.getNotes());
    }

    @Test
    public void testConstructorMeetingAndNotesNull() {
        Calendar date2 = new GregorianCalendar(1985, 03, 13);
        Meeting past = new PastMeetingImpl(1, date2, attendees, "Notes.");
        PastMeeting past2 = new PastMeetingImpl(past, null);
        assertEquals("", past2.getNotes());
    }

    @Test
    public void testConstructorSeparate() //This assume objects are the same if notes are set as "" or not specified
    {
        Set<Contact> attendees2 = new HashSet<Contact>();
        attendees2.add(new ContactImpl(1, "Bob", "A bloke."));
        attendees2.add(new ContactImpl(2, "Fred", "Another bloke."));

        Calendar date2 = new GregorianCalendar(1985, 03, 13);

        PastMeeting meeting2 = new PastMeetingImpl(1, date2, attendees2, "");

        assertTrue(meeting2.equals(testMeeting));
    }

    @Test
    public void testConstructorEqualsSeparateNotesNull() //This assume objects are the same if notes are set as null or not specified
    {
        Set<Contact> attendees2 = new HashSet<Contact>();
        attendees2.add(new ContactImpl(1, "Bob", "A bloke."));
        attendees2.add(new ContactImpl(2, "Fred", "Another bloke."));

        Calendar date2 = new GregorianCalendar(1985, 03, 13);

        PastMeeting meeting2 = new PastMeetingImpl(1, date2, attendees2, null);

        assertTrue(meeting2.equals(testMeeting));
    }


}
