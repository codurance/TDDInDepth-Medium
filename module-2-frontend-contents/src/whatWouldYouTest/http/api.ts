import * as axios from "axios";
import {Todo} from "../types/Todo.ts";
import {NewTodo} from "../types/NewTodo.ts";
import {generateId} from "./generateId.ts";

const request = axios.default.create({
    baseURL: "http://localhost:5000",
})

export const getTodosRequest = async () => {
    const {data} = await request.get<Todo[]>("/todos");

    return data;
}

export const updateTodoRequest = async (todo: Todo) => {
    await request.patch(`/todos/${todo.id}`, todo);
}

export const createTodoRequest = async (newTodo: NewTodo) => {
    const todo: Todo = {id: generateId(), status: "todo", ...newTodo,};
    const {data} = await request.post<Todo>("/todos", todo);

    return data;
}