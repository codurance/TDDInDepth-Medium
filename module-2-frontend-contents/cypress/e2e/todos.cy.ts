import {Todo} from "../../src/whatWouldYouTest/types/Todo.ts";

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

            cy.visit("/todos");

            cy.findByRole("button", {name: /add todo/i}).click();

            cy.findByRole("textbox", {name: /title/i}).type("New todo");
            cy.findByRole("textbox", {name: /description/i}).type("New todo description");

            cy.findByRole("button", {name: /create todo/i}).click();

            const todoTitle = cy.findByRole("heading", {name: "To do"});
            const todoItems = todoTitle.siblings();
            todoItems.should("have.length", 1);
            todoItems.first().within(() => {
                cy.findByText("New todo").should("be.visible");
                cy.findByText("New todo description").should("be.visible");
            });
        })
    })
})