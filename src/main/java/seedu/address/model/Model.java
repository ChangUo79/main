package seedu.address.model;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.date.AthletickDate;
import seedu.address.model.performance.CalendarCompatibleRecord;
import seedu.address.model.performance.Event;
import seedu.address.model.performance.Record;
import seedu.address.model.person.Person;
import seedu.address.model.training.Training;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Person> PREDICATE_SHOW_ALL_PERSONS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAthletickFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setAthletickFilePath(Path athletickFilePath);

    /**
     * Replaces address book data with the data in {@code addressBook}.
     */
    void setAthletick(ReadOnlyAthletick athletick);

    /** Returns Athletick */
    ReadOnlyAthletick getAthletick();
    ReadOnlyAthletick getAthletickDeepCopy();
    void undo();
    void redo();

    /**
     * Returns true if a person with the same identity as {@code person} exists in athletick.
     */
    boolean hasPerson(Person person);

    /**
     * Deletes the given person.
     * The person must exist in the address book.
     */
    void deletePerson(Person target);

    /**
     * Adds the given person.
     * {@code person} must not already exist in Athletick.
     */
    void addPerson(Person person);

    Person selectPerson();

    void storePerson(Person person);

    /**
     * Replaces the given person {@code target} with {@code editedPerson}.
     * {@code target} must exist in Athletick.
     * The person identity of {@code editedPerson} must not be the same as another existing
     * person in Athletick.
     */
    void setPerson(Person target, Person editedPerson);

    /**
     * Reorders Athletick in alphabetical order according to person's name.
     */
    void sortAthletickByName();

    /** Returns an unmodifiable view of the filtered person list */
    ObservableList<Person> getFilteredPersonList();

    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredPersonList(Predicate<Person> predicate);

    /**
     * Add training.
     */
    void addTraining(Training training);

    Training getTrainingOnDate(AthletickDate date);
    HashMap<Person, Boolean> getTrainingAttendanceOnDate(AthletickDate date);

    Attendance getAttendance();
    boolean hasTraining(AthletickDate training);

    /**
     * Replaces performance data with the data in {@code performance}.
     */
    void setPerformance(ReadOnlyPerformance performance);

    void addEvent(Event event);

    boolean hasEvent(Event event);

    ReadOnlyPerformance getPerformance();

    void addRecord(String eventName, Person person, Record record);

    HashMap<Event, List<CalendarCompatibleRecord>> getCalendarCompatiblePerformance(AthletickDate date);

    boolean hasPerformanceOn(AthletickDate date);

}
