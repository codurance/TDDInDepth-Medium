import {Todo} from "../../src/whatWouldYouTest/types/Todo.ts";
import {NewTodo} from "../../src/whatWouldYouTest/types/NewTodo.ts";

import {ActorBuilder} from "../fixtures/screenplay/actors/ActorBuilder.ts";
import {BrowseTheWeb} from "../fixtures/screenplay/abilities/BrowseTheWeb.ts";
import {ClickUsingMouse} from "../fixtures/screenplay/abilities/ClickUsingMouse.ts";
import {TypeUsingKeyboard} from "../fixtures/screenplay/abilities/TypeUsingKeyboard.ts";
import {VisitTodoPage} from "../fixtures/screenplay/tasks/VisitTodoPage.ts";
import {CreateTodo} from "../fixtures/screenplay/tasks/CreateTodo.ts";
import {WhatTodosAreInToDoColumn} from "../fixtures/screenplay/questions/WhatTodosAreInToDoColumn.ts";

describe("given a user is on the todo page", () => {
    describe("when they create a todo", () => {
        it("then they should see the todo in the `To do` column", () => {
            const todos: Todo[] = []
            cy.intercept({method: "GET", url: "http://localhost:5000/todos"}, (req) => {
                req.reply(todos)
            })

            cy.intercept({method: "POST", url: "http://localhost:5000/todos"}, (req) => {
                const todo = req.body as Todo
                todos.push(todo)
                req.reply(todo)
            });

            const newTodo: NewTodo = {
                title: "New todo",
                description: "New todo description"
            }

            const actor = ActorBuilder
                .anActorCalled("John")
                .whoCan(new BrowseTheWeb(), new ClickUsingMouse(), new TypeUsingKeyboard());

            actor.attemptsTo(new VisitTodoPage());
            actor.attemptsTo(new CreateTodo(newTodo));

            const todosInToDoColumn = actor.asks(new WhatTodosAreInToDoColumn());
            todosInToDoColumn.should("have.length", 1);
            todosInToDoColumn.first().within(() => {
                cy.findByText(newTodo.title).should("be.visible");
                cy.findByText(newTodo.description).should("be.visible");
            });
        })
    })
})