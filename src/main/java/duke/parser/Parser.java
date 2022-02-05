package duke.parser;

import java.util.Locale;

import duke.commands.AddDeadlineCommand;
import duke.commands.AddEventCommand;
import duke.commands.AddToDoCommand;
import duke.commands.FindCommand;
import duke.commands.ListCommand;
import duke.commands.MarkCommand;
import duke.commands.RemoveCommand;
import duke.commands.UnmarkCommand;
import duke.exceptions.DukeException;
import duke.tasklist.TaskList;


public class Parser {

    /**
     * Process and validate user input to instantiate intended class
     *
     * @param commandType the type of task
     * @param userInput the input from the user
     * @param taskList the list of tasks
     * @throws DukeException if input from user is invalid
     */
    public static void processUserInput(CommandType commandType, String userInput,
                                        TaskList taskList) throws DukeException {
        switch (commandType) {
        case LIST:
            new ListCommand(taskList);
            break;
        case MARK:
            new MarkCommand(taskList, userInput);
            break;
        case UNMARK:
            new UnmarkCommand(taskList, userInput);
            break;
        case DEADLINE:
            new AddDeadlineCommand(taskList, userInput);
            break;
        case EVENT:
            new AddEventCommand(taskList, userInput);
            break;
        case TODO:
            new AddToDoCommand(taskList, userInput);
            break;
        case REMOVE:
            new RemoveCommand(taskList, userInput);
            break;
        case FIND:
            new FindCommand(taskList, userInput);
            break;
        case BYE:
            break;
        default:
            throw new DukeException("Invalid input");
        }
    }

    /**
     * Types of valid commands
     */
    public enum CommandType {
        LIST, MARK, UNMARK, TODO, DEADLINE, EVENT, REMOVE, FIND, BYE, NULL
    }

    /**
     * Converts user input into a valid command type
     *
     * @param userInput the input from user
     */
    public static CommandType getCommandType(String userInput) {
        String command = userInput.split(" ")[0].toLowerCase(Locale.ROOT);

        switch (command) {
        case "list":
            return CommandType.LIST;
        case "mark":
            return CommandType.MARK;
        case "unmark":
            return CommandType.UNMARK;
        case "todo":
            return CommandType.TODO;
        case "deadline":
            return CommandType.DEADLINE;
        case "event":
            return CommandType.EVENT;
        case "remove":
            return CommandType.REMOVE;
        case "find":
            return CommandType.FIND;
        case "bye":
            return CommandType.BYE;
        default:
            return CommandType.NULL;
        }
    }
}
