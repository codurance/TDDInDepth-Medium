import {Todo} from "../../src/whatWouldYouTest/types/Todo.ts";
import {NewTodo} from "../../src/whatWouldYouTest/types/NewTodo.ts";
import {TodoPage} from "../fixtures/pages/TodoPage.ts";

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

            const todoPage = new TodoPage();

            todoPage.visit();

            const newTodo : NewTodo = {
                title: "New todo",
                description: "New todo description"
            }
            todoPage.createTodo(newTodo);

            const todoItems = todoPage.getTodosInToDoColumn();

            todoItems.should("have.length", 1);
            todoItems.first().within(() => {
                cy.findByText(newTodo.title).should("be.visible");
                cy.findByText(newTodo.description).should("be.visible");
            });
        })
    })
})