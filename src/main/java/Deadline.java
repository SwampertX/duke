import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Optional;

public class Deadline extends Task {

    protected LocalDateTime by;

    /**
     * Creates a deadline object.
     * 
     * @param done
     * @param description
     * @param by
     * @throws DateTimeParseException
     */
    public Deadline(boolean done, String description, String by) throws DateTimeParseException {
        super(description);
        this.by = parseTime(by.trim());
        this.isDone = done;
    }

    /**
     * Creates a deadline object.
     * 
     * @param description
     * @param by
     * @throws DateTimeParseException
     */
    public Deadline(String description, String by) throws DateTimeParseException {
        this(false, description, by);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    public String saveFormat() {
        return String.format(" D | %d | %s | %s\n", isDone ? 1 : 0, getDesc(), by);
    }

    /**
     * Takes in an array of string, consist of space-split strings from a saved
     * input. Returns a Deadline object.
     * 
     * @param tokens an array of strings
     * @return an {@link Optional} {@link Deadline}.
     *
     * @throws NumberFormatException  if the number representing done is not 1 or 0
     * @throws DateTimeParseException if the date format is illegal
     */
    public static Deadline fromFormattedString(String[] tokens) throws NumberFormatException, DateTimeParseException {
        boolean done = Integer.parseInt(tokens[1]) == 1;
        Deadline deadline = new Deadline(done, tokens[2], tokens[3]);
        return deadline;
    }
}
