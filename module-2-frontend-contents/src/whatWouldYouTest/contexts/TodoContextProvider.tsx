import {PropsWithChildren} from "react";
import {TodoContext} from "./TodoContext.ts";
import {Todo} from "../types/Todo.ts";
import {NewTodo} from "../types/NewTodo.ts";
import {createTodoRequest, getTodosRequest, updateTodoRequest} from "../http/api.ts";
import {useMutation, useQuery} from "@tanstack/react-query";
import {QUERY_KEYS} from "../../lib/react-query";


export const TodoContextProvider = ({children}: PropsWithChildren) => {
    const {data, refetch} = useQuery({queryKey: [QUERY_KEYS.GET_TODOS], queryFn: getTodosRequest});
    const {mutateAsync: createTodoMutation} = useMutation({mutationFn: createTodoRequest});
    const {mutateAsync: updateTodoMutation} = useMutation({mutationFn: updateTodoRequest});


    const updateTodo = async (todo: Todo) => {
        await updateTodoMutation(todo);
        await refetch();
    };

    const createTodo = async (newTodo: NewTodo) => {
        try {
            await createTodoMutation(newTodo);
            await refetch()
        } catch (error) {
            console.log(error)
        }

    }

    return (
        <TodoContext.Provider value={{
            todos: data ?? [],
            updateTodo,
            createTodo,
        }}>
            {children}
        </TodoContext.Provider>
    )
}