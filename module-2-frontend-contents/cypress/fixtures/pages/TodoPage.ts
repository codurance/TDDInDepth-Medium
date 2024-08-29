import {NewTodo} from "../../../src/whatWouldYouTest/types/NewTodo.ts";

export class TodoPage {
    public visit() {
        cy.visit("/todos");
    }

    public createTodo({title, description}: NewTodo) {
        this.openTodoForm();
        this.fillInTitle(title);
        this.fillInDescription(description);
        this.submitTodo()
    }

    public getTodosInToDoColumn() {
        return this.getTodoItems()
    }

    private openTodoForm() {
        cy.findByRole("button", {name: /add todo/i}).click();
    }

    private fillInTitle(title: string) {
        cy.findByRole("textbox", {name: /title/i}).type(title);
    }

    private fillInDescription(description: string) {
        cy.findByRole("textbox", {name: /description/i}).type(description);
    }

    private submitTodo() {
        cy.findByRole("button", {name: /create todo/i}).click();
    }

    private getTodoTitle() {
        return cy.findByRole("heading", {name: "To do"});
    }

    private getTodoItems() {
        return this.getTodoTitle().siblings();
    }
}