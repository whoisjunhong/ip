package duke.commands;

import duke.tasklist.TaskList;
import duke.tasks.Task;

public class UnmarkCommand extends Command {

    /**
     * Mark a task as incomplete
     *
     * @param taskList the list of tasks
     * @param userInput the input from user
     */
    public UnmarkCommand(TaskList taskList, String userInput) {
        try {
            int index = Integer.parseInt(userInput.split(" ")[1]) - 1;
            Task task = taskList.getTasks().get(index);
            task.setIncomplete();
            System.out.println("OK, I've unmarked this task as incomplete:\n" + task);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please enter a number of the item in the list you wish to unmark!");
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Please enter index within range 1 to " + taskList.getTasks().size());
        }
    }
}