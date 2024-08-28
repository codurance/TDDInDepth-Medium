import React from "react";
import {Todo} from "../types/Todo.ts";
import {NewTodo} from "../types/NewTodo.ts";

export type TodoContextValue = {
    todos: Todo[];
    updateTodo: (todo: Todo) => Promise<void>;
    createTodo: (todo: NewTodo) => Promise<void>;
}

export const TodoContext = React.createContext<TodoContextValue>({} as TodoContextValue);