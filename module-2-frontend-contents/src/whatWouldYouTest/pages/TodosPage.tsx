import React, {useContext} from 'react';
import Box from '@mui/material/Box';
import Container from '@mui/material/Container';
import Typography from '@mui/material/Typography';
import {TodoContext} from "../contexts/TodoContext.ts";
import {TodoList} from "../components/TodoList.tsx";
import {TodoForm} from "../components/TodoForm.tsx";

const TodosPage: React.FC = () => {
    const {todos} = useContext(TodoContext);

    return (
        <Container sx={{minHeight: "100vh", display: "flex", flexDirection: "column", padding: "2rem"}}>
            <Typography component="h1" variant="h2" sx={{marginBottom: "1rem"}}>
                To Do List
            </Typography>
            <Box sx={{display: 'flex', gap: "1rem", flex: 1}}>
                <TodoList todos={todos.filter(todo => todo.status === 'todo')} title="To do"/>
                <TodoList todos={todos.filter(todo => todo.status === 'doing')} title="Doing"/>
                <TodoList todos={todos.filter(todo => todo.status === 'done')} title="Done"/>
            </Box>
            <TodoForm/>
        </Container>
    );
};

export default TodosPage;

