import {Task} from "../tasks/Task.ts";
import {Question} from "../questions/Question.ts";
import {Ability} from "../abilities/Ability.ts";

export class Actor {
    constructor(public name: string, public abilities: Ability[]) {
    }

    public attemptsTo(task: Task) {
        task.performAs(this);
    };

    public asks<T>(question: Question<T>): T {
        return question.askedBy(this);
    }
}

