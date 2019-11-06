package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.model.Athletick;
import seedu.address.model.Model;
import seedu.address.model.Performance;

/**
 * Clears the address book.
 */
public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "Address book has been cleared!";
    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.setAthletick(new Athletick());
        model.setPerformance(new Performance());
        return new CommandResult(MESSAGE_SUCCESS, false, false, true, model);
    }
    @Override
    public boolean isUndoable() {
        return true;
    }
}
