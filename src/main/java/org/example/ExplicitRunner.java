package org.example;

import java.util.List;
import java.util.Optional;

public class ExplicitRunner {

    public static void main(String[] args) {
        List<String> stringCommands = List.of(
                "DELETE ALL;",
                "CREATE;NAME=TASK1;DESCRIPTION=SOME DESCRIPTION1;DEADLINE=11.02.2021 20:10;PRIORITY=0",
                "CREATE;NAME=TASK2;DESCRIPTION=SOME DESCRIPTION2;DEADLINE=12.02.2021 20:10;PRIORITY=1",
                "CREATE;NAME=TASK3;DESCRIPTION=SOME DESCRIPTION3;DEADLINE=12.02.2021 20:10;PRIORITY=2",
                "CREATE;NAME=TASK4;DESCRIPTION=SOME DESCRIPTION4;DEADLINE=14.02.2021 20:10;PRIORITY=3",
                "CREATE;NAME=TASK5;DESCRIPTION=SOME DESCRIPTION5;DEADLINE=14.02.2021 20:10;PRIORITY=4",
                "READ;NAME=TASK5",
                "COMPLETED;NAME=TASK1",
                "READ ALL;",
                "UPDATE;NAME=TASK2;DESCRIPTION=SOME DESCRIPTION NEW;DEADLINE=12.02.2021 10:10;PRIORITY=81",
                "READ ALL;",
                "READ ALL;SORT=DEADLINE,DESC",
                "COMPLETED;NAME=TASK3",
                "READ ALL;",
                "READ GROUPED;",
                "DELETE;NAME=TASK2",
                "READ ALL;"
        );

        CommandBuilder commandBuilder = new CommandBuilder();
        List<Command> commands = stringCommands.stream()
                .map(commandBuilder::buildCommand)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
        DatabaseRunner databaseRunner = new DatabaseRunner();
        commands.forEach(databaseRunner::run);
    }
}

